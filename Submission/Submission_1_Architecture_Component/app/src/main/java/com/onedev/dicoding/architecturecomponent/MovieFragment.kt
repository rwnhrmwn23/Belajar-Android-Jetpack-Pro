package com.onedev.dicoding.architecturecomponent

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.onedev.dicoding.architecturecomponent.databinding.FragmentMovieBinding
import com.onedev.dicoding.architecturecomponent.viewmodel.MainViewModel

class MovieFragment : Fragment() {
    private lateinit var viewModel: MainViewModel
    private lateinit var movieAdapter: MovieAdapter

    private var _binding: FragmentMovieBinding? = null
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentMovieBinding.inflate(layoutInflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        movieAdapter = MovieAdapter()
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        val movies = viewModel.getMovies()
        binding?.rvResult.apply {
            movieAdapter.setMovies(movies)
            this?.setHasFixedSize(true)
            this?.layoutManager = GridLayoutManager(requireContext(), 3)
            this?.adapter = movieAdapter
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}