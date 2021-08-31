package com.onedev.dicoding.architecturecomponent.ui.fragment.movie

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.nhaarman.mockitokotlin2.verify
import com.onedev.dicoding.architecturecomponent.BuildConfig
import com.onedev.dicoding.architecturecomponent.data.source.MovieRepository
import com.onedev.dicoding.architecturecomponent.data.source.remote.response.MovieResponseResult
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
class MovieViewModelTest {

    private lateinit var viewModel: MovieViewModel
    private lateinit var jsonHelper: FakeJsonHelper
    private val apiKey = BuildConfig.API_KEY

    @get:Rule
    var instanceTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieRepository: MovieRepository

    @Mock
    private lateinit var observer: Observer<List<MovieResponseResult>>

    @Before
    fun setup() {
        viewModel = MovieViewModel(movieRepository)
        jsonHelper = FakeJsonHelper()
    }

    @Test
    fun getMovies() {
        val movies = MutableLiveData<List<MovieResponseResult>>()
        jsonHelper.getPopularMovie(apiKey, 1, object : FakeJsonHelper.GetPopularMovieCallback {
            override fun getPopularMovieCallback(listMovieResponseResult: List<MovieResponseResult>) {
                movies.value = listMovieResponseResult
            }
        })

        delayThreeSecond()

        `when`(movieRepository.getPopularMovie(apiKey, 1)).thenReturn(movies)
        val movieEntities = viewModel.getPopularMovie(apiKey, 1).value
        verify(movieRepository).getPopularMovie(apiKey, 1)

        assertNotNull(movieEntities)
        assertEquals(20, movieEntities?.size)

        viewModel.getPopularMovie(apiKey, 1).observeForever(observer)
        verify(observer).onChanged(movies.value)
    }

    private fun delayThreeSecond() {
        try {
            Thread.sleep(3000)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }
    }

}