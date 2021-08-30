package com.onedev.dicoding.architecturecomponent.ui.activity.main

import android.os.Bundle
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.tabs.TabLayoutMediator
import com.onedev.dicoding.architecturecomponent.R
import com.onedev.dicoding.architecturecomponent.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sectionPagerAdapter = MainPagerAdapter(this)
        binding.viewPager.adapter = sectionPagerAdapter
        binding.viewPager.setPageTransformer(ZoomOutPageTransformer())

        TabLayoutMediator(binding.tabs, binding.viewPager) { tab, position ->
            tab.text = resources.getString(TAB_TITLES[position])
        }.attach()

        supportActionBar?.elevation = 0F
    }

    companion object {
        @StringRes
        private val TAB_TITLES = intArrayOf(
            R.string.movie,
            R.string.tv_show
        )
    }

}