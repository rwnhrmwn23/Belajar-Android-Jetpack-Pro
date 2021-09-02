package com.onedev.dicoding.architecturecomponent.ui.fragment.data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.doAnswer
import com.nhaarman.mockitokotlin2.eq
import com.nhaarman.mockitokotlin2.verify
import com.onedev.dicoding.architecturecomponent.data.source.remote.RemoteDataSource
import com.onedev.dicoding.architecturecomponent.utils.DataDummy
import com.onedev.dicoding.architecturecomponent.utils.LiveDataTestUtil
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.mock

class MovieRepositoryTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = mock(RemoteDataSource::class.java)
    private val movieCatalogueRepository = FakeMovieRepository(remote)

    private val moviesResponse = DataDummy.getRemoteMovies()
    private val movieId = moviesResponse[0].id
    private val movieDetail = DataDummy.getRemoteDetailMovie()

    private val tvShowResponse = DataDummy.getRemoteTvShows()
    private val tvShowId = tvShowResponse[0].id
    private val tvShowDetail = DataDummy.getRemoteDetailTvShow()

    @Test
    fun getMovies() {
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.LoadPopularMovieCallback).onAllPopularMovieReceived(moviesResponse)
            null
        }.`when`(remote).getPopularMovie(any())

        val movieEntities = LiveDataTestUtil.getValue(movieCatalogueRepository.getPopularMovie())
        verify(remote).getPopularMovie(any())
        assertNotNull(movieEntities)
        assertEquals(moviesResponse.size, movieEntities.size)
    }

    @Test
    fun getDetailMovie() {
        doAnswer { invocation ->
            (invocation.arguments[1] as RemoteDataSource.LoadDetailMovieCallback).onAllDetailMovieReceived(movieDetail)
            null
        }.`when`(remote).getDetailMovie(eq(movieId), any())

        val movieEntity = LiveDataTestUtil.getValue(movieCatalogueRepository.getDetailMovie(movieId))
        verify(remote).getDetailMovie(eq(movieId), any())
        assertNotNull(movieEntity)
        assertEquals(movieDetail.id, movieEntity.id)
    }

    @Test
    fun getTvShows() {
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.LoadPopularTvShowCallback).onAllPopularTvShowReceived(tvShowResponse)
            null
        }.`when`(remote).getPopularTvShow(any())

        val tvShowEntities = LiveDataTestUtil.getValue(movieCatalogueRepository.getPopularTvShow())
        verify(remote).getPopularTvShow(any())
        assertNotNull(tvShowEntities)
        assertEquals(tvShowResponse.size, tvShowEntities.size)
    }

    @Test
    fun getDetailTvShow() {
        doAnswer { invocation ->
            (invocation.arguments[1] as RemoteDataSource.LoadDetailTvShowCallback).onAllDetailTvShowReceived(tvShowDetail)
            null
        }.`when`(remote).getDetailTvShow(eq(tvShowId), any())

        val tvShowEntity = LiveDataTestUtil.getValue(movieCatalogueRepository.getDetailTvShow(tvShowId))
        verify(remote).getDetailTvShow(eq(tvShowId), any())
        assertNotNull(tvShowEntity)
        assertEquals(tvShowDetail.id, tvShowEntity.id)
    }
}