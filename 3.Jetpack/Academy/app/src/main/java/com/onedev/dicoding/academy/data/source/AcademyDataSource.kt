package com.onedev.dicoding.academy.data.source

import com.onedev.dicoding.academy.data.CourseEntity
import com.onedev.dicoding.academy.data.ModuleEntity
import com.onedev.dicoding.academy.data.source.remote.response.CourseResponse

interface AcademyDataSource {

    fun getAllCourses(): List<CourseEntity>

    fun getBookmarkedCourses(): List<CourseEntity>

    fun getCourseWithModules(courseId: String): CourseEntity

    fun getAllModulesByCourse(courseId: String): List<ModuleEntity>

    fun getContent(courseId: String, moduleId: String): ModuleEntity

}