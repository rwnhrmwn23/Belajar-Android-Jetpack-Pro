package com.onedev.dicoding.architecturecomponent.ui.activity.detail

import androidx.lifecycle.ViewModel
import com.onedev.dicoding.architecturecomponent.data.source.MovieRepository

class DetailViewModel(private val movieRepository: MovieRepository) : ViewModel() {

    fun getDetailMovie(movieId: Int) = movieRepository.getDetailMovie(movieId)

    fun getDetailTvShow(tvShowId: Int) = movieRepository.getDetailTvShow(tvShowId)

}