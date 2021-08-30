package com.onedev.dicoding.architecturecomponent.ui.activity.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.onedev.dicoding.architecturecomponent.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    private var binding: ActivityDetailBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        setSupportActionBar(binding?.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

//        viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)

//        when (args.type) {
//            "Movie" -> {
//                viewModel.setSelectedMovie(args.typeId)
//                populateViewMovie(viewModel.getMovieDetail())
//            }
//            "TvShow" -> {
//                viewModel.setSelectedTvShow(args.typeId)
//                populateViewTvShow(viewModel.getTvShowDetail())
//            }
//        }

//        binding?.cardShare?.setOnClickListener {
//            val textToShare = getString(R.string.share_info, title)
//            val intent = Intent().apply {
//                action = Intent.ACTION_SEND
//                type = "text/plain"
//                putExtra(Intent.EXTRA_TEXT, textToShare)
//            }
//            startActivity(Intent.createChooser(intent, "Share"))
//        }
    }
//    private fun populateViewMovie(movieDetail: Movies) {
//        (activity as AppCompatActivity).supportActionBar?.title = movieDetail.title
//
//        title = movieDetail.title
//        binding?.apply {
//            imgPoster.loadImageFromDrawable(movieDetail.image)
//            tvTitle.text = movieDetail.title
//            tvOptionInformation.text = movieDetail.release_date
//            tvGenre.text = movieDetail.genre
//            tvDuration.text = movieDetail.duration
//            tvOverview.text = movieDetail.overview
//        }
//    }

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
}