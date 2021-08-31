package com.onedev.dicoding.architecturecomponent.ui.fragment.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import com.nhaarman.mockitokotlin2.verify
import com.onedev.dicoding.architecturecomponent.BuildConfig
import com.onedev.dicoding.architecturecomponent.data.source.MovieRepository
import com.onedev.dicoding.architecturecomponent.data.source.remote.response.MovieDetailResponse
import com.onedev.dicoding.architecturecomponent.data.source.remote.response.MovieResponseResult
import com.onedev.dicoding.architecturecomponent.data.source.remote.response.TvShowDetailResponse
import com.onedev.dicoding.architecturecomponent.data.source.remote.response.TvShowResponseResult
import com.onedev.dicoding.architecturecomponent.ui.activity.detail.DetailViewModel
import com.onedev.dicoding.architecturecomponent.utils.FakeJsonHelper
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailViewModelTest {

    private lateinit var viewModel: DetailViewModel
    private lateinit var jsonHelper: FakeJsonHelper
    private val apiKey = BuildConfig.API_KEY

    @get:Rule
    var instanceTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieRepository: MovieRepository

    @Before
    fun setup() {
        viewModel = DetailViewModel(movieRepository)
        jsonHelper = FakeJsonHelper()
    }

    @Test
    fun getMovieDetail() {
        val movieId = MutableLiveData<Int>()
        jsonHelper.getPopularMovie(apiKey, 1, object : FakeJsonHelper.GetPopularMovieCallback {
            override fun getPopularMovieCallback(listMovieResponseResult: List<MovieResponseResult>) {
                movieId.value = listMovieResponseResult[0].id
            }
        })
        delayTwoSecond()

        val movieDetail = MutableLiveData<MovieDetailResponse>()
        movieId.value?.let {
            jsonHelper.getDetailMovie(it, apiKey, object : FakeJsonHelper.GetDetailMovieCallback {
                override fun getDetailMovieCallback(movieDetailResponse: MovieDetailResponse) {
                    movieDetail.value = movieDetailResponse
                }
            })
        }
        delayTwoSecond()

        `when`(movieId.value?.let { movieRepository.getDetailMovie(it, apiKey) }).thenReturn(movieDetail)

        val movieEntities = movieId.value?.let { viewModel.getDetailMovie(it).value }

        movieId.value?.let { verify(movieRepository).getDetailMovie(it, apiKey) }

        assertNotNull(movieEntities)
        assertEquals(movieDetail.value?.genres, movieEntities?.genres)
        assertEquals(movieDetail.value?.id, movieEntities?.id)
        assertEquals(movieDetail.value?.overview, movieEntities?.overview)
        assertEquals(movieDetail.value?.popularity, movieEntities?.popularity)
        assertEquals(movieDetail.value?.poster_path, movieEntities?.poster_path)
        assertEquals(movieDetail.value?.production_companies, movieEntities?.production_companies)
        assertEquals(movieDetail.value?.release_date, movieEntities?.release_date)
        assertEquals(movieDetail.value?.runtime, movieEntities?.runtime)
        assertEquals(movieDetail.value?.status, movieEntities?.status)
        assertEquals(movieDetail.value?.tagline, movieEntities?.tagline)
        assertEquals(movieDetail.value?.title, movieEntities?.title)
        assertEquals(movieDetail.value?.vote_average, movieEntities?.vote_average)
    }

    @Test
    fun getTvShowDetail() {
        val tvShowId = MutableLiveData<Int>()
        jsonHelper.getPopularTvShow(apiKey, 1, object : FakeJsonHelper.GetPopularTvShowCallback {
            override fun getPopularTvShowCallback(listTvShowResponse: List<TvShowResponseResult>) {
                tvShowId.value = listTvShowResponse[0].id
            }
        })
        delayTwoSecond()

        val tvShowDetail = MutableLiveData<TvShowDetailResponse>()
        tvShowId.value?.let {
            jsonHelper.getDetailTvShow(it, apiKey, object : FakeJsonHelper.GetDetailTvShowCallback {
                override fun getDetailTvShowCallback(tvShowDetailResponse: TvShowDetailResponse) {
                    tvShowDetail.value = tvShowDetailResponse
                }
            })
        }
        delayTwoSecond()

        `when`(tvShowId.value?.let { movieRepository.getDetailTvShow(it, apiKey) }).thenReturn(tvShowDetail)

        val tvShowEntities = tvShowId.value?.let { viewModel.getDetailTvShow(it).value }

        tvShowId.value?.let { verify(movieRepository).getDetailTvShow(it, apiKey) }

        assertNotNull(tvShowEntities)
        assertEquals(tvShowDetail.value?.genres, tvShowEntities?.genres)
        assertEquals(tvShowDetail.value?.id, tvShowEntities?.id)
        assertEquals(tvShowDetail.value?.name, tvShowEntities?.name)
        assertEquals(tvShowDetail.value?.overview, tvShowEntities?.overview)
        assertEquals(tvShowDetail.value?.id, tvShowEntities?.id)
        assertEquals(tvShowDetail.value?.popularity, tvShowEntities?.popularity)
        assertEquals(tvShowDetail.value?.poster_path, tvShowEntities?.poster_path)
        assertEquals(tvShowDetail.value?.name, tvShowEntities?.name)
        assertEquals(tvShowDetail.value?.production_companies, tvShowEntities?.production_companies)
        assertEquals(tvShowDetail.value?.status, tvShowEntities?.status)
        assertEquals(tvShowDetail.value?.tagline, tvShowEntities?.tagline)
        assertEquals(tvShowDetail.value?.vote_average, tvShowEntities?.vote_average)
    }

    private fun delayTwoSecond() {
        try {
            Thread.sleep(2000)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }
    }
}