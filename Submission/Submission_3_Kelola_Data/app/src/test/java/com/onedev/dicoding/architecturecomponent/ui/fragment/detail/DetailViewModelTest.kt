package com.onedev.dicoding.architecturecomponent.ui.fragment.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.onedev.dicoding.architecturecomponent.data.source.MovieRepository
import com.onedev.dicoding.architecturecomponent.data.source.local.entity.MovieEntity
import com.onedev.dicoding.architecturecomponent.data.source.local.entity.TvShowEntity
import com.onedev.dicoding.architecturecomponent.ui.activity.detail.DetailViewModel
import com.onedev.dicoding.architecturecomponent.utils.DataDummy
import com.onedev.dicoding.architecturecomponent.vo.Resource
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailViewModelTest {

    private lateinit var viewModel: DetailViewModel

    private val dummyMovie = Resource.success(DataDummy.getMovies()[0])
    private val dummyMovieId = dummyMovie.data?.id

    private val dummyTvShow = Resource.success(DataDummy.getTvShows()[0])
    private val dummyTvShowId = dummyTvShow.data?.id

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieRepository: MovieRepository

    @Mock
    private lateinit var movieDetailObserver: Observer<Resource<MovieEntity>>

    @Mock
    private lateinit var tvShowDetailObserver: Observer<Resource<TvShowEntity>>

    // Get Data Movie Testing
    @Before
    fun setUpMovie() {
        viewModel = DetailViewModel(movieRepository)
    }

    @Test
    fun getMovieDetail() {
        val movie = MutableLiveData<Resource<MovieEntity>>()
        movie.value = dummyMovie

        `when`(dummyMovieId?.let { movieRepository.getDetailMovie(it) }).thenReturn(movie)
        val detailEntity = dummyMovieId?.let { viewModel.getDetailMovie(it).value?.data }
        dummyMovieId?.let { verify(movieRepository).getDetailMovie(it) }

        assertNotNull(detailEntity)
        assertEquals(dummyMovie.data?.genres, detailEntity?.genres)
        assertEquals(dummyMovie.data?.id, detailEntity?.id)
        assertEquals(dummyMovie.data?.overview, detailEntity?.overview)
        assertEquals(dummyMovie.data?.popularity, detailEntity?.popularity)
        assertEquals(dummyMovie.data?.poster_path, detailEntity?.poster_path)
        assertEquals(dummyMovie.data?.release_date, detailEntity?.release_date)
        assertEquals(dummyMovie.data?.runtime, detailEntity?.runtime)
        assertEquals(dummyMovie.data?.status, detailEntity?.status)
        assertEquals(dummyMovie.data?.tagline, detailEntity?.tagline)
        assertEquals(dummyMovie.data?.title, detailEntity?.title)
        assertEquals(dummyMovie.data?.vote_average, detailEntity?.vote_average)

        dummyMovieId?.let { viewModel.getDetailMovie(it).observeForever(movieDetailObserver) }
        verify(movieDetailObserver).onChanged(dummyMovie)
    }

    @Test
    fun getTvShowDetail() {
        val tvShow = MutableLiveData<Resource<TvShowEntity>>()
        tvShow.value = dummyTvShow

        `when`(dummyTvShowId?.let { movieRepository.getDetailTvShow(it) }).thenReturn(tvShow)
        val detailEntity = dummyTvShowId?.let { viewModel.getDetailTvShow(it).value?.data }
        if (dummyTvShowId != null) {
            verify(movieRepository).getDetailTvShow(dummyTvShowId)
        }

        assertNotNull(detailEntity)
        assertEquals(dummyTvShow.data?.genres, detailEntity?.genres)
        assertEquals(dummyTvShow.data?.id, detailEntity?.id)
        assertEquals(dummyTvShow.data?.overview, detailEntity?.overview)
        assertEquals(dummyTvShow.data?.popularity, detailEntity?.popularity)
        assertEquals(dummyTvShow.data?.poster_path, detailEntity?.poster_path)
        assertEquals(dummyTvShow.data?.status, detailEntity?.status)
        assertEquals(dummyTvShow.data?.tagline, detailEntity?.tagline)
        assertEquals(dummyTvShow.data?.vote_average, detailEntity?.vote_average)

        if (dummyTvShowId != null) {
            viewModel.getDetailTvShow(dummyTvShowId).observeForever(tvShowDetailObserver)
        }
        verify(tvShowDetailObserver).onChanged(dummyTvShow)
    }

}