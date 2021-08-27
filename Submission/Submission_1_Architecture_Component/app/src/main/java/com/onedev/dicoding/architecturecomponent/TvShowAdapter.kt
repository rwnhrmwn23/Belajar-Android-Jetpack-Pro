package com.onedev.dicoding.architecturecomponent

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.onedev.dicoding.architecturecomponent.databinding.ItemsTvShowsBinding
import com.onedev.dicoding.architecturecomponent.helper.ExtHelper.loadImageFromDrawable
import com.onedev.dicoding.architecturecomponent.model.TvShows

class TvShowAdapter: RecyclerView.Adapter<TvShowAdapter.TvShowViewHolder>() {

    private var listTvShow = ArrayList<TvShows>()

    fun setTvShows(tvShows: List<TvShows>?) {
        if (tvShows == null) return
        this.listTvShow.clear()
        this.listTvShow.addAll(tvShows)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TvShowViewHolder {
        val binding = ItemsTvShowsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TvShowViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TvShowViewHolder, position: Int) {
        holder.bind(listTvShow[position])
    }

    override fun getItemCount(): Int = listTvShow.size

    class TvShowViewHolder(private val binding: ItemsTvShowsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(tvShows: TvShows) {
            with(binding) {
                imgPoster.loadImageFromDrawable(tvShows.image)
                tvTitleTvShow.text = tvShows.title
                tvGenreTvShow.text = tvShows.genre
//                itemView.setOnClickListener {
//                    val intent = Intent(itemView.context, DetailCourseActivity::class.java)
//                    intent.putExtra(DetailCourseActivity.EXTRA_COURSE, course.courseId)
//                    itemView.context.startActivity(intent)
//                }
            }
        }
    }
}