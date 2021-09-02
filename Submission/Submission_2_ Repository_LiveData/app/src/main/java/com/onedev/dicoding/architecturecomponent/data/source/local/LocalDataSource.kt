package com.onedev.dicoding.architecturecomponent.data.source.local

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import com.onedev.dicoding.architecturecomponent.data.source.local.entity.MovieEntity
import com.onedev.dicoding.architecturecomponent.data.source.local.entity.TvShowEntity
import com.onedev.dicoding.architecturecomponent.data.source.local.room.MovieDao

class LocalDataSource private constructor(private val movieDao: MovieDao) {

    companion object {
        private var INSTANCE: LocalDataSource? = null

        fun getInstance(movieDao: MovieDao): LocalDataSource =
            INSTANCE ?: LocalDataSource(movieDao)
    }

    fun getPopularMovie(): DataSource.Factory<Int, MovieEntity> = movieDao.getPopularMovie()

    fun getDetailMovie(movieId: Int): LiveData<MovieEntity> = movieDao.getDetailMovie(movieId)

    fun getFavoriteMovie(): DataSource.Factory<Int, MovieEntity> = movieDao.getFavoriteMovie()

    fun setFavoriteMovie(movie: MovieEntity, newState: Boolean) {
        movie.favorite = newState
        movieDao.updateMovie(movie)
    }

    fun getPopularTvShows(): DataSource.Factory<Int, TvShowEntity> = movieDao.getPopularTvShows()

    fun getDetailTvShow(tvShowId: Int): LiveData<TvShowEntity> = movieDao.getDetailTvShow(tvShowId)

    fun getFavoriteTvShow(): DataSource.Factory<Int, TvShowEntity> = movieDao.getFavoriteTvShow()

    fun setTvShowMovie(tvShow: TvShowEntity, newState: Boolean) {
        tvShow.favorite = newState
        movieDao.updateTvShow(tvShow)
    }

    fun insertMovies(listMovie: List<MovieEntity>) = movieDao.insertMovies(listMovie)

    fun insertTvShow(listTvShow: List<TvShowEntity>) = movieDao.insertTvShow(listTvShow)

    fun updateMovie(movieEntity: MovieEntity) = movieDao.updateMovie(movieEntity)

    fun updateTvShow(tvShowEntity: TvShowEntity) = movieDao.updateTvShow(tvShowEntity)
}