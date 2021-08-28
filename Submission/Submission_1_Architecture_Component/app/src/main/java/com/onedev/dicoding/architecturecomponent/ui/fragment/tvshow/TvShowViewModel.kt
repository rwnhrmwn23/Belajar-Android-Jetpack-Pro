package com.onedev.dicoding.architecturecomponent.ui.fragment.tvshow

import androidx.lifecycle.ViewModel
import com.onedev.dicoding.architecturecomponent.helper.DataDummy
import com.onedev.dicoding.architecturecomponent.model.TvShows

class TvShowViewModel : ViewModel() {

    fun getTvShows(): List<TvShows> {
        return DataDummy.generateDataDummyTvShows()
    }

}