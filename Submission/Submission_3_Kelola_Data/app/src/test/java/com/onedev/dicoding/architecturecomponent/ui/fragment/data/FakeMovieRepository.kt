package com.onedev.dicoding.architecturecomponent.ui.fragment.data

import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.onedev.dicoding.architecturecomponent.data.source.MovieDataSource
import com.onedev.dicoding.architecturecomponent.data.source.NetworkBoundResource
import com.onedev.dicoding.architecturecomponent.data.source.local.LocalDataSource
import com.onedev.dicoding.architecturecomponent.data.source.local.entity.MovieEntity
import com.onedev.dicoding.architecturecomponent.data.source.local.entity.TvShowEntity
import com.onedev.dicoding.architecturecomponent.data.source.remote.RemoteDataSource
import com.onedev.dicoding.architecturecomponent.data.source.remote.response.*
import com.onedev.dicoding.architecturecomponent.utils.AppExecutors
import com.onedev.dicoding.architecturecomponent.vo.Resource

class FakeMovieRepository constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) :
    MovieDataSource {

    override fun getPopularMovie(): LiveData<Resource<PagedList<MovieEntity>>> {
        return object :
            NetworkBoundResource<PagedList<MovieEntity>, List<MovieResponseResult>>(appExecutors) {
            override fun loadFromDB(): LiveData<PagedList<MovieEntity>> {
                val config = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(4)
                    .setPageSize(4)
                    .build()
                return LivePagedListBuilder(localDataSource.getPopularMovie(), config).build()
            }

            override fun shouldFetch(data: PagedList<MovieEntity>?): Boolean =
                data == null || data.isEmpty()

            override fun createCall(): LiveData<ApiResponse<List<MovieResponseResult>>> =
                remoteDataSource.getPopularMovie()

            override fun saveCallResult(data: List<MovieResponseResult>) {
                val movies = ArrayList<MovieEntity>()
                for (i in data) {
                    val movieEntities = MovieEntity(
                        i.id,
                        i.title,
                        i.poster_path,
                        i.vote_average,
                        null,
                        i.overview,
                        i.popularity,
                        i.release_date,
                        i.runtime,
                        i.status,
                        i.tagline,
                        false)
                    movies.add(movieEntities)
                }
                localDataSource.insertMovies(movies)
            }
        }.asLiveData()
    }

    override fun getDetailMovie(movieId: Int): LiveData<Resource<MovieEntity>> {
        return object : NetworkBoundResource<MovieEntity, MovieDetailResponse>(appExecutors) {
            override fun loadFromDB(): LiveData<MovieEntity> =
                localDataSource.getDetailMovie(movieId)

            override fun shouldFetch(data: MovieEntity?): Boolean =
                data?.genres == null

            override fun createCall(): LiveData<ApiResponse<MovieDetailResponse>> =
                remoteDataSource.getDetailMovie(movieId)

            override fun saveCallResult(data: MovieDetailResponse) {
                val listGenre = ArrayList<String>()
                for (i in data.genres) {
                    listGenre.add(i.name)
                }
                with(data) {
                    val movieEntity = MovieEntity(
                        id,
                        title,
                        poster_path,
                        vote_average,
                        listGenre.toString(),
                        overview,
                        popularity,
                        release_date,
                        runtime,
                        status,
                        tagline)
                    localDataSource.updateMovie(movieEntity)
                }
            }
        }.asLiveData()
    }

    override fun getPopularTvShow(): LiveData<Resource<PagedList<TvShowEntity>>> {
        return object : NetworkBoundResource<PagedList<TvShowEntity>, List<TvShowResponseResult>>(appExecutors) {
            override fun loadFromDB(): LiveData<PagedList<TvShowEntity>> {
                val config = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(4)
                    .setPageSize(4)
                    .build()
                return LivePagedListBuilder(localDataSource.getPopularTvShows(), config).build()
            }

            override fun shouldFetch(data: PagedList<TvShowEntity>?): Boolean =
                data == null || data.isEmpty()

            override fun createCall(): LiveData<ApiResponse<List<TvShowResponseResult>>> =
                remoteDataSource.getPopularTvShow()

            override fun saveCallResult(data: List<TvShowResponseResult>) {
                val tvShows = ArrayList<TvShowEntity>()
                for (i in data) {
                    val tvShowEntities = TvShowEntity(
                        i.id,
                        i.name,
                        i.poster_path,
                        i.vote_average,
                        null,
                        i.overview,
                        i.popularity,
                        i.status,
                        i.tagline)
                    tvShows.add(tvShowEntities)
                }
                localDataSource.insertTvShow(tvShows)
            }
        }.asLiveData()
    }

    override fun getDetailTvShow(tvShowId: Int): LiveData<Resource<TvShowEntity>> {
        return object : NetworkBoundResource<TvShowEntity, TvShowDetailResponse>(appExecutors) {
            override fun loadFromDB(): LiveData<TvShowEntity> =
                localDataSource.getDetailTvShow(tvShowId)

            override fun shouldFetch(data: TvShowEntity?): Boolean =
                data?.genres == null

            override fun createCall(): LiveData<ApiResponse<TvShowDetailResponse>> =
                remoteDataSource.getDetailTvShow(tvShowId)

            override fun saveCallResult(data: TvShowDetailResponse) {
                val listGenre = ArrayList<String>()
                for (i in data.genres) {
                    listGenre.add(i.name)
                }
                with(data) {
                    val tvShowEntity =TvShowEntity(
                        id,
                        name,
                        poster_path,
                        vote_average,
                        listGenre.toString(),
                        overview,
                        popularity,
                        status,
                        tagline)
                    localDataSource.updateTvShow(tvShowEntity)
                }
            }
        }.asLiveData()
    }

    override fun getFavoriteMovie(): LiveData<PagedList<MovieEntity>> {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(4)
            .setPageSize(4)
            .build()
        return LivePagedListBuilder(localDataSource.getFavoriteMovie(), config).build()
    }

    override fun getFavoriteTvShow(): LiveData<PagedList<TvShowEntity>> {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(4)
            .setPageSize(4)
            .build()
        return LivePagedListBuilder(localDataSource.getFavoriteTvShow(), config).build()
    }

    override fun setFavoriteMovie(movie: MovieEntity, newState: Boolean) {
        appExecutors.diskIO().execute {
            localDataSource.setFavoriteMovie(movie, newState)
        }
    }

    override fun setFavoriteTvShow(tvShow: TvShowEntity, newState: Boolean) {
        appExecutors.diskIO().execute {
            localDataSource.setTvShowMovie(tvShow, newState)
        }
    }
}