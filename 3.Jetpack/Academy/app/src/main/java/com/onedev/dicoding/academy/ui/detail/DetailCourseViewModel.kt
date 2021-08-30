package com.onedev.dicoding.academy.ui.detail

import androidx.lifecycle.ViewModel
import com.onedev.dicoding.academy.data.CourseEntity
import com.onedev.dicoding.academy.data.ModuleEntity
import com.onedev.dicoding.academy.data.source.AcademyRepository
import com.onedev.dicoding.academy.utils.DataDummy

class DetailCourseViewModel(private val academyRepository: AcademyRepository) : ViewModel() {

    private lateinit var courseId: String

    fun setSelectedCourse(courseId: String) {
        this.courseId = courseId
    }

    fun getCourse(): CourseEntity = academyRepository.getCourseWithModules(courseId)

    fun getModules(): List<ModuleEntity> = academyRepository.getAllModulesByCourse(courseId)

}