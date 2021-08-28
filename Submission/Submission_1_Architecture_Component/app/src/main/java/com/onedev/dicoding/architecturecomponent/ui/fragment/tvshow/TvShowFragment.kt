package com.onedev.dicoding.architecturecomponent.ui.fragment.tvshow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.onedev.dicoding.architecturecomponent.databinding.FragmentTvShowBinding

class TvShowFragment : Fragment() {
    private lateinit var viewModel: TvShowViewModel
    private lateinit var tvShowAdapter: TvShowAdapter
    private var _binding: FragmentTvShowBinding? = null
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTvShowBinding.inflate(layoutInflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tvShowAdapter = TvShowAdapter()
        viewModel = ViewModelProvider(this).get(TvShowViewModel::class.java)

        val tvShows = viewModel.getTvShows()
        binding?.rvTvShow.apply {
            tvShowAdapter.setTvShows(tvShows)
            this?.setHasFixedSize(true)
            this?.layoutManager = LinearLayoutManager(requireContext())
            this?.adapter = tvShowAdapter
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}