package com.onedev.dicoding.architecturecomponent.data.source

import androidx.lifecycle.LiveData
import com.onedev.dicoding.architecturecomponent.data.source.remote.response.MovieDetailResponse
import com.onedev.dicoding.architecturecomponent.data.source.remote.response.MovieResponseResult

interface MovieDataSource {

    fun getPopularMovie(apiKey: String, page: Int): LiveData<List<MovieResponseResult>>

    fun getDetailMovie(movieId: Int, apiKey: String): LiveData<MovieDetailResponse>

}