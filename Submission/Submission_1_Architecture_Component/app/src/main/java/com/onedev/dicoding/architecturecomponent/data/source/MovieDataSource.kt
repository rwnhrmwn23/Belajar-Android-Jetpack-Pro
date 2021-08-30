package com.onedev.dicoding.architecturecomponent.data.source

import androidx.lifecycle.LiveData
import com.onedev.dicoding.architecturecomponent.data.source.remote.response.MovieDetailResponse
import com.onedev.dicoding.architecturecomponent.data.source.remote.response.MovieResponseResult
import com.onedev.dicoding.architecturecomponent.data.source.remote.response.TvShowDetailResponse
import com.onedev.dicoding.architecturecomponent.data.source.remote.response.TvShowResponseResult

interface MovieDataSource {

    fun getPopularMovie(apiKey: String, page: Int): LiveData<List<MovieResponseResult>>

    fun getDetailMovie(movieId: Int, apiKey: String): LiveData<MovieDetailResponse>

    fun getPopularTvShow(apiKey: String, page: Int): LiveData<List<TvShowResponseResult>>

    fun getDetailTvShow(tvShow: Int, apiKey: String): LiveData<TvShowDetailResponse>

}