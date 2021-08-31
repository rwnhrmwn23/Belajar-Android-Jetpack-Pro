package com.onedev.dicoding.architecturecomponent.di

import com.onedev.dicoding.architecturecomponent.data.source.MovieRepository
import com.onedev.dicoding.architecturecomponent.data.source.remote.RemoteDataSource

object Injection {

    fun provideMovieRepository(): MovieRepository {
        val remoteDataSource = RemoteDataSource.getInstance()
        return MovieRepository.getInstance(remoteDataSource)
    }

}