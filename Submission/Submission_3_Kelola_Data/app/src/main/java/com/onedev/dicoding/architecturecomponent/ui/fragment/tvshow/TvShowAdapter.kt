package com.onedev.dicoding.architecturecomponent.ui.fragment.tvshow

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.onedev.dicoding.architecturecomponent.data.api.PICTURE_BASE_URL
import com.onedev.dicoding.architecturecomponent.data.source.local.entity.TvShowEntity
import com.onedev.dicoding.architecturecomponent.databinding.ItemsTvShowsBinding
import com.onedev.dicoding.architecturecomponent.utils.ExtHelper.loadImage

class TvShowAdapter(private val callback: ItemClicked) :
    PagedListAdapter<TvShowEntity, TvShowAdapter.TvShowViewHolder>(DIFF_CALLBACK) {

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<TvShowEntity>() {
            override fun areItemsTheSame(oldItem: TvShowEntity, newItem: TvShowEntity): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: TvShowEntity, newItem: TvShowEntity): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TvShowViewHolder {
        val binding =
            ItemsTvShowsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TvShowViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TvShowViewHolder, position: Int) {
        val course = getItem(position)
        if (course != null) {
            holder.bind(course)
        }
    }

    inner class TvShowViewHolder(private val binding: ItemsTvShowsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(tvShows: TvShowEntity) {
            with(binding) {
                imgPoster.loadImage(PICTURE_BASE_URL + tvShows.poster_path)
                tvTitleTvShow.text = tvShows.name
                tvVoteAverage.text = tvShows.vote_average.toString()
                itemView.setOnClickListener {
                    callback.intentToDetailActivity(tvShows)
                }
            }
        }
    }

    interface ItemClicked {
        fun intentToDetailActivity(tvShows: TvShowEntity)
    }
}