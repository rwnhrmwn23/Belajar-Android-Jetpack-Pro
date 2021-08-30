package com.onedev.dicoding.architecturecomponent.di

import android.content.Context
import com.onedev.dicoding.architecturecomponent.data.source.MovieRepository
import com.onedev.dicoding.architecturecomponent.data.source.remote.RemoteDataSource
import com.onedev.dicoding.architecturecomponent.utils.JsonHelper

object Injection {

    fun provideMovieRepository(context: Context): MovieRepository {
        val remoteDataSource = RemoteDataSource.getInstance(JsonHelper(context))
        return MovieRepository.getInstance(remoteDataSource)
    }

}