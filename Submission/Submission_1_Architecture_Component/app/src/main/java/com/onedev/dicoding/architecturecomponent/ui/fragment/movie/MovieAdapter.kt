package com.onedev.dicoding.architecturecomponent.ui.fragment.movie

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.onedev.dicoding.architecturecomponent.api.PICTURE_BASE_URL
import com.onedev.dicoding.architecturecomponent.data.source.remote.response.MovieResponseResult
import com.onedev.dicoding.architecturecomponent.databinding.ItemsMoviesBinding
import com.onedev.dicoding.architecturecomponent.ui.activity.detail.DetailActivity
import com.onedev.dicoding.architecturecomponent.utils.ExtHelper.loadImage

class MovieAdapter: RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    private var listMovie = ArrayList<MovieResponseResult>()

    fun setMovies(movies: List<MovieResponseResult>?) {
        if (movies == null) return
        this.listMovie.clear()
        this.listMovie.addAll(movies)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MovieViewHolder {
        val binding = ItemsMoviesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(listMovie[position])
    }

    override fun getItemCount(): Int = listMovie.size

    class MovieViewHolder(private val binding: ItemsMoviesBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(movies: MovieResponseResult) {
            with(binding) {
                imgPoster.loadImage(PICTURE_BASE_URL+movies.poster_path)
                itemView.setOnClickListener {
                    itemView.context.startActivity(Intent(itemView.context, DetailActivity::class.java))
                }
            }
        }
    }
}