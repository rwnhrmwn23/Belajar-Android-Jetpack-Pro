package com.onedev.dicoding.architecturecomponent.ui.fragment.tvshow

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.onedev.dicoding.architecturecomponent.R
import com.onedev.dicoding.architecturecomponent.data.api.PICTURE_BASE_URL
import com.onedev.dicoding.architecturecomponent.data.source.remote.response.TvShowResponseResult
import com.onedev.dicoding.architecturecomponent.databinding.ItemsTvShowsBinding
import com.onedev.dicoding.architecturecomponent.ui.activity.detail.DetailActivity
import com.onedev.dicoding.architecturecomponent.utils.ExtHelper.loadImage

class TvShowAdapter : RecyclerView.Adapter<TvShowAdapter.TvShowViewHolder>() {

    private var listTvShow = ArrayList<TvShowResponseResult>()

    fun setTvShows(tvShows: List<TvShowResponseResult>?) {
        if (tvShows == null) return
        this.listTvShow.clear()
        this.listTvShow.addAll(tvShows)
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
        holder.bind(listTvShow[position])
    }

    override fun getItemCount(): Int = listTvShow.size

    class TvShowViewHolder(private val binding: ItemsTvShowsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(tvShows: TvShowResponseResult) {
            with(binding) {
                imgPoster.loadImage(PICTURE_BASE_URL+tvShows.poster_path)
                tvTitleTvShow.text = tvShows.name
                tvVoteAverage.text = tvShows.vote_average.toString()
                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailActivity::class.java)
                    intent.putExtra(DetailActivity.EXTRA_ID, tvShows.id)
                    intent.putExtra(DetailActivity.EXTRA_TYPE, itemView.resources.getString(R.string.tv_show))
                    itemView.context.startActivity(intent)
                }
            }
        }
    }
}