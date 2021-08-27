package com.onedev.dicoding.architecturecomponent.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.ui.navigateUp
import androidx.recyclerview.widget.GridLayoutManager
import com.onedev.dicoding.architecturecomponent.BuildConfig
import com.onedev.dicoding.architecturecomponent.MovieAdapter
import com.onedev.dicoding.architecturecomponent.R
import com.onedev.dicoding.architecturecomponent.databinding.ActivityMainBinding
import com.onedev.dicoding.architecturecomponent.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.fragmentContainerView)
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

    override fun onBackPressed() {
        supportFragmentManager.apply {
            if ((findFragmentById(R.id.main_nav)?.childFragmentManager?.backStackEntryCount) ?: 0 > 1)
                super.onBackPressed()
            else
                finish()
        }
    }

}