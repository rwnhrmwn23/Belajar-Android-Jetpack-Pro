package com.onedev.dicoding.architecturecomponent.ui.fragment.movie

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
import com.onedev.dicoding.architecturecomponent.databinding.FragmentMovieBinding
import com.onedev.dicoding.architecturecomponent.ui.activity.detail.DetailActivity
import com.onedev.dicoding.architecturecomponent.utils.ExtHelper.showToast
import com.onedev.dicoding.architecturecomponent.viewmodel.ViewModelFactory
import com.onedev.dicoding.architecturecomponent.vo.Status

class MovieFragment : Fragment(), MovieAdapter.ItemClicked {
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

        movieAdapter = MovieAdapter(this)
        factory = ViewModelFactory.getInstance(requireActivity())
        viewModel = ViewModelProvider(this, factory)[MovieViewModel::class.java]

        viewModel.getPopularMovie().observe(viewLifecycleOwner, { movies ->
            if (movies != null) {
                when (movies.status) {
                    Status.LOADING -> binding?.progressBar?.visibility = View.VISIBLE
                    Status.SUCCESS -> {
                        binding?.progressBar?.visibility = View.GONE
                        movieAdapter.submitList(movies.data)
                    }
                    Status.ERROR -> {
                        binding?.progressBar?.visibility = View.VISIBLE
                        requireContext().showToast("Terjadi Kesalahan")
                    }
                }
            }
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

    override fun intentToDetailActivity(movies: MovieEntity) {
        val intent = Intent(requireContext(), DetailActivity::class.java)
        intent.putExtra(DetailActivity.EXTRA_ID, movies.id)
        intent.putExtra(DetailActivity.EXTRA_TYPE, getString(R.string.movie))
        requireContext().startActivity(intent)
    }
}