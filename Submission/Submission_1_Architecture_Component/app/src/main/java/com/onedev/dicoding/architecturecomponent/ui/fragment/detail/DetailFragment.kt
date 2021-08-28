package com.onedev.dicoding.architecturecomponent.ui.fragment.detail

import android.content.Intent
import android.graphics.Typeface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.onedev.dicoding.architecturecomponent.R
import com.onedev.dicoding.architecturecomponent.databinding.FragmentDetailBinding
import com.onedev.dicoding.architecturecomponent.helper.ExtHelper.loadImageFromDrawable
import com.onedev.dicoding.architecturecomponent.helper.ExtHelper.setStyleToItalic
import com.onedev.dicoding.architecturecomponent.model.Movies
import com.onedev.dicoding.architecturecomponent.model.TvShows

class DetailFragment : Fragment() {
    private lateinit var viewModel: DetailViewModel

    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding
    private val args: DetailFragmentArgs by navArgs()
    private var title: String? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentDetailBinding.inflate(layoutInflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as AppCompatActivity).setSupportActionBar(binding?.toolbar)
        viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)

        when (args.type) {
            "Movie" -> {
                viewModel.setSelectedMovie(args.typeId)
                populateViewMovie(viewModel.getMovieDetail())
            }
            "TvShow" -> {
                viewModel.setSelectedTvShow(args.typeId)
                populateViewTvShow(viewModel.getTvShowDetail())
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

    private fun populateViewMovie(movieDetail: Movies) {
        (activity as AppCompatActivity).supportActionBar?.title = movieDetail.title

        title = movieDetail.title
        binding?.apply {
            imgPoster.loadImageFromDrawable(movieDetail.image)
            tvTitle.text = movieDetail.title
            tvOptionInformation.text = movieDetail.release_date
            tvGenre.text = movieDetail.genre
            tvDuration.text = movieDetail.duration
            tvOverview.text = movieDetail.overview
        }
    }

    private fun populateViewTvShow(tvShowDetail: TvShows) {
        (activity as AppCompatActivity).supportActionBar?.title = tvShowDetail.title

        title = tvShowDetail.title
        binding?.apply {
            tvOptionInformation.setStyleToItalic()
            imgPoster.loadImageFromDrawable(tvShowDetail.image)
            tvTitle.text = tvShowDetail.title
            tvOptionInformation.text = tvShowDetail.tagline
            tvGenre.text = tvShowDetail.genre
            tvDuration.text = tvShowDetail.duration
            tvOverview.text = tvShowDetail.overview
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}