package com.onedev.dicoding.architecturecomponent.ui.fragment.favorite

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.onedev.dicoding.architecturecomponent.R
import com.onedev.dicoding.architecturecomponent.data.source.local.entity.MovieEntity
import com.onedev.dicoding.architecturecomponent.databinding.FragmentFavoriteMovieBinding
import com.onedev.dicoding.architecturecomponent.ui.activity.detail.DetailActivity
import com.onedev.dicoding.architecturecomponent.ui.fragment.movie.MovieAdapter
import com.onedev.dicoding.architecturecomponent.utils.ExtHelper.gone
import com.onedev.dicoding.architecturecomponent.utils.ExtHelper.visible
import com.onedev.dicoding.architecturecomponent.viewmodel.ViewModelFactory

class FavoriteMovieFragment : Fragment(), MovieAdapter.ItemClicked {
    private lateinit var viewModel: FavoriteViewModel
    private lateinit var factory: ViewModelFactory
    private lateinit var movieAdapter: MovieAdapter

    private var _binding: FragmentFavoriteMovieBinding? = null
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentFavoriteMovieBinding.inflate(layoutInflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        movieAdapter = MovieAdapter(this)
        factory = ViewModelFactory.getInstance(requireActivity())
        viewModel = ViewModelProvider(this, factory)[FavoriteViewModel::class.java]

        binding?.progressBar?.visibility = View.VISIBLE
        viewModel.getFavoriteMovie().observe(viewLifecycleOwner, { movies ->
            if (movies.size > 0) {
                showData(true)
                movieAdapter.submitList(movies)
            } else {
                showData(false)
            }
        })

        binding?.rvFavMovie?.apply {
            setHasFixedSize(true)
            layoutManager = GridLayoutManager(requireContext(), 3)
            adapter = movieAdapter
        }
    }

    private fun showData(state: Boolean) {
        if (state) {
            binding?.progressBar?.gone()
            binding?.imgEmpty?.gone()
        } else {
            binding?.rvFavMovie?.gone()
            binding?.progressBar?.gone()
            binding?.imgEmpty?.visible()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun intentToDetailActivity(movies: MovieEntity) {
        val intent = Intent(requireContext(), DetailActivity::class.java)
        intent.putExtra(DetailActivity.EXTRA_ID, movies.id)
        intent.putExtra(DetailActivity.EXTRA_TYPE, getString(R.string.movie))
        requireContext().startActivity(intent)
    }
}