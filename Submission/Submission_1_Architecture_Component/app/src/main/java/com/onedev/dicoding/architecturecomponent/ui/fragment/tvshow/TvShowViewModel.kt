package com.onedev.dicoding.architecturecomponent.ui.fragment.tvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.onedev.dicoding.architecturecomponent.data.source.MovieRepository
import com.onedev.dicoding.architecturecomponent.data.source.remote.response.TvShowResponseResult

class TvShowViewModel(private val movieRepository: MovieRepository) : ViewModel() {

    fun getPopularTvShow(apiKey: String, page: Int): LiveData<List<TvShowResponseResult>> = movieRepository.getPopularTvShow(apiKey, page)

}