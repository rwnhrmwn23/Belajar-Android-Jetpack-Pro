package com.onedev.dicoding.architecturecomponent.data.source.local.room

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.*
import com.onedev.dicoding.architecturecomponent.data.source.local.entity.MovieEntity
import com.onedev.dicoding.architecturecomponent.data.source.local.entity.TvShowEntity

@Dao
interface MovieDao {

    @Query("SELECT * FROM movieEntities")
    fun getPopularMovie(): DataSource.Factory<Int, MovieEntity>

    @Query("SELECT * FROM movieEntities WHERE id = :movieId")
    fun getDetailMovie(movieId: Int): LiveData<MovieEntity>

    @Query("SELECT * FROM movieEntities WHERE favorite = 1")
    fun getFavoriteMovie(): DataSource.Factory<Int, MovieEntity>

    @Query("SELECT * FROM tvShowEntities")
    fun getPopularTvShows(): DataSource.Factory<Int, TvShowEntity>

    @Query("SELECT * FROM tvShowEntities WHERE id = :tvShowId")
    fun getDetailTvShow(tvShowId: Int): LiveData<TvShowEntity>

    @Query("SELECT * FROM tvShowEntities WHERE favorite = 1")
    fun getFavoriteTvShow(): DataSource.Factory<Int, TvShowEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovies(movies: List<MovieEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTvShow(tvShowEntities: List<TvShowEntity>)

    @Update
    fun updateMovie(movie: MovieEntity)

    @Update
    fun updateTvShow(tvShowEntity: TvShowEntity)

}