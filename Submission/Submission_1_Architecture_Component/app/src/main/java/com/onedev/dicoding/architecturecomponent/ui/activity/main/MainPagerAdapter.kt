package com.onedev.dicoding.architecturecomponent.ui.activity.main

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.onedev.dicoding.architecturecomponent.ui.fragment.movie.MovieFragment
import com.onedev.dicoding.architecturecomponent.ui.fragment.tvshow.TvShowFragment

class MainPagerAdapter(activity: AppCompatActivity): FragmentStateAdapter(activity) {
    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        var fragment: Fragment? = null
        when (position) {
            0 -> fragment = MovieFragment()
            1 -> fragment = TvShowFragment()
        }
        return fragment as Fragment
    }

}