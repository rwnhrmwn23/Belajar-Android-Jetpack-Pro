package com.onedev.dicoding.architecturecomponent.ui.activity.detail

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.onedev.dicoding.architecturecomponent.R
import com.onedev.dicoding.architecturecomponent.data.api.PICTURE_BASE_URL
import com.onedev.dicoding.architecturecomponent.data.source.local.MovieDetailEntity
import com.onedev.dicoding.architecturecomponent.data.source.local.TvShowDetailEntity
import com.onedev.dicoding.architecturecomponent.databinding.ActivityDetailBinding
import com.onedev.dicoding.architecturecomponent.utils.ExtHelper.loadImage
import com.onedev.dicoding.architecturecomponent.utils.ExtHelper.setStyleToItalic
import com.onedev.dicoding.architecturecomponent.viewmodel.ViewModelFactory

class DetailActivity : AppCompatActivity() {

    private var binding: ActivityDetailBinding? = null
    private lateinit var factory: ViewModelFactory
    private lateinit var viewModel: DetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        setSupportActionBar(binding?.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        factory = ViewModelFactory.getInstance()
        viewModel = ViewModelProvider(this, factory)[DetailViewModel::class.java]

        val extras = intent.extras
        if (extras != null) {
            loading(true)
            val id = extras.getInt(EXTRA_ID, 0)
            when (extras.getString(EXTRA_TYPE)) {
                getString(R.string.movie) -> {
                    viewModel.getDetailMovie(id).observe(this, { movie ->
                        populateViewMovie(movie)
                    })
                    loading(false)
                }
                else -> {
                    viewModel.getDetailTvShow(id).observe(this, { tvShow ->
                        populateViewTvShow(tvShow)
                    })
                    loading(false)
                }
            }
        }

        binding?.cardShare?.setOnClickListener {
            val textToShare = getString(R.string.share_info, title)
            val intent = Intent().apply {
                action = Intent.ACTION_SEND
                type = "text/plain"
                putExtra(Intent.EXTRA_TEXT, textToShare)
            }
            startActivity(Intent.createChooser(intent, "Share"))
        }
    }

    private fun loading(state: Boolean) {
        if (state) {
            binding?.progressBar?.visibility = View.VISIBLE
            binding?.content?.visibility = View.INVISIBLE
        } else {
            binding?.progressBar?.visibility = View.GONE
            binding?.content?.visibility = View.VISIBLE
        }
    }

    private fun populateViewMovie(movieDetail: MovieDetailEntity) {
        title = movieDetail.title
        supportActionBar?.title = title

        binding?.apply {
            imgPoster.loadImage(PICTURE_BASE_URL + movieDetail.poster_path)
            tvTitle.text = movieDetail.title
            tvOptionInformation.text = movieDetail.release_date
            tvGenre.text = movieDetail.genres.toString()
            tvDuration.text = movieDetail.runtime.toString()
            tvOverview.text = movieDetail.overview
        }
    }

    private fun populateViewTvShow(tvShowDetail: TvShowDetailEntity) {
        title = tvShowDetail.name
        supportActionBar?.title = title

        binding?.apply {
            tvOptionInformation.setStyleToItalic()
            imgPoster.loadImage(PICTURE_BASE_URL + tvShowDetail.poster_path)
            tvTitle.text = tvShowDetail.name
            tvOptionInformation.text = tvShowDetail.tagline
            tvGenre.text = tvShowDetail.genres.toString()
            tvOverview.text = tvShowDetail.overview
            tvDuration.visibility = View.INVISIBLE
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }

    companion object {
        const val EXTRA_ID = "extra_id"
        const val EXTRA_TYPE = "extra_type"
    }
}