package com.onedev.dicoding.architecturecomponent.utils

import android.content.Context
import android.util.Log
import com.onedev.dicoding.architecturecomponent.data.api.ApiServicesBuilder
import com.onedev.dicoding.architecturecomponent.data.source.remote.response.MovieDetailResponse
import com.onedev.dicoding.architecturecomponent.data.source.remote.response.MovieResponse
import com.onedev.dicoding.architecturecomponent.data.source.remote.response.MovieResponseResult
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.json.JSONException
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@DelicateCoroutinesApi
class JsonHelper(private val context: Context) {

    companion object {
        private const val TAG = "JsonHelper"
    }

    fun getPopularMovie(apiKey: String, page: Int, callback: GetPopularMovieCallback) {
        GlobalScope.launch(Dispatchers.IO) {
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
    }

    fun getDetailMovie(movieId: Int, apiKey: String, callback: GetDetailMovieCallback) {
        GlobalScope.launch(Dispatchers.IO) {
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
    }

    interface GetPopularMovieCallback {
        fun getPopularMovieCallback(listMovieResponseResult: List<MovieResponseResult>)
    }

    interface GetDetailMovieCallback {
        fun getDetailMovieCallback(movieDetailResponse: MovieDetailResponse)
    }

}