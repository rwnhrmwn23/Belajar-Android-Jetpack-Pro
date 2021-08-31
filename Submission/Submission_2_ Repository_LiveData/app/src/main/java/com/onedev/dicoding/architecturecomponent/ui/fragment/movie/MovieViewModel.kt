package com.onedev.dicoding.architecturecomponent.ui.fragment.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.onedev.dicoding.architecturecomponent.data.source.MovieRepository
import com.onedev.dicoding.architecturecomponent.data.source.local.MovieEntity

class MovieViewModel(private val movieRepository: MovieRepository) : ViewModel() {

    fun getPopularMovie(): LiveData<List<MovieEntity>> = movieRepository.getPopularMovie()

}