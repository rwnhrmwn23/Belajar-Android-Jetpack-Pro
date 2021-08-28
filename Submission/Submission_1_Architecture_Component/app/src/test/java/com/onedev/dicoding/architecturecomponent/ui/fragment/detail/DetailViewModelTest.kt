package com.onedev.dicoding.architecturecomponent.ui.fragment.detail

import com.onedev.dicoding.architecturecomponent.helper.DataDummy
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class DetailViewModelTest {

    private lateinit var viewModel: DetailViewModel
    private val dummyMovies = DataDummy.generateDataDummyMovies()[0]
    private val dummyTvShow = DataDummy.generateDataDummyTvShows()[0]
    private val movieId = dummyMovies.movie_id
    private val tvShowId = dummyTvShow.tv_show_id

    @Before
    fun setup() {
        viewModel = DetailViewModel()
        viewModel.setSelectedMovie(movieId)
        viewModel.setSelectedTvShow(tvShowId)
    }

    @Test
    fun getMovie() {
        viewModel.setSelectedMovie(dummyMovies.movie_id)
        val movieEntity = viewModel.getMovieDetail()
        assertNotNull(movieEntity)
        assertEquals(dummyMovies.duration, movieEntity.duration)
        assertEquals(dummyMovies.genre, movieEntity.genre)
        assertEquals(dummyMovies.image, movieEntity.image)
        assertEquals(dummyMovies.movie_id, movieEntity.movie_id)
        assertEquals(dummyMovies.overview, movieEntity.overview)
        assertEquals(dummyMovies.release_date, movieEntity.release_date)
        assertEquals(dummyMovies.title, movieEntity.title)
    }

    @Test
    fun getTvShows() {
        viewModel.setSelectedTvShow(dummyTvShow.tv_show_id)
        val tvShowEntity = viewModel.getTvShowDetail()
        assertNotNull(tvShowEntity)
        assertEquals(dummyTvShow.duration, tvShowEntity.duration)
        assertEquals(dummyTvShow.genre, tvShowEntity.genre)
        assertEquals(dummyTvShow.image, tvShowEntity.image)
        assertEquals(dummyTvShow.tv_show_id, tvShowEntity.tv_show_id)
        assertEquals(dummyTvShow.overview, tvShowEntity.overview)
        assertEquals(dummyTvShow.tagline, tvShowEntity.tagline)
        assertEquals(dummyTvShow.title, tvShowEntity.title)
    }
}