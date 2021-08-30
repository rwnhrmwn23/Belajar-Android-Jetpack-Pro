package com.onedev.dicoding.architecturecomponent.data.source

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.onedev.dicoding.architecturecomponent.data.source.remote.RemoteDataSource
import com.onedev.dicoding.architecturecomponent.data.source.remote.response.MovieResponseResult

class MovieRepository private constructor(private val remoteDataSource: RemoteDataSource) :
    MovieDataSource {

    companion object {
        @Volatile
        private var instance: MovieRepository? = null

        fun getInstance(remoteData: RemoteDataSource): MovieRepository =
            instance ?: synchronized(this) {
                instance ?: MovieRepository(remoteData).apply {
                    instance = this
                }
            }
    }
    override fun getPopularMovie(apiKey: String, page: Int): LiveData<List<MovieResponseResult>> {
        val movieResults = MutableLiveData<List<MovieResponseResult>>()
        remoteDataSource.getPopularMovie(apiKey, page, object : RemoteDataSource.LoadPopularMovieCallback {
            override fun onAllPopularMovieReceived(movieResult: List<MovieResponseResult>) {
                movieResults.postValue(movieResult)
            }
        })
        return movieResults
    }

}