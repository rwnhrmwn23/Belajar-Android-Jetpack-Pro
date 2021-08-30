package com.onedev.dicoding.academy.data.source

import androidx.lifecycle.LiveData
import com.onedev.dicoding.academy.data.CourseEntity
import com.onedev.dicoding.academy.data.ModuleEntity
import com.onedev.dicoding.academy.data.source.remote.response.CourseResponse

interface AcademyDataSource {

    fun getAllCourses(): LiveData<List<CourseEntity>>

    fun getBookmarkedCourses(): LiveData<List<CourseEntity>>

    fun getCourseWithModules(courseId: String): LiveData<CourseEntity>

    fun getAllModulesByCourse(courseId: String): LiveData<List<ModuleEntity>>

    fun getContent(courseId: String, moduleId: String): LiveData<ModuleEntity>

}