package com.onedev.dicoding.architecturecomponent.ui.fragment.favorite

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.onedev.dicoding.architecturecomponent.R
import com.onedev.dicoding.architecturecomponent.data.source.local.entity.TvShowEntity
import com.onedev.dicoding.architecturecomponent.databinding.FragmentFavoriteTvShowBinding
import com.onedev.dicoding.architecturecomponent.ui.activity.detail.DetailActivity
import com.onedev.dicoding.architecturecomponent.ui.fragment.tvshow.TvShowAdapter
import com.onedev.dicoding.architecturecomponent.viewmodel.ViewModelFactory

class FavoriteTvShowFragment : Fragment(), TvShowAdapter.ItemClicked {
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

        tvShowAdapter = TvShowAdapter(this)
        factory = ViewModelFactory.getInstance(requireActivity())
        viewModel = ViewModelProvider(this, factory)[FavoriteViewModel::class.java]

        binding?.progressBar?.visibility = View.VISIBLE
        viewModel.getFavoriteTvShow().observe(viewLifecycleOwner, { tvShow ->
            if (tvShow.size > 0) {
                showData(true)
                tvShowAdapter.submitList(tvShow)
            } else {
                showData(false)
            }
        })

        binding?.rvFavTvShow?.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(requireContext())
            adapter = tvShowAdapter
        }

    }

    private fun showData(state: Boolean) {
        if (state) {
            binding?.progressBar?.visibility = View.GONE
            binding?.imgEmpty?.visibility = View.GONE
        } else {
            binding?.rvFavTvShow?.visibility = View.GONE
            binding?.progressBar?.visibility = View.GONE
            binding?.imgEmpty?.visibility = View.VISIBLE
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun intentToDetailActivity(tvShows: TvShowEntity) {
        val intent = Intent(requireContext(), DetailActivity::class.java)
        intent.putExtra(DetailActivity.EXTRA_ID, tvShows.id)
        intent.putExtra(DetailActivity.EXTRA_TYPE, getString(R.string.tv_show))
        requireContext().startActivity(intent)
    }
}