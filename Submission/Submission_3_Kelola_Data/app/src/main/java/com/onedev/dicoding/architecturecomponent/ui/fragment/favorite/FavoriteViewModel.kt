package com.onedev.dicoding.architecturecomponent.ui.fragment.favorite

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.onedev.dicoding.architecturecomponent.data.source.MovieRepository
import com.onedev.dicoding.architecturecomponent.data.source.local.entity.MovieEntity
import com.onedev.dicoding.architecturecomponent.data.source.local.entity.TvShowEntity

class FavoriteViewModel(private val movieRepository: MovieRepository) : ViewModel() {

    fun getFavoriteMovie(): LiveData<PagedList<MovieEntity>> = movieRepository.getFavoriteMovie()

    fun getFavoriteTvShow(): LiveData<PagedList<TvShowEntity>> = movieRepository.getFavoriteTvShow()

}