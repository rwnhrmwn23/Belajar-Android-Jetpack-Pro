package com.onedev.dicoding.architecturecomponent.data.source

import androidx.lifecycle.LiveData
import com.onedev.dicoding.architecturecomponent.data.source.local.MovieDetailEntity
import com.onedev.dicoding.architecturecomponent.data.source.local.MovieEntity
import com.onedev.dicoding.architecturecomponent.data.source.local.TvShowDetailEntity
import com.onedev.dicoding.architecturecomponent.data.source.local.TvShowEntity

interface MovieDataSource {

    fun getPopularMovie(): LiveData<List<MovieEntity>>

    fun getDetailMovie(movieId: Int): LiveData<MovieDetailEntity>

    fun getPopularTvShow(): LiveData<List<TvShowEntity>>

    fun getDetailTvShow(tvShowId: Int): LiveData<TvShowDetailEntity>

}