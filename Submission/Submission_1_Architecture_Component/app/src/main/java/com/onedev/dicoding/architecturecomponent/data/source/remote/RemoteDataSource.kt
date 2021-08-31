package com.onedev.dicoding.architecturecomponent.data.source.remote

import android.util.Log
import com.onedev.dicoding.architecturecomponent.BuildConfig
import com.onedev.dicoding.architecturecomponent.data.api.ApiServicesBuilder
import com.onedev.dicoding.architecturecomponent.data.source.remote.response.*
import com.onedev.dicoding.architecturecomponent.utils.EspressoIdlingResource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RemoteDataSource {

    companion object {
        private const val TAG = "RemoteDataSource"

        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(): RemoteDataSource =
            instance ?: synchronized(this) {
                instance ?: RemoteDataSource().apply {
                    instance = this
                }
            }
    }

    fun getPopularMovie(callback: LoadPopularMovieCallback) {
        EspressoIdlingResource.increment()
        ApiServicesBuilder.instance.getPopularMovie(BuildConfig.API_KEY, 1)
            .enqueue(object : Callback<MovieResponse> {
                override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                    if (response.isSuccessful) {
                        response.body()!!.results.let {
                            callback.onAllPopularMovieReceived(it)
                            EspressoIdlingResource.decrement()
                        }
                    }
                }

                override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                    Log.d(TAG, "onFailure: ${t.localizedMessage}")
                    EspressoIdlingResource.decrement()
                }
            })
    }

    fun getDetailMovie(movieId: Int, callback: LoadDetailMovieCallback) {
        EspressoIdlingResource.increment()
        ApiServicesBuilder.instance.getDetailMovie(movieId, BuildConfig.API_KEY)
            .enqueue(object : Callback<MovieDetailResponse> {
                override fun onResponse(call: Call<MovieDetailResponse>, response: Response<MovieDetailResponse>) {
                    if (response.isSuccessful) {
                        response.body()?.let {
                           callback.onAllDetailMovieReceived(it)
                            EspressoIdlingResource.decrement()
                        }
                    }
                }

                override fun onFailure(call: Call<MovieDetailResponse>, t: Throwable) {
                    Log.d(TAG, "onFailure: ${t.localizedMessage}")
                    EspressoIdlingResource.decrement()
                }
            })
    }

    fun getPopularTvShow(callback: LoadPopularTvShowCallback) {
        EspressoIdlingResource.increment()
        ApiServicesBuilder.instance.getPopularTvShow(BuildConfig.API_KEY, 1)
            .enqueue(object : Callback<TvShowResponse> {
                override fun onResponse(
                    call: Call<TvShowResponse>,
                    response: Response<TvShowResponse>
                ) {
                    if (response.isSuccessful) {
                        response.body()!!.results.let {
                            callback.onAllPopularTvShowReceived(it)
                            EspressoIdlingResource.decrement()
                        }
                    }
                }

                override fun onFailure(call: Call<TvShowResponse>, t: Throwable) {
                    Log.d(TAG, "onFailure: ${t.localizedMessage}")
                    EspressoIdlingResource.decrement()
                }

            })
    }

    fun getDetailTvShow(tvShowId: Int, callback: LoadDetailTvShowCallback) {
        EspressoIdlingResource.increment()
        ApiServicesBuilder.instance.getDetailTvShow(tvShowId, BuildConfig.API_KEY)
            .enqueue(object : Callback<TvShowDetailResponse> {
                override fun onResponse(
                    call: Call<TvShowDetailResponse>,
                    response: Response<TvShowDetailResponse>
                ) {
                    if (response.isSuccessful) {
                        response.body()?.let {
                            callback.onAllDetailTvShowReceived(it)
                            EspressoIdlingResource.decrement()
                        }
                    }
                }

                override fun onFailure(call: Call<TvShowDetailResponse>, t: Throwable) {
                    Log.d(TAG, "onFailure: ${t.localizedMessage}")
                    EspressoIdlingResource.decrement()
                }
            })
    }

    interface LoadPopularMovieCallback {
        fun onAllPopularMovieReceived(listMovieResponseResult: List<MovieResponseResult>?)
    }

    interface LoadDetailMovieCallback {
        fun onAllDetailMovieReceived(movieDetailResponse: MovieDetailResponse?)
    }

    interface LoadPopularTvShowCallback {
        fun onAllPopularTvShowReceived(listTvShowResponseResult: List<TvShowResponseResult>?)
    }

    interface LoadDetailTvShowCallback {
        fun onAllDetailTvShowReceived(tvShowDetailResponse: TvShowDetailResponse?)
    }

}