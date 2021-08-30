package com.onedev.dicoding.architecturecomponent.ui.fragment.tvshow

import androidx.lifecycle.ViewModel
import com.onedev.dicoding.architecturecomponent.utils.DataDummy
import com.onedev.dicoding.architecturecomponent.data.source.local.TvShows

class TvShowViewModel : ViewModel() {

    fun getTvShows(): List<TvShows> {
        return DataDummy.generateDataDummyTvShows()
    }

}