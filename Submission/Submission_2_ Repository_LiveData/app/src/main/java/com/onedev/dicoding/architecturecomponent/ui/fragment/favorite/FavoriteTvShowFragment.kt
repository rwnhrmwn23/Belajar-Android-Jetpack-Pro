package com.onedev.dicoding.architecturecomponent.ui.fragment.favorite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.onedev.dicoding.architecturecomponent.databinding.FragmentFavoriteTvShowBinding
import com.onedev.dicoding.architecturecomponent.ui.fragment.tvshow.TvShowAdapter
import com.onedev.dicoding.architecturecomponent.viewmodel.ViewModelFactory

class FavoriteTvShowFragment : Fragment() {
    private lateinit var viewModel: FavoriteViewModel
    private lateinit var factory: ViewModelFactory
    private lateinit var tvShowAdapter: TvShowAdapter

    private var _binding: FragmentFavoriteTvShowBinding? = null
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentFavoriteTvShowBinding.inflate(layoutInflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tvShowAdapter = TvShowAdapter()
        factory = ViewModelFactory.getInstance(requireActivity())
        viewModel = ViewModelProvider(this, factory)[FavoriteViewModel::class.java]

        binding?.progressBar?.visibility = View.VISIBLE
        viewModel.getFavoriteTvShow().observe(viewLifecycleOwner, { tvShow ->
            if (tvShow != null) {
                binding?.progressBar?.visibility = View.GONE
                tvShowAdapter.setTvShows(tvShow)
                tvShowAdapter.notifyDataSetChanged()
            }
        })

        binding?.rvTvShow?.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(requireContext())
            adapter = tvShowAdapter
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}