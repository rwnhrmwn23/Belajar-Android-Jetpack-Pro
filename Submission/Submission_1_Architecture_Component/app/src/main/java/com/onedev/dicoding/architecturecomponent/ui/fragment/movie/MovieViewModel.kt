package com.onedev.dicoding.architecturecomponent.ui.fragment.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.onedev.dicoding.architecturecomponent.data.source.MovieRepository
import com.onedev.dicoding.architecturecomponent.data.source.remote.response.MovieResponseResult

class MovieViewModel(private val movieRepository: MovieRepository) : ViewModel() {

    fun getPopularMovie(apiKey: String, page: Int): LiveData<List<MovieResponseResult>> = movieRepository.getPopularMovie(apiKey, page)

}