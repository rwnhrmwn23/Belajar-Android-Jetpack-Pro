package com.onedev.dicoding.architecturecomponent.ui.fragment.data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import com.nhaarman.mockitokotlin2.verify
import com.onedev.dicoding.architecturecomponent.data.source.local.LocalDataSource
import com.onedev.dicoding.architecturecomponent.data.source.local.entity.MovieEntity
import com.onedev.dicoding.architecturecomponent.data.source.local.entity.TvShowEntity
import com.onedev.dicoding.architecturecomponent.data.source.remote.RemoteDataSource
import com.onedev.dicoding.architecturecomponent.utils.AppExecutors
import com.onedev.dicoding.architecturecomponent.utils.DataDummy
import com.onedev.dicoding.architecturecomponent.utils.LiveDataTestUtil
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock

class MovieRepositoryTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = mock(RemoteDataSource::class.java)
    private val local = mock(LocalDataSource::class.java)
    private val appExecutor = mock(AppExecutors::class.java)
    private val movieCatalogueRepository = FakeMovieRepository(remote, local, appExecutor)

    private val moviesResponse = DataDummy.getRemoteMovies()
    private val movieId = moviesResponse[0].id
    private val movieDetail = DataDummy.getRemoteDetailMovie()

    private val tvShowResponse = DataDummy.getRemoteTvShows()
    private val tvShowId = tvShowResponse[0].id
    private val tvShowDetail = DataDummy.getRemoteDetailTvShow()

    @Test
    fun getMovies() {
        val dummyMovies = MutableLiveData<List<MovieEntity>>()
        dummyMovies.value = DataDummy.getMovies()
        `when`(local.getPopularMovie()).thenReturn(dummyMovies)

        val movieEntities = LiveDataTestUtil.getValue(movieCatalogueRepository.getPopularMovie())
        verify(local).getPopularMovie()

        assertNotNull(movieEntities)
        assertEquals(moviesResponse.size.toLong(), movieEntities.data?.size?.toLong())
    }

    @Test
    fun getDetailMovie() {
        val dummyDetail = MutableLiveData<MovieEntity>()
        dummyDetail.value = DataDummy.getMovies()[0]
        `when`(local.getDetailMovie(movieId)).thenReturn(dummyDetail)

        val movieDetailEntity =
            LiveDataTestUtil.getValue(movieCatalogueRepository.getDetailMovie(movieId))
        verify(local).getDetailMovie(movieId)

        assertNotNull(movieDetailEntity)
        assertEquals(movieDetail.id, movieDetailEntity.data?.id)
    }

    @Test
    fun getTvShows() {
        val dummyTvShow = MutableLiveData<List<TvShowEntity>>()
        dummyTvShow.value = DataDummy.getTvShows()
        `when`(local.getPopularTvShows()).thenReturn(dummyTvShow)

        val tvShowEntities = LiveDataTestUtil.getValue(movieCatalogueRepository.getPopularTvShow())
        verify(local).getPopularTvShows()

        assertNotNull(tvShowEntities)
        assertEquals(tvShowResponse.size.toLong(), tvShowEntities.data?.size?.toLong())
    }

    @Test
    fun getDetailTvShow() {
        val dummyDetailTvShow = MutableLiveData<TvShowEntity>()
        dummyDetailTvShow.value = DataDummy.getTvShows()[0]
        `when`(local.getDetailTvShow(tvShowId)).thenReturn(dummyDetailTvShow)

        val tvShowEntity =
            LiveDataTestUtil.getValue(movieCatalogueRepository.getDetailTvShow(tvShowId))
        verify(local).getDetailTvShow(tvShowId)

        assertNotNull(tvShowEntity)
        assertEquals(tvShowDetail.id, tvShowEntity.data?.id)
    }
}