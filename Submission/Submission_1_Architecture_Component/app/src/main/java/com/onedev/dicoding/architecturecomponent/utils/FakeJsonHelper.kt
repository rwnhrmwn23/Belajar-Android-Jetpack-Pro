package com.onedev.dicoding.architecturecomponent.utils

import android.util.Log
import com.onedev.dicoding.architecturecomponent.data.api.ApiServicesBuilder
import com.onedev.dicoding.architecturecomponent.data.source.remote.response.*
import org.json.JSONException
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FakeJsonHelper {

    companion object {
        private const val TAG = "JsonHelper"
    }

    fun getPopularMovie(apiKey: String, page: Int, callback: GetPopularMovieCallback) {
        try {
            ApiServicesBuilder.instance.getPopularMovie(apiKey, page)
                .enqueue(object : Callback<MovieResponse> {
                    override fun onResponse(
                        call: Call<MovieResponse>,
                        response: Response<MovieResponse>
                    ) {
                        if (response.isSuccessful) {
                            val results = response.body()!!.results
                            if (results.isNotEmpty()) {
                                callback.getPopularMovieCallback(results)
                            }
                        }
                    }

                    override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                        Log.d(TAG, "onFailure: ${t.localizedMessage}")
                    }

                })
        } catch (e: JSONException) {
            e.printStackTrace()
        }
    }

    fun getDetailMovie(movieId: Int, apiKey: String, callback: GetDetailMovieCallback) {
        try {
            ApiServicesBuilder.instance.getDetailMovie(movieId, apiKey)
                .enqueue(object : Callback<MovieDetailResponse> {
                    override fun onResponse(
                        call: Call<MovieDetailResponse>,
                        response: Response<MovieDetailResponse>
                    ) {
                        if (response.isSuccessful) {
                            response.body()?.let {
                                callback.getDetailMovieCallback(it)
                            }
                        }
                    }

                    override fun onFailure(call: Call<MovieDetailResponse>, t: Throwable) {
                        Log.d(TAG, "onFailure: ${t.localizedMessage}")
                    }

                })
        } catch (e: JSONException) {
            e.printStackTrace()
        }
    }

    fun getPopularTvShow(apiKey: String, page: Int, callback: GetPopularTvShowCallback) {
        try {
            ApiServicesBuilder.instance.getPopularTvShow(apiKey, page)
                .enqueue(object : Callback<TvShowResponse> {
                    override fun onResponse(
                        call: Call<TvShowResponse>,
                        response: Response<TvShowResponse>
                    ) {
                        if (response.isSuccessful) {
                            val results = response.body()!!.results
                            if (results.isNotEmpty()) {
                                callback.getPopularTvShowCallback(results)
                            }
                        }
                    }

                    override fun onFailure(call: Call<TvShowResponse>, t: Throwable) {
                        Log.d(TAG, "onFailure: ${t.localizedMessage}")
                    }

                })
        } catch (e: JSONException) {
            e.printStackTrace()
        }
    }

    fun getDetailTvShow(tvShow: Int, apiKey: String, callback: GetDetailTvShowCallback) {
        try {
            ApiServicesBuilder.instance.getDetailTvShow(tvShow, apiKey)
                .enqueue(object : Callback<TvShowDetailResponse> {
                    override fun onResponse(
                        call: Call<TvShowDetailResponse>,
                        response: Response<TvShowDetailResponse>
                    ) {
                        if (response.isSuccessful) {
                            response.body()?.let {
                                callback.getDetailTvShowCallback(it)
                            }
                        }
                    }

                    override fun onFailure(call: Call<TvShowDetailResponse>, t: Throwable) {
                        Log.d(TAG, "onFailure: ${t.localizedMessage}")
                    }

                })
        } catch (e: JSONException) {
            e.printStackTrace()
        }
    }

    interface GetPopularMovieCallback {
        fun getPopularMovieCallback(listMovieResponseResult: List<MovieResponseResult>)
    }

    interface GetDetailMovieCallback {
        fun getDetailMovieCallback(movieDetailResponse: MovieDetailResponse)
    }

    interface GetPopularTvShowCallback {
        fun getPopularTvShowCallback(listTvShowResponse: List<TvShowResponseResult>)
    }

    interface GetDetailTvShowCallback {
        fun getDetailTvShowCallback(tvShowDetailResponse: TvShowDetailResponse)
    }

}