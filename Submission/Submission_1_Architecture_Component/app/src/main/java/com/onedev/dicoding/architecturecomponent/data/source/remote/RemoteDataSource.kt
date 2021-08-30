package com.onedev.dicoding.architecturecomponent.data.source.remote

import com.onedev.dicoding.architecturecomponent.data.source.remote.response.MovieDetailResponse
import com.onedev.dicoding.architecturecomponent.data.source.remote.response.MovieResponseResult
import com.onedev.dicoding.architecturecomponent.utils.JsonHelper

class RemoteDataSource private constructor(private val jsonHelper: JsonHelper) {

    companion object {
        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(helper: JsonHelper): RemoteDataSource =
            instance ?: synchronized(this) {
                instance ?: RemoteDataSource(helper).apply {
                    instance = this
                }
            }
    }

    fun getPopularMovie(apiKey: String, page: Int, callback: LoadPopularMovieCallback) {
        jsonHelper.getPopularMovie(apiKey, page, object: JsonHelper.GetPopularMovieCallback{
            override fun getPopularMovieCallback(listMovieResponseResult: List<MovieResponseResult>) {
                callback.onAllPopularMovieReceived(listMovieResponseResult)
            }
        })
    }

    fun getDetailMovie(movieId: Int, apiKey: String, callback: LoadDetailMovieCallback) {
        jsonHelper.getDetailMovie(movieId, apiKey, object : JsonHelper.GetDetailMovieCallback {
            override fun getDetailMovieCallback(movieDetailResponse: MovieDetailResponse) {
                callback.onAllDetailMovieReceived(movieDetailResponse)
            }

        })
    }

    interface LoadPopularMovieCallback {
        fun onAllPopularMovieReceived(listMovieResponseResult: List<MovieResponseResult>)
    }

    interface LoadDetailMovieCallback {
        fun onAllDetailMovieReceived(movieDetailResponse: MovieDetailResponse)
    }

}