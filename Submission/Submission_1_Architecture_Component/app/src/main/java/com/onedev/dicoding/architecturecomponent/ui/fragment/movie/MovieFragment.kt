package com.onedev.dicoding.architecturecomponent.ui.fragment.movie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.onedev.dicoding.architecturecomponent.databinding.FragmentMovieBinding
import com.onedev.dicoding.architecturecomponent.viewmodel.ViewModelFactory

class MovieFragment : Fragment() {
    private lateinit var viewModel: MovieViewModel
    private lateinit var factory: ViewModelFactory
    private lateinit var movieAdapter: MovieAdapter

    private var _binding: FragmentMovieBinding? = null
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMovieBinding.inflate(layoutInflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        movieAdapter = MovieAdapter()
        factory = ViewModelFactory.getInstance()
        viewModel = ViewModelProvider(this, factory)[MovieViewModel::class.java]

        binding?.progressBar?.visibility = View.VISIBLE
        viewModel.getPopularMovie().observe(viewLifecycleOwner, { movies ->
            binding?.progressBar?.visibility = View.GONE
            movieAdapter.setMovies(movies)
            movieAdapter.notifyDataSetChanged()
        })

        binding?.rvMovie?.apply {
            setHasFixedSize(true)
            layoutManager = GridLayoutManager(requireContext(), 3)
            adapter = movieAdapter
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}