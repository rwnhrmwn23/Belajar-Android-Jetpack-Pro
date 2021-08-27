package com.onedev.dicoding.architecturecomponent.viewmodel

import androidx.lifecycle.ViewModel
import com.onedev.dicoding.architecturecomponent.helper.DataDummy
import com.onedev.dicoding.architecturecomponent.model.Movies
import com.onedev.dicoding.architecturecomponent.model.TvShows

class MainViewModel : ViewModel() {

    fun getMovies(): List<Movies> {
        return DataDummy.generateDataDummyMovies()
    }

    fun getTvShows(): List<TvShows> {
        return DataDummy.generateDataDummyTvShows()
    }

}