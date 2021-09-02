package com.onedev.dicoding.architecturecomponent.ui.fragment.movie

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.nhaarman.mockitokotlin2.verify
import com.onedev.dicoding.architecturecomponent.data.source.MovieRepository
import com.onedev.dicoding.architecturecomponent.data.source.local.entity.MovieEntity
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
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MovieViewModelTest {

    private lateinit var viewModel: MovieViewModel

    @get:Rule
    var instanceTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieRepository: MovieRepository

    @Mock
    private lateinit var observer: Observer<Resource<List<MovieEntity>>>

    @Before
    fun setup() {
        viewModel = MovieViewModel(movieRepository)
    }

    @Test
    fun getMovies() {
        val dummyMovies = Resource.success(DataDummy.getMovies())
        val movies = MutableLiveData<Resource<List<MovieEntity>>>()
        movies.value = dummyMovies

        `when`(movieRepository.getPopularMovie()).thenReturn(movies)
        val movieEntities = viewModel.getPopularMovie().value?.data
        verify(movieRepository).getPopularMovie()

        assertNotNull(movieEntities)
        assertEquals(1, movieEntities?.size)

        viewModel.getPopularMovie().observeForever(observer)
        verify(observer).onChanged(dummyMovies)
    }
}