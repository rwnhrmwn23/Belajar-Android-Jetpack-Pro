package com.onedev.dicoding.academy.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.onedev.dicoding.academy.R
import com.onedev.dicoding.academy.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val pagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)
        binding.viewPager.adapter = pagerAdapter
        binding.tabs.setupWithViewPager(binding.viewPager)

        supportActionBar?.elevation = 0F
    }
}