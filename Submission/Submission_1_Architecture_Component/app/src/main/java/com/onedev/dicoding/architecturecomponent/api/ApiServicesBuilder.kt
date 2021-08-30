package com.onedev.dicoding.architecturecomponent.api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = "https://api.themoviedb.org/3/"
const val PICTURE_BASE_URL = "https://image.tmdb.org/t/p/w500"

object ApiServicesBuilder {

    private val okHttpClient = OkHttpClient.Builder()
        .addInterceptor { chain ->
            val original = chain.request()
            val requestBuilder = original.newBuilder()
                .method(original.method(), original.body())
            val request = requestBuilder.build()
            chain.proceed(request)
        }
        .build()

    val instance: ApiServices by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
        retrofit.create(ApiServices::class.java)
    }
}

