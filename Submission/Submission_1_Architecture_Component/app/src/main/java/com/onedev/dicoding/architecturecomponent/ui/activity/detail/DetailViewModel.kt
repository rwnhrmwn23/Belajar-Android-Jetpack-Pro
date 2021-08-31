package com.onedev.dicoding.architecturecomponent.ui.activity.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.onedev.dicoding.architecturecomponent.data.source.MovieRepository
import com.onedev.dicoding.architecturecomponent.data.source.local.MovieDetailEntity
import com.onedev.dicoding.architecturecomponent.data.source.local.TvShowDetailEntity

class DetailViewModel(private val movieRepository: MovieRepository) : ViewModel() {

    fun getDetailMovie(movieId: Int): LiveData<MovieDetailEntity> = movieRepository.getDetailMovie(movieId)

    fun getDetailTvShow(tvShowId: Int): LiveData<TvShowDetailEntity> = movieRepository.getDetailTvShow(tvShowId)

}