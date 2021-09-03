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

    private val dummyMovie = DataDummy.getMovies()[0]
    private val dummyMovieId = dummyMovie.id

    private val dummyTvShow = DataDummy.getTvShows()[0]
    private val dummyTvShowId = dummyTvShow.id

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieRepository: MovieRepository

    @Mock
    private lateinit var movieDetailObserver: Observer<Resource<MovieEntity>>

    @Mock
    private lateinit var tvShowDetailObserver: Observer<Resource<TvShowEntity>>

    @Before
    fun setUpMovie() {
        viewModel = DetailViewModel(movieRepository)
    }

    @Test
    fun getMovieDetail() {
        val dummyDetailMovie = Resource.success(dummyMovie)
        val movie = MutableLiveData<Resource<MovieEntity>>()
        movie.value = dummyDetailMovie

        `when`(movieRepository.getDetailMovie(dummyMovieId)).thenReturn(movie)

        val detailEntity = viewModel.getDetailMovie(dummyMovieId).value?.data
        verify(movieRepository).getDetailMovie(dummyMovieId)

        assertNotNull(detailEntity)
        assertEquals(dummyMovie.genres, detailEntity?.genres)
        assertEquals(dummyMovie.id, detailEntity?.id)
        assertEquals(dummyMovie.overview, detailEntity?.overview)
        assertEquals(dummyMovie.popularity, detailEntity?.popularity)
        assertEquals(dummyMovie.poster_path, detailEntity?.poster_path)
        assertEquals(dummyMovie.release_date, detailEntity?.release_date)
        assertEquals(dummyMovie.runtime, detailEntity?.runtime)
        assertEquals(dummyMovie.status, detailEntity?.status)
        assertEquals(dummyMovie.tagline, detailEntity?.tagline)
        assertEquals(dummyMovie.title, detailEntity?.title)
        assertEquals(dummyMovie.vote_average, detailEntity?.vote_average)

        viewModel.getDetailMovie(dummyMovieId).observeForever(movieDetailObserver)
        verify(movieDetailObserver).onChanged(dummyDetailMovie)
    }

    @Test
    fun getTvShowDetail() {
        val dummyDetailTvShow = Resource.success(dummyTvShow)
        val tvShow = MutableLiveData<Resource<TvShowEntity>>()
        tvShow.value = dummyDetailTvShow

        `when`(movieRepository.getDetailTvShow(dummyTvShowId)).thenReturn(tvShow)

        val detailEntity = viewModel.getDetailTvShow(dummyTvShowId).value?.data
        verify(movieRepository).getDetailTvShow(dummyTvShowId)

        assertNotNull(detailEntity)
        assertEquals(dummyTvShow.genres, detailEntity?.genres)
        assertEquals(dummyTvShow.id, detailEntity?.id)
        assertEquals(dummyTvShow.overview, detailEntity?.overview)
        assertEquals(dummyTvShow.popularity, detailEntity?.popularity)
        assertEquals(dummyTvShow.poster_path, detailEntity?.poster_path)
        assertEquals(dummyTvShow.status, detailEntity?.status)
        assertEquals(dummyTvShow.tagline, detailEntity?.tagline)
        assertEquals(dummyTvShow.vote_average, detailEntity?.vote_average)

        viewModel.getDetailTvShow(dummyTvShowId).observeForever(tvShowDetailObserver)
        verify(tvShowDetailObserver).onChanged(dummyDetailTvShow)
    }
}