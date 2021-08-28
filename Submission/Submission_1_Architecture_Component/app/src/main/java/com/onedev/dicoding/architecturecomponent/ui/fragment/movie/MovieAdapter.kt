package com.onedev.dicoding.architecturecomponent.ui.fragment.movie

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.onedev.dicoding.architecturecomponent.databinding.ItemsMoviesBinding
import com.onedev.dicoding.architecturecomponent.helper.ExtHelper.loadImageFromDrawable
import com.onedev.dicoding.architecturecomponent.model.Movies
import com.onedev.dicoding.architecturecomponent.ui.fragment.home.HomeFragmentDirections

class MovieAdapter: RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    private var listMovie = ArrayList<Movies>()

    fun setMovies(movies: List<Movies>?) {
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
        fun bind(movies: Movies) {
            with(binding) {
                imgPoster.loadImageFromDrawable(movies.image)
                itemView.setOnClickListener {
                    val toDetailFragment = HomeFragmentDirections.actionHomeFragmentToDetailFragment()
                    toDetailFragment.type = "Movie"
                    toDetailFragment.typeId = movies.movie_id
                    itemView.findNavController().navigate(toDetailFragment)
                }
            }
        }
    }
}