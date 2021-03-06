package com.onedev.dicoding.academy.di

import android.content.Context
import com.onedev.dicoding.academy.data.source.AcademyRepository
import com.onedev.dicoding.academy.data.source.local.LocalDataSource
import com.onedev.dicoding.academy.data.source.local.room.AcademyDatabase
import com.onedev.dicoding.academy.data.source.remote.RemoteDataSource
import com.onedev.dicoding.academy.utils.AppExecutors
import com.onedev.dicoding.academy.utils.JsonHelper

object Injection {

    fun provideRepository(context: Context): AcademyRepository {
        val database = AcademyDatabase.getInstance(context)
        val remoteDataSource = RemoteDataSource.getInstance(JsonHelper(context))
        val localDataSource = LocalDataSource.getInstance(database.academyDao())
        val appExecutors = AppExecutors()

        return AcademyRepository.getInstance(remoteDataSource, localDataSource, appExecutors)
    }
}