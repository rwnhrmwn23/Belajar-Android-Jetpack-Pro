package com.onedev.dicoding.architecturecomponent.utils

import android.content.Context
import android.util.Log
import com.onedev.dicoding.architecturecomponent.api.ApiServicesBuilder
import com.onedev.dicoding.architecturecomponent.data.source.remote.response.MovieResponse
import com.onedev.dicoding.architecturecomponent.data.source.remote.response.MovieResponseResult
import org.json.JSONException
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class JsonHelper(private val context: Context) {

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

    interface GetPopularMovieCallback {
        fun getPopularMovieCallback(movieResult: List<MovieResponseResult>)
    }

//    fun getPopularMovie(apiKey: String, page: Int): List<MovieResponseResult> {
//        val list = ArrayList<MovieResponseResult>()
//        try {
//            ApiServicesBuilder.instance.getPopularMovie(apiKey, page)
//                .enqueue(object : Callback<MovieResponse> {
//                    override fun onResponse(
//                        call: Call<MovieResponse>,
//                        response: Response<MovieResponse>
//                    ) {
//                        if (response.isSuccessful) {
//                            val results = response.body()!!.results
//                            if (results.isNotEmpty()) {
//                                list.addAll(results)
//                            }
//                        }
//                    }
//
//                    override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
//                        Log.d(TAG, "onFailure: ${t.localizedMessage}")
//                    }
//
//                })
//        } catch (e: JSONException) {
//            e.printStackTrace()
//        }
//        return list
//    }

}