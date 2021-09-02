package com.onedev.dicoding.architecturecomponent.ui.activity.detail

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.onedev.dicoding.architecturecomponent.R
import com.onedev.dicoding.architecturecomponent.data.api.PICTURE_BASE_URL
import com.onedev.dicoding.architecturecomponent.data.source.local.entity.MovieEntity
import com.onedev.dicoding.architecturecomponent.data.source.local.entity.TvShowEntity
import com.onedev.dicoding.architecturecomponent.databinding.ActivityDetailBinding
import com.onedev.dicoding.architecturecomponent.utils.ExtHelper.loadImage
import com.onedev.dicoding.architecturecomponent.utils.ExtHelper.setStyleToItalic
import com.onedev.dicoding.architecturecomponent.utils.ExtHelper.showToast
import com.onedev.dicoding.architecturecomponent.viewmodel.ViewModelFactory
import com.onedev.dicoding.architecturecomponent.vo.Status

class DetailActivity : AppCompatActivity(), View.OnClickListener {

    private var binding: ActivityDetailBinding? = null
    private lateinit var factory: ViewModelFactory
    private lateinit var viewModel: DetailViewModel
    private lateinit var movieEntity: MovieEntity
    private lateinit var tvShowEntity: TvShowEntity

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
            val id = extras.getInt(EXTRA_ID, 0)
            when (extras.getString(EXTRA_TYPE)) {
                getString(R.string.movie) -> {
                    viewModel.getDetailMovie(id).observe(this, { movie ->
                        if (movie != null) {
                            when (movie.status) {
                                Status.LOADING -> {
                                    loading(true)
                                }
                                Status.SUCCESS -> {
                                    loading(false)
                                    movie.data?.let { data ->
                                        movieEntity = data
                                        populateViewMovie(movieEntity)
                                    }
                                }
                                Status.ERROR -> {
                                    binding?.progressBar?.visibility = View.VISIBLE
                                    this.showToast("Terjadi Kesalahan")
                                }
                            }
                        }
                    })
                }
                else -> {
                    viewModel.getDetailTvShow(id).observe(this, { tvShow ->
                        if (tvShow != null) {
                            when (tvShow.status) {
                                Status.LOADING -> loading(true)
                                Status.SUCCESS -> {
                                    loading(false)
                                    tvShow.data?.let { data ->
                                        tvShowEntity = data
                                        populateViewTvShow(tvShowEntity)
                                    }
                                }
                                Status.ERROR -> {
                                    binding?.progressBar?.visibility = View.VISIBLE
                                    this.showToast("Terjadi Kesalahan")
                                }
                            }
                        }
                    })
                }
            }
        }

        binding?.cardShare?.setOnClickListener(this)
        binding?.fabFavorite?.setOnClickListener(this)
    }

    private fun loading(state: Boolean) {
        if (state) {
            binding?.progressBar?.visibility = View.VISIBLE
            binding?.content?.visibility = View.GONE
        } else {
            binding?.progressBar?.visibility = View.GONE
            binding?.content?.visibility = View.VISIBLE
        }
    }

    private fun populateViewMovie(movieDetail: MovieEntity) {
        title = movieDetail.title
        supportActionBar?.title = title

        binding?.apply {
            imgPoster.loadImage(PICTURE_BASE_URL + movieDetail.poster_path)
            collapsing.title = title
            tvOptionInformation.text = movieDetail.release_date
            tvGenre.text = movieDetail.genres.toString()
            tvDuration.text = movieDetail.runtime.toString()
            tvOverview.text = movieDetail.overview
            setFavoriteState(movieDetail.favorite)
        }
    }

    private fun populateViewTvShow(tvShowDetail: TvShowEntity) {
        title = tvShowDetail.name
        supportActionBar?.title = title

        binding?.apply {
            tvOptionInformation.setStyleToItalic()
            imgPoster.loadImage(PICTURE_BASE_URL + tvShowDetail.poster_path)
            tvOptionInformation.text = tvShowDetail.tagline
            tvGenre.text = tvShowDetail.genres.toString()
            tvOverview.text = tvShowDetail.overview
            tvDuration.visibility = View.INVISIBLE
            setFavoriteState(tvShowDetail.favorite)
        }
    }

    private fun setFavoriteState(state: Boolean) {
        if (state)
            binding?.fabFavorite?.setImageResource(R.drawable.ic_baseline_favorite)
        else
            binding?.fabFavorite?.setImageResource(R.drawable.ic_baseline_favorite_border)
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
    override fun onClick(v: View?) {
        when (v) {
            binding?.cardShare -> {
                val textToShare = getString(R.string.share_info, title)
                val intent = Intent().apply {
                    action = Intent.ACTION_SEND
                    type = "text/plain"
                    putExtra(Intent.EXTRA_TEXT, textToShare)
                }
                startActivity(Intent.createChooser(intent, "Share"))
            }
            binding?.fabFavorite -> {
                val extras = intent.extras
                if (extras != null) {
                    when (extras.getString(EXTRA_TYPE)) {
                        getString(R.string.movie) -> viewModel.setFavoriteMovie(movieEntity, !movieEntity.favorite)
                        else -> viewModel.setTvShowMovie(tvShowEntity, !tvShowEntity.favorite)
                    }
                }
            }
        }
    }

    companion object {
        const val EXTRA_ID = "extra_id"
        const val EXTRA_TYPE = "extra_type"
    }

}