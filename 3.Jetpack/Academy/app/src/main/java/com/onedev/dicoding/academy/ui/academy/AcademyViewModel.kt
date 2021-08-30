package com.onedev.dicoding.academy.ui.academy

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.onedev.dicoding.academy.data.CourseEntity
import com.onedev.dicoding.academy.data.source.AcademyRepository
import com.onedev.dicoding.academy.utils.DataDummy

class AcademyViewModel(private val academyRepository: AcademyRepository): ViewModel() {

    fun getCourse(): LiveData<List<CourseEntity>> = academyRepository.getAllCourses()

}