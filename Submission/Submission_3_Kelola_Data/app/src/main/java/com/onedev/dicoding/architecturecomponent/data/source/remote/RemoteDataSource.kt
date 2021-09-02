package com.onedev.dicoding.architecturecomponent.data.source.remote

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
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

    fun getPopularMovie(): LiveData<ApiResponse<List<MovieResponseResult>>> {
        EspressoIdlingResource.increment()
        val resultsMovie = MutableLiveData<ApiResponse<List<MovieResponseResult>>>()
        ApiServicesBuilder.instance.getPopularMovie(BuildConfig.API_KEY, 1)
            .enqueue(object : Callback<MovieResponse> {
                override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                    if (response.isSuccessful) {
                        resultsMovie.value = ApiResponse.success(response.body()?.results as List<MovieResponseResult>)
                        EspressoIdlingResource.decrement()
                    }
                }

                override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                    Log.d(TAG, "onFailure: ${t.localizedMessage}")
                    EspressoIdlingResource.decrement()
                }
            })
        return resultsMovie
    }

    fun getDetailMovie(movieId: Int): LiveData<ApiResponse<MovieDetailResponse>> {
        EspressoIdlingResource.increment()
        val resultDetailMovie = MutableLiveData<ApiResponse<MovieDetailResponse>>()
        ApiServicesBuilder.instance.getDetailMovie(movieId, BuildConfig.API_KEY)
            .enqueue(object : Callback<MovieDetailResponse> {
                override fun onResponse(call: Call<MovieDetailResponse>, response: Response<MovieDetailResponse>) {
                    if (response.isSuccessful) {
                        response.body()?.let {
                            resultDetailMovie.value = ApiResponse.success(response.body() as MovieDetailResponse)
                            EspressoIdlingResource.decrement()
                        }
                    }
                }

                override fun onFailure(call: Call<MovieDetailResponse>, t: Throwable) {
                    Log.d(TAG, "onFailure: ${t.localizedMessage}")
                    EspressoIdlingResource.decrement()
                }
            })
        return resultDetailMovie
    }

    fun getPopularTvShow(): LiveData<ApiResponse<List<TvShowResponseResult>>> {
        EspressoIdlingResource.increment()
        val resultTvShows = MutableLiveData<ApiResponse<List<TvShowResponseResult>>>()
        ApiServicesBuilder.instance.getPopularTvShow(BuildConfig.API_KEY, 1)
            .enqueue(object : Callback<TvShowResponse> {
                override fun onResponse(
                    call: Call<TvShowResponse>,
                    response: Response<TvShowResponse>
                ) {
                    if (response.isSuccessful) {
                        resultTvShows.value = ApiResponse.success(response.body()?.results as List<TvShowResponseResult>)
                        EspressoIdlingResource.decrement()
                    }
                }

                override fun onFailure(call: Call<TvShowResponse>, t: Throwable) {
                    Log.d(TAG, "onFailure: ${t.localizedMessage}")
                    EspressoIdlingResource.decrement()
                }
            })
        return resultTvShows
    }

    fun getDetailTvShow(tvShowId: Int): LiveData<ApiResponse<TvShowDetailResponse>> {
        EspressoIdlingResource.increment()
        val resultDetailTvShows = MutableLiveData<ApiResponse<TvShowDetailResponse>>()
        ApiServicesBuilder.instance.getDetailTvShow(tvShowId, BuildConfig.API_KEY)
            .enqueue(object : Callback<TvShowDetailResponse> {
                override fun onResponse(
                    call: Call<TvShowDetailResponse>,
                    response: Response<TvShowDetailResponse>
                ) {
                    if (response.isSuccessful) {
                        resultDetailTvShows.value = ApiResponse.success(response.body() as TvShowDetailResponse)
                        EspressoIdlingResource.decrement()
                    }
                }

                override fun onFailure(call: Call<TvShowDetailResponse>, t: Throwable) {
                    Log.d(TAG, "onFailure: ${t.localizedMessage}")
                    EspressoIdlingResource.decrement()
                }
            })
        return resultDetailTvShows
    }
}