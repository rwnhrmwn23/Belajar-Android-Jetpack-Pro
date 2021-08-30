package com.onedev.dicoding.academy.di

import android.content.Context
import com.onedev.dicoding.academy.data.source.AcademyRepository
import com.onedev.dicoding.academy.data.source.remote.RemoteDataSource
import com.onedev.dicoding.academy.utils.JsonHelper

object Injection {

    fun provideRepository(context: Context): AcademyRepository {
        val remoteDataSource = RemoteDataSource.getInstance(JsonHelper(context))
        return AcademyRepository.getInstance(remoteDataSource)
    }
}