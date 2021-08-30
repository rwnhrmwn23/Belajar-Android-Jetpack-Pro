package com.onedev.dicoding.academy.ui.course

import androidx.lifecycle.ViewModel
import com.onedev.dicoding.academy.data.ContentEntity
import com.onedev.dicoding.academy.data.ModuleEntity
import com.onedev.dicoding.academy.data.source.AcademyRepository
import com.onedev.dicoding.academy.ui.academy.AcademyViewModel
import com.onedev.dicoding.academy.utils.DataDummy

class CourseReaderViewModel(private val academyRepository: AcademyRepository): ViewModel() {

    private lateinit var courseId: String
    private lateinit var moduleId: String

    fun setSelectedCourse(courseId: String) {
        this.courseId = courseId
    }

    fun setSelectedModule(moduleId: String) {
        this.moduleId = moduleId
    }

    fun getModules(): ArrayList<ModuleEntity> = academyRepository.getAllModulesByCourse(courseId)

    fun getSelectedModule(): ModuleEntity = academyRepository.getContent(courseId, moduleId)

}