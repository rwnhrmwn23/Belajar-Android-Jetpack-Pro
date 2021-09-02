package com.onedev.dicoding.architecturecomponent.ui.fragment.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.onedev.dicoding.architecturecomponent.data.source.MovieDataSource
import com.onedev.dicoding.architecturecomponent.data.source.local.entity.MovieEntity
import com.onedev.dicoding.architecturecomponent.data.source.local.entity.TvShowEntity
import com.onedev.dicoding.architecturecomponent.data.source.remote.RemoteDataSource
import com.onedev.dicoding.architecturecomponent.data.source.remote.response.MovieDetailResponse
import com.onedev.dicoding.architecturecomponent.data.source.remote.response.MovieResponseResult
import com.onedev.dicoding.architecturecomponent.data.source.remote.response.TvShowDetailResponse
import com.onedev.dicoding.architecturecomponent.data.source.remote.response.TvShowResponseResult

class FakeMovieRepository(private val remoteDataSource: RemoteDataSource) : MovieDataSource {

    override fun getPopularMovie(): LiveData<List<MovieEntity>> {
        val movieResults = MutableLiveData<List<MovieEntity>>()

        remoteDataSource.getPopularMovie(object : RemoteDataSource.LoadPopularMovieCallback {
            override fun onAllPopularMovieReceived(listMovieResponseResult: List<MovieResponseResult>?) {
                val movieResult = ArrayList<MovieEntity>()
                if (listMovieResponseResult != null) {
                    for (response in listMovieResponseResult) {
                        with(response) {
                            val movieEntities = MovieEntity(
                                id,
                                title,
                                poster_path,
                                vote_average,
                                null,
                                overview,
                                popularity,
                                release_date,
                                runtime,
                                status,
                                tagline)
                            movieResult.add(movieEntities)
                        }
                    }
                    movieResults.postValue(movieResult)
                }
            }
        })
        return movieResults
    }

    override fun getDetailMovie(movieId: Int): LiveData<MovieEntity> {
        val movieDetails = MutableLiveData<MovieEntity>()
        remoteDataSource.getDetailMovie(movieId, object : RemoteDataSource.LoadDetailMovieCallback {
            override fun onAllDetailMovieReceived(movieDetailResponse: MovieDetailResponse?) {
                if (movieDetailResponse != null) {
                    with(movieDetailResponse) {
                        val genres = ArrayList<String>()
                        for (genre in movieDetailResponse.genres) {
                            genres.add(genre.name)
                        }

                        val movieDetail = MovieEntity(
                            id,
                            title,
                            poster_path,
                            vote_average,
                            genres.toString(),
                            overview,
                            popularity,
                            release_date,
                            runtime,
                            status,
                            tagline)
                        movieDetails.postValue(movieDetail)
                    }
                }
            }
        })
        return movieDetails
    }

    override fun getPopularTvShow(): LiveData<List<TvShowEntity>> {
        val tvShowResults = MutableLiveData<List<TvShowEntity>>()
        remoteDataSource.getPopularTvShow(object : RemoteDataSource.LoadPopularTvShowCallback {
            override fun onAllPopularTvShowReceived(listTvShowResponseResult: List<TvShowResponseResult>?) {
                if (listTvShowResponseResult != null) {
                    val tvShowResult = ArrayList<TvShowEntity>()
                    for (response in listTvShowResponseResult) {
                        with(response) {
                            val tvShowEntities = TvShowEntity(
                                id,
                                name,
                                poster_path,
                                vote_average,
                                null,
                                overview,
                                popularity,
                                status,
                                tagline)
                            tvShowResult.add(tvShowEntities)
                        }
                    }
                    tvShowResults.postValue(tvShowResult)
                }
            }

        })
        return tvShowResults
    }

    override fun getDetailTvShow(tvShowId: Int): LiveData<TvShowEntity> {
        val tvShowDetails = MutableLiveData<TvShowEntity>()
        remoteDataSource.getDetailTvShow(tvShowId, object : RemoteDataSource.LoadDetailTvShowCallback {
            override fun onAllDetailTvShowReceived(tvShowDetailResponse: TvShowDetailResponse?) {
                if (tvShowDetailResponse != null) {
                    with(tvShowDetailResponse) {
                        val genres = ArrayList<String>()
                        for (genre in tvShowDetailResponse.genres) {
                            genres.add(genre.name)
                        }

                        val tvShowDetail = TvShowEntity(
                            id,
                            name,
                            poster_path,
                            vote_average,
                            genres.toString(),
                            overview,
                            popularity,
                            status,
                            tagline)
                        tvShowDetails.postValue(tvShowDetail)
                    }
                }
            }

        })
        return tvShowDetails
    }

}