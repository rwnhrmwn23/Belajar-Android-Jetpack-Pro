package com.onedev.dicoding.architecturecomponent.ui.activity.detail

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.onedev.dicoding.architecturecomponent.BuildConfig
import com.onedev.dicoding.architecturecomponent.R
import com.onedev.dicoding.architecturecomponent.data.api.PICTURE_BASE_URL
import com.onedev.dicoding.architecturecomponent.data.source.remote.response.MovieDetailResponse
import com.onedev.dicoding.architecturecomponent.databinding.ActivityDetailBinding
import com.onedev.dicoding.architecturecomponent.utils.ExtHelper.loadImage
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

        factory = ViewModelFactory.getInstance(this)
        viewModel = ViewModelProvider(this, factory)[DetailViewModel::class.java]

        val extras = intent.extras
        if (extras != null) {
            loading(true)
            val movieId = extras.getInt(EXTRA_ID, 0)
            when (extras.getString(EXTRA_TYPE)) {
                getString(R.string.movie) -> {
                    viewModel.getDetailMovie(movieId, BuildConfig.API_KEY).observe(this, { movie ->
                        populateViewMovie(movie)
                    })

                    loading(false)
                }
                else -> {
//                    viewModel.getDetailMovie(movieId, BuildConfig.API_KEY).observe(this, { movie ->
//                        populateViewMovie(movie)
//                    })
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

    private fun populateViewMovie(movieDetail: MovieDetailResponse) {
        supportActionBar?.title = movieDetail.title

        title = movieDetail.title
        binding?.apply {
            imgPoster.loadImage(PICTURE_BASE_URL+movieDetail.poster_path)
            tvTitle.text = movieDetail.title
            tvOptionInformation.text = movieDetail.release_date
            for (i in movieDetail.genres) {
                tvGenre.text = i.name
            }
            tvDuration.text = movieDetail.runtime.toString()
            tvOverview.text = movieDetail.overview
        }
    }

//    private fun populateViewTvShow(tvShowDetail: TvShows) {
//        (activity as AppCompatActivity).supportActionBar?.title = tvShowDetail.title
//
//        title = tvShowDetail.title
//        binding?.apply {
//            tvOptionInformation.setStyleToItalic()
//            imgPoster.loadImageFromDrawable(tvShowDetail.image)
//            tvTitle.text = tvShowDetail.title
//            tvOptionInformation.text = tvShowDetail.tagline
//            tvGenre.text = tvShowDetail.genre
//            tvDuration.text = tvShowDetail.duration
//            tvOverview.text = tvShowDetail.overview
//        }
//    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }

    companion object {
        private const val TAG = "DetailActivity"
        const val EXTRA_ID = "extra_id"
        const val EXTRA_TYPE = "extra_type"
    }
}