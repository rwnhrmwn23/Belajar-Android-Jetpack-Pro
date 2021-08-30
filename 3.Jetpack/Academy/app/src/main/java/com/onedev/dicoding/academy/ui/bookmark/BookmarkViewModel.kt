package com.onedev.dicoding.academy.ui.bookmark

import androidx.lifecycle.ViewModel
import com.onedev.dicoding.academy.data.CourseEntity
import com.onedev.dicoding.academy.data.source.AcademyRepository
import com.onedev.dicoding.academy.utils.DataDummy

class BookmarkViewModel(private val academyRepository: AcademyRepository): ViewModel() {

    fun getBookmarks(): List<CourseEntity> = academyRepository.getBookmarkedCourses()

}