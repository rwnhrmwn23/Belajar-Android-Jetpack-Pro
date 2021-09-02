package com.onedev.dicoding.academy.ui.academy

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.onedev.dicoding.academy.data.source.local.entity.CourseEntity
import com.onedev.dicoding.academy.data.source.AcademyRepository
import com.onedev.dicoding.academy.vo.Resource

class AcademyViewModel(private val academyRepository: AcademyRepository): ViewModel() {

    fun getCourse(): LiveData<Resource<List<CourseEntity>>> = academyRepository.getAllCourses()

}