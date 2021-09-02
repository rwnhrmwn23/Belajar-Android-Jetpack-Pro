package com.onedev.dicoding.architecturecomponent.ui.fragment.favorite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.onedev.dicoding.architecturecomponent.databinding.FragmentFavoriteMovieBinding
import com.onedev.dicoding.architecturecomponent.ui.fragment.movie.MovieAdapter
import com.onedev.dicoding.architecturecomponent.viewmodel.ViewModelFactory

class FavoriteMovieFragment : Fragment() {
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

        movieAdapter = MovieAdapter()
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
            binding?.progressBar?.visibility = View.GONE
            binding?.imgEmpty?.visibility = View.GONE
        } else {
            binding?.progressBar?.visibility = View.GONE
            binding?.imgEmpty?.visibility = View.VISIBLE
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}