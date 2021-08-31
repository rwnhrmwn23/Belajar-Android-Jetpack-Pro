package com.onedev.dicoding.architecturecomponent.ui.fragment.tvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.onedev.dicoding.architecturecomponent.data.source.MovieRepository
import com.onedev.dicoding.architecturecomponent.data.source.local.TvShowEntity

class TvShowViewModel(private val movieRepository: MovieRepository) : ViewModel() {

    fun getPopularTvShow(): LiveData<List<TvShowEntity>> = movieRepository.getPopularTvShow()

}