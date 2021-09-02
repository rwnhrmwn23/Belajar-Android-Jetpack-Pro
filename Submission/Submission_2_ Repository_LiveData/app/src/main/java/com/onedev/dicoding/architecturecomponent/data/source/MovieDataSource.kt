package com.onedev.dicoding.architecturecomponent.data.source

import androidx.lifecycle.LiveData
import com.onedev.dicoding.architecturecomponent.data.source.local.entity.MovieEntity
import com.onedev.dicoding.architecturecomponent.data.source.local.entity.TvShowEntity
import com.onedev.dicoding.architecturecomponent.vo.Resource

interface MovieDataSource {

    fun getPopularMovie(): LiveData<Resource<List<MovieEntity>>>

    fun getDetailMovie(movieId: Int): LiveData<Resource<MovieEntity>>

    fun getPopularTvShow(): LiveData<Resource<List<TvShowEntity>>>

    fun getDetailTvShow(tvShowId: Int): LiveData<Resource<TvShowEntity>>

    fun getFavoriteMovie(): LiveData<List<MovieEntity>>

    fun getFavoriteTvShow(): LiveData<List<TvShowEntity>>

    fun setFavoriteMovie(movie: MovieEntity, newState: Boolean)

    fun setFavoriteTvShow(tvShow: TvShowEntity, newState: Boolean)

}