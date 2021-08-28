package com.onedev.dicoding.architecturecomponent.ui.fragment.movie

import androidx.lifecycle.ViewModel
import com.onedev.dicoding.architecturecomponent.helper.DataDummy
import com.onedev.dicoding.architecturecomponent.model.Movies
import com.onedev.dicoding.architecturecomponent.model.TvShows

class MovieViewModel : ViewModel() {

    fun getMovies(): List<Movies> {
        return DataDummy.generateDataDummyMovies()
    }

}