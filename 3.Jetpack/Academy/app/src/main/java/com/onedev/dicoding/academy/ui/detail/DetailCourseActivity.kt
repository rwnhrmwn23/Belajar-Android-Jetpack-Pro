package com.onedev.dicoding.academy.ui.detail

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.onedev.dicoding.academy.R
import com.onedev.dicoding.academy.data.CourseEntity
import com.onedev.dicoding.academy.databinding.ActivityDetailCourseBinding
import com.onedev.dicoding.academy.databinding.ContentDetailCourseBinding
import com.onedev.dicoding.academy.ui.course.CourseReaderActivity
import com.onedev.dicoding.academy.utils.ExtClass.loadImageWithTransform
import com.onedev.dicoding.academy.viewmodel.ViewModelFactory

class DetailCourseActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_COURSE = "extra_course"
    }

    private lateinit var detailContentBinding: ContentDetailCourseBinding

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityDetailCourseBinding.inflate(layoutInflater)
        detailContentBinding = binding.detailContent
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val factory = ViewModelFactory.getInstance(this)
        val viewModel = ViewModelProvider(this, factory)[DetailCourseViewModel::class.java]

        val detailCourseAdapter = DetailCourseAdapter()
        val extras = intent.extras
        if (extras != null) {
            val courseId = extras.getString(EXTRA_COURSE)
            if (courseId != null) {
                binding.progressBar.visibility = View.VISIBLE
                binding.content.visibility = View.INVISIBLE

                viewModel.setSelectedCourse(courseId)
                viewModel.getModules().observe(this, {
                    binding.progressBar.visibility = View.GONE
                    binding.content.visibility = View.VISIBLE

                    detailCourseAdapter.setModule(it)
                    detailCourseAdapter.notifyDataSetChanged()
                })
                viewModel.getCourse().observe(this, {
                    populateCourse(it)
                })
            }
        }

        with(detailContentBinding.rvModule) {
            isNestedScrollingEnabled = false
            layoutManager = LinearLayoutManager(this@DetailCourseActivity)
            setHasFixedSize(true)
            adapter = detailCourseAdapter
            val dividerItemDecoration = DividerItemDecoration(this.context, DividerItemDecoration.VERTICAL)
            addItemDecoration(dividerItemDecoration)
        }
    }

    private fun populateCourse(courseEntity: CourseEntity) {
        detailContentBinding.imagePoster.loadImageWithTransform(courseEntity.imagePath)
        detailContentBinding.textTitle.text = courseEntity.title
        detailContentBinding.textDescription.text = courseEntity.description
        detailContentBinding.textDate.text = getString(R.string.deadline_date, courseEntity.deadline)
        detailContentBinding.btnStart.setOnClickListener {
            val intent = Intent(this@DetailCourseActivity, CourseReaderActivity::class.java)
            intent.putExtra(CourseReaderActivity.EXTRA_COURSE_ID, courseEntity.courseId)
            startActivity(intent)
        }
    }
}