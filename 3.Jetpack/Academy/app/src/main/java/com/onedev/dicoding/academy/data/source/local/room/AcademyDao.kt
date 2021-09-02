package com.onedev.dicoding.academy.data.source.local.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.onedev.dicoding.academy.data.source.local.entity.CourseEntity
import com.onedev.dicoding.academy.data.source.local.entity.ModuleEntity
import com.onedev.dicoding.academy.data.source.local.entity.CourseWithModule

@Dao
interface AcademyDao {

    @Query("SELECT * FROM courseEntities")
    fun getCourse(): LiveData<List<CourseEntity>>

    @Query("SELECT * FROM courseEntities where bokmarked = 1")
    fun getBookmarkedCourse(): LiveData<List<CourseEntity>>

    @Transaction
    @Query("SELECT * FROM courseEntities WHERE courseId = :courseId")
    fun getCourseWithModuleById(courseId: String): LiveData<CourseWithModule>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCourses(courses: List<CourseEntity>)

    @Update
    fun updateCourse(courses: CourseEntity)

    @Query("SELECT * FROM moduleEntities WHERE courseId = :courseId")
    fun getModulesByCourseI(courseId: String): LiveData<List<ModuleEntity>>

    @Query("SELECT * FROM moduleEntities WHERE moduleId = :moduleId")
    fun getModuleById(moduleId: String): LiveData<ModuleEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertModules(module: List<ModuleEntity>)

    @Update
    fun updateModule(module: ModuleEntity)

    @Query("UPDATE moduleEntities SET content = :content WHERE moduleId = :moduleId")
    fun updateModuleByContent(content: String, moduleId: String)

}