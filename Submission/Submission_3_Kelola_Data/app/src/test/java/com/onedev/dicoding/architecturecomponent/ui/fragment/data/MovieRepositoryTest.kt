package com.onedev.dicoding.architecturecomponent.ui.fragment.data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.nhaarman.mockitokotlin2.verify
import com.onedev.dicoding.architecturecomponent.data.source.local.LocalDataSource
import com.onedev.dicoding.architecturecomponent.data.source.local.entity.MovieEntity
import com.onedev.dicoding.architecturecomponent.data.source.local.entity.TvShowEntity
import com.onedev.dicoding.architecturecomponent.data.source.remote.RemoteDataSource
import com.onedev.dicoding.architecturecomponent.ui.fragment.utils.PagedListUtil
import com.onedev.dicoding.architecturecomponent.utils.AppExecutors
import com.onedev.dicoding.architecturecomponent.utils.DataDummy
import com.onedev.dicoding.architecturecomponent.utils.LiveDataTestUtil
import com.onedev.dicoding.architecturecomponent.vo.Resource
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
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, MovieEntity>
        `when`(local.getPopularMovie()).thenReturn(dataSourceFactory)
        movieCatalogueRepository.getPopularMovie()

        val movieEntities = Resource.success(PagedListUtil.mockPagedList(DataDummy.getMovies()))
        verify(local).getPopularMovie()

        assertNotNull(movieEntities)
        assertEquals(moviesResponse.size.toLong(), movieEntities.data?.size?.toLong())
    }

    @Test
    fun getDetailMovie() {
        val dummyDetail = MutableLiveData<MovieEntity>()
        dummyDetail.value = DataDummy.getMovies()[0]
        `when`(local.getDetailMovie(movieId)).thenReturn(dummyDetail)

        val movieDetailEntity = LiveDataTestUtil.getValue(movieCatalogueRepository.getDetailMovie(movieId))
        verify(local).getDetailMovie(movieId)

        assertNotNull(movieDetailEntity)
        assertEquals(movieDetail.id, movieDetailEntity.data?.id)
        assertEquals(movieDetail.title, movieDetailEntity.data?.title)
        assertEquals(movieDetail.poster_path, movieDetailEntity.data?.poster_path)
        assertEquals(movieDetail.vote_average, movieDetailEntity.data?.vote_average)
        assertEquals(movieDetail.overview, movieDetailEntity.data?.overview)
        assertEquals(movieDetail.popularity, movieDetailEntity.data?.popularity)
        assertEquals(movieDetail.runtime, movieDetailEntity.data?.runtime)
        assertEquals(movieDetail.status, movieDetailEntity.data?.status)
        assertEquals(movieDetail.tagline, movieDetailEntity.data?.tagline)
    }

    @Test
    fun getTvShows() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, TvShowEntity>
        `when`(local.getPopularTvShows()).thenReturn(dataSourceFactory)
        movieCatalogueRepository.getPopularTvShow()

        val tvShowEntities = Resource.success(PagedListUtil.mockPagedList(DataDummy.getTvShows()))
        verify(local).getPopularTvShows()

        assertNotNull(tvShowEntities)
        assertEquals(tvShowResponse.size.toLong(), tvShowEntities.data?.size?.toLong())
    }

    @Test
    fun getDetailTvShow() {
        val dummyDetailTvShow = MutableLiveData<TvShowEntity>()
        dummyDetailTvShow.value = DataDummy.getTvShows()[0]
        `when`(local.getDetailTvShow(tvShowId)).thenReturn(dummyDetailTvShow)

        val tvShowEntity = LiveDataTestUtil.getValue(movieCatalogueRepository.getDetailTvShow(tvShowId))
        verify(local).getDetailTvShow(tvShowId)

        assertNotNull(tvShowEntity)
        assertEquals(tvShowDetail.id, tvShowEntity.data?.id)
        assertEquals(tvShowDetail.name, tvShowEntity.data?.name)
        assertEquals(tvShowDetail.poster_path, tvShowEntity.data?.poster_path)
        assertEquals(tvShowDetail.vote_average, tvShowEntity.data?.vote_average)
        assertEquals(tvShowDetail.overview, tvShowEntity.data?.overview)
        assertEquals(tvShowDetail.popularity, tvShowEntity.data?.popularity)
        assertEquals(tvShowDetail.status, tvShowEntity.data?.status)
        assertEquals(tvShowDetail.tagline, tvShowEntity.data?.tagline)
    }

    @Test
    fun getFavoriteMovie() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, MovieEntity>
        `when`(local.getFavoriteMovie()).thenReturn(dataSourceFactory)
        movieCatalogueRepository.getFavoriteMovie()

        val movieEntities = Resource.success(PagedListUtil.mockPagedList(DataDummy.getMovies()))
        verify(local).getFavoriteMovie()

        assertNotNull(movieEntities)
        assertEquals(moviesResponse.size.toLong(), movieEntities.data?.size?.toLong())
    }

    @Test
    fun getFavoriteTvShow() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, TvShowEntity>
        `when`(local.getFavoriteTvShow()).thenReturn(dataSourceFactory)
        movieCatalogueRepository.getFavoriteTvShow()

        val movieEntities = Resource.success(PagedListUtil.mockPagedList(DataDummy.getTvShows()))
        verify(local).getFavoriteTvShow()

        assertNotNull(movieEntities)
        assertEquals(tvShowResponse.size.toLong(), movieEntities.data?.size?.toLong())
    }
}