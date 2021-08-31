package com.onedev.dicoding.architecturecomponent.ui.fragment.tvshow

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.nhaarman.mockitokotlin2.verify
import com.onedev.dicoding.architecturecomponent.BuildConfig
import com.onedev.dicoding.architecturecomponent.data.source.MovieRepository
import com.onedev.dicoding.architecturecomponent.data.source.remote.response.TvShowResponseResult
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
class TvShowViewModelTest {
    private lateinit var viewModel: TvShowViewModel
    private lateinit var jsonHelper: FakeJsonHelper
    private val apiKey = BuildConfig.API_KEY

    @get:Rule
    var instanceTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieRepository: MovieRepository

    @Mock
    private lateinit var observer: Observer<List<TvShowResponseResult>>

    @Before
    fun setup() {
        viewModel = TvShowViewModel(movieRepository)
        jsonHelper = FakeJsonHelper()
    }

    @Test
    fun getTvShow() {
        val tvShows = MutableLiveData<List<TvShowResponseResult>>()
        jsonHelper.getPopularTvShow(apiKey, 1, object : FakeJsonHelper.GetPopularTvShowCallback {
            override fun getPopularTvShowCallback(listTvShowResponse: List<TvShowResponseResult>) {
                tvShows.value = listTvShowResponse
            }
        })

        delayThreeSecond()

        `when`(movieRepository.getPopularTvShow(apiKey, 1)).thenReturn(tvShows)
        val movieEntities = viewModel.getPopularTvShow(apiKey, 1).value
        verify(movieRepository).getPopularTvShow(apiKey, 1)

        assertNotNull(movieEntities)
        assertEquals(20, movieEntities?.size)

        viewModel.getPopularTvShow(apiKey, 1).observeForever(observer)
        verify(observer).onChanged(tvShows.value)
    }

    private fun delayThreeSecond() {
        try {
            Thread.sleep(3000)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }
    }
}