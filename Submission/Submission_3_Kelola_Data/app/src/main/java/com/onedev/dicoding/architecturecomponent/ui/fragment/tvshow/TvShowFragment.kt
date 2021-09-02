package com.onedev.dicoding.architecturecomponent.ui.fragment.tvshow

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.onedev.dicoding.architecturecomponent.databinding.FragmentTvShowBinding
import com.onedev.dicoding.architecturecomponent.utils.ExtHelper.showToast
import com.onedev.dicoding.architecturecomponent.viewmodel.ViewModelFactory
import com.onedev.dicoding.architecturecomponent.vo.Status

class TvShowFragment : Fragment() {
    private lateinit var factory: ViewModelFactory
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

    @SuppressLint("NotifyDataSetChanged")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tvShowAdapter = TvShowAdapter()
        factory = ViewModelFactory.getInstance(requireActivity())
        viewModel = ViewModelProvider(this, factory)[TvShowViewModel::class.java]

        binding?.progressBar?.visibility = View.VISIBLE
        viewModel.getPopularTvShow().observe(viewLifecycleOwner, { tvShow ->
            if (tvShow != null) {
                when (tvShow.status) {
                    Status.LOADING -> binding?.progressBar?.visibility = View.VISIBLE
                    Status.SUCCESS -> {
                        binding?.progressBar?.visibility = View.GONE
                        tvShowAdapter.submitList(tvShow.data)
                    }
                    Status.ERROR -> {
                        binding?.progressBar?.visibility = View.GONE
                        requireContext().showToast("Terjadi Kesalahan")
                    }
                }
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