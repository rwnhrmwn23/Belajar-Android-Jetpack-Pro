package com.onedev.dicoding.architecturecomponent.ui.fragment.detail

import androidx.lifecycle.ViewModel
import com.onedev.dicoding.architecturecomponent.helper.DataDummy
import com.onedev.dicoding.architecturecomponent.model.Movies
import com.onedev.dicoding.architecturecomponent.model.TvShows

class DetailViewModel : ViewModel() {

    private lateinit var movieId: String
    private lateinit var tvShowId: String

    fun setSelectedMovie(movieId: String) {
        this.movieId = movieId
    }

    fun getMovieDetail(): Movies {
        lateinit var movies: Movies
        val movieEntities = DataDummy.generateDataDummyMovies()
        for (movieEntity in movieEntities) {
            if (movieEntity.movie_id == movieId) {
                movies = movieEntity
            }
        }
        return movies
    }

    fun setSelectedTvShow(tvShowId: String) {
        this.tvShowId = tvShowId
    }

    fun getTvShowDetail(): TvShows {
        lateinit var tvShows: TvShows
        val tvShowEntities = DataDummy.generateDataDummyTvShows()
        for (tvShowEntity in tvShowEntities) {
            if (tvShowEntity.tv_show_id == tvShowId) {
                tvShows = tvShowEntity
            }
        }
        return tvShows
    }
}