package com.onedev.dicoding.architecturecomponent.ui.activity.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.onedev.dicoding.architecturecomponent.data.source.MovieRepository
import com.onedev.dicoding.architecturecomponent.data.source.remote.response.MovieDetailResponse
import com.onedev.dicoding.architecturecomponent.data.source.remote.response.TvShowDetailResponse

class DetailViewModel(private val movieRepository: MovieRepository): ViewModel() {

    fun getDetailMovie(movieId: Int, apiKey: String): LiveData<MovieDetailResponse> = movieRepository.getDetailMovie(movieId, apiKey)

    fun getDetailTvShow(tvShowId: Int, apiKey: String): LiveData<TvShowDetailResponse> = movieRepository.getDetailTvShow(tvShowId, apiKey)

}