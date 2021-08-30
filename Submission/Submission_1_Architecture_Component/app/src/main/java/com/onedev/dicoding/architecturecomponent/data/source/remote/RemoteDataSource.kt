package com.onedev.dicoding.architecturecomponent.data.source.remote

import com.onedev.dicoding.architecturecomponent.data.source.remote.response.MovieDetailResponse
import com.onedev.dicoding.architecturecomponent.data.source.remote.response.MovieResponseResult
import com.onedev.dicoding.architecturecomponent.data.source.remote.response.TvShowDetailResponse
import com.onedev.dicoding.architecturecomponent.data.source.remote.response.TvShowResponseResult
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

    fun getPopularTvShow(apiKey: String, page: Int, callback: LoadPopularTvShowCallback) {
        jsonHelper.getPopularTvShow(apiKey, page, object : JsonHelper.GetPopularTvShowCallback {
            override fun getPopularTvShowCallback(listTvShowResponse: List<TvShowResponseResult>) {
                callback.onAllPopularTvShowReceived(listTvShowResponse)
            }
        })
    }

    fun getDetailTvShow(tvShow: Int, apiKey: String, callback: LoadDetailTvShowCallback) {
        jsonHelper.getDetailTvShow(tvShow, apiKey, object : JsonHelper.GetDetailTvShowCallback {
            override fun getDetailTvShowCallback(tvShowDetailResponse: TvShowDetailResponse) {
                callback.onAllDetailTvShowReceived(tvShowDetailResponse)
            }

        })
    }

    interface LoadPopularMovieCallback {
        fun onAllPopularMovieReceived(listMovieResponseResult: List<MovieResponseResult>)
    }

    interface LoadDetailMovieCallback {
        fun onAllDetailMovieReceived(movieDetailResponse: MovieDetailResponse)
    }

    interface LoadPopularTvShowCallback {
        fun onAllPopularTvShowReceived(listTvShowResponseResult: List<TvShowResponseResult>)
    }

    interface LoadDetailTvShowCallback {
        fun onAllDetailTvShowReceived(tvShowDetailResponse: TvShowDetailResponse)
    }

}