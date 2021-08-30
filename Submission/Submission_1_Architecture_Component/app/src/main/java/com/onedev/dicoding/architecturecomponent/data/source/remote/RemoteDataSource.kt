package com.onedev.dicoding.architecturecomponent.data.source.remote

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
            override fun getPopularMovieCallback(movieResult: List<MovieResponseResult>) {
                callback.onAllPopularMovieReceived(movieResult)
            }
        })
    }

    interface LoadPopularMovieCallback {
        fun onAllPopularMovieReceived(movieResult: List<MovieResponseResult>)
    }

}