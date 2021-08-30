package com.onedev.dicoding.architecturecomponent.api

import com.onedev.dicoding.architecturecomponent.data.source.remote.response.MovieResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiServices {

    @GET("movie/popular")
    fun getPopularMovie(
        @Query("api_key") api_key: String,
        @Query("page") page: Int
    ): Call<MovieResponse>
}