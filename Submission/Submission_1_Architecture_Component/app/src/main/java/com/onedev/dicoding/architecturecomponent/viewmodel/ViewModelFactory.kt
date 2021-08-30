package com.onedev.dicoding.architecturecomponent.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.onedev.dicoding.architecturecomponent.data.source.MovieRepository
import com.onedev.dicoding.architecturecomponent.di.Injection
import com.onedev.dicoding.architecturecomponent.ui.fragment.movie.MovieViewModel

class ViewModelFactory private constructor(private val movieRepository: MovieRepository) :
    ViewModelProvider.NewInstanceFactory() {

    companion object {
        @Volatile
        private var instance: ViewModelFactory? = null

        fun getInstance(context: Context): ViewModelFactory =
            instance ?: synchronized(this) {
                instance ?: ViewModelFactory(Injection.provideMovieRepository(context)).apply {
                    instance = this
                }
            }
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        when {
            modelClass.isAssignableFrom(MovieViewModel::class.java) -> {
                return MovieViewModel(movieRepository) as T
            }

            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }
    }
}