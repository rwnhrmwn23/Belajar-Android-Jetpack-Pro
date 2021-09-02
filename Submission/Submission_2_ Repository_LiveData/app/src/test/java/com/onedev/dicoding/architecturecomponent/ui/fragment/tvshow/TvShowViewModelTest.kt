package com.onedev.dicoding.architecturecomponent.ui.fragment.tvshow

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.nhaarman.mockitokotlin2.verify
import com.onedev.dicoding.architecturecomponent.data.source.MovieRepository
import com.onedev.dicoding.architecturecomponent.data.source.local.entity.TvShowEntity
import com.onedev.dicoding.architecturecomponent.utils.DataDummy
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

    @get:Rule
    var instanceTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieRepository: MovieRepository

    @Mock
    private lateinit var observer: Observer<List<TvShowEntity>>

    @Before
    fun setup() {
        viewModel = TvShowViewModel(movieRepository)
    }

    @Test
    fun getTvShow() {
        val dummyTvShows = DataDummy.getTvShows()
        val tvShows = MutableLiveData<List<TvShowEntity>>()
        tvShows.value = dummyTvShows

        `when`(movieRepository.getPopularTvShow()).thenReturn(tvShows)
        val movieEntities = viewModel.getPopularTvShow().value
        verify(movieRepository).getPopularTvShow()

        assertNotNull(movieEntities)
        assertEquals(3, movieEntities?.size)

        viewModel.getPopularTvShow().observeForever(observer)
        verify(observer).onChanged(dummyTvShows)
    }
}