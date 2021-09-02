package com.onedev.dicoding.architecturecomponent.ui.activity.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.onedev.dicoding.architecturecomponent.data.source.MovieRepository
import com.onedev.dicoding.architecturecomponent.data.source.local.entity.MovieEntity
import com.onedev.dicoding.architecturecomponent.data.source.local.entity.TvShowEntity
import com.onedev.dicoding.architecturecomponent.vo.Resource

class DetailViewModel(private val movieRepository: MovieRepository) : ViewModel() {

    fun getDetailMovie(movieId: Int): LiveData<Resource<MovieEntity>> = movieRepository.getDetailMovie(movieId)

    fun getDetailTvShow(tvShowId: Int): LiveData<Resource<TvShowEntity>> = movieRepository.getDetailTvShow(tvShowId)

    fun setFavoriteMovie(movieEntity: MovieEntity, newState: Boolean) {
        movieRepository.setFavoriteMovie(movieEntity, newState)
    }

    fun setTvShowMovie(tvShowEntity: TvShowEntity, newState: Boolean) {
        movieRepository.setFavoriteTvShow(tvShowEntity, newState)
    }

}