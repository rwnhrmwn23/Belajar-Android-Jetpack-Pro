package com.onedev.dicoding.academy.ui.bookmark

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.onedev.dicoding.academy.data.source.local.entity.CourseEntity
import com.onedev.dicoding.academy.databinding.ItemsBookmarkBinding
import com.onedev.dicoding.academy.ui.detail.DetailCourseActivity
import com.onedev.dicoding.academy.utils.ExtClass.loadImage

class BookmarkAdapter(private val callback: BookmarkFragmentCallback) :
    RecyclerView.Adapter<BookmarkAdapter.CourseViewHolder>() {

    private val listCourse = ArrayList<CourseEntity>()

    fun setCourses(course: List<CourseEntity>?) {
        if (course == null) return
        this.listCourse.clear()
        this.listCourse.addAll(course)
    }

    inner class CourseViewHolder(private val binding: ItemsBookmarkBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(course: CourseEntity) {
            with(binding) {
                imgPoster.loadImage(course.imagePath)
                tvItemTitle.text = course.title
                tvItemDate.text = course.deadline
                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailCourseActivity::class.java)
                    intent.putExtra(DetailCourseActivity.EXTRA_COURSE, course.courseId)
                    itemView.context.startActivity(intent)
                }
                imgShare.setOnClickListener { callback.onShareClick(course) }
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BookmarkAdapter.CourseViewHolder {
        val binding = ItemsBookmarkBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CourseViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BookmarkAdapter.CourseViewHolder, position: Int) {
        holder.bind(listCourse[position])
    }

    override fun getItemCount(): Int  = listCourse.size
}