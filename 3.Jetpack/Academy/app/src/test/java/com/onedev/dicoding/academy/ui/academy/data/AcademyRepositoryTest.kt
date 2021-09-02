package com.onedev.dicoding.academy.ui.academy.data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import com.nhaarman.mockitokotlin2.verify
import com.onedev.dicoding.academy.data.source.local.LocalDataSource
import com.onedev.dicoding.academy.data.source.local.entity.CourseEntity
import com.onedev.dicoding.academy.data.source.local.entity.CourseWithModule
import com.onedev.dicoding.academy.data.source.local.entity.ModuleEntity
import com.onedev.dicoding.academy.data.source.remote.RemoteDataSource
import com.onedev.dicoding.academy.utils.AppExecutors
import com.onedev.dicoding.academy.utils.DataDummy
import com.onedev.dicoding.academy.utils.LiveDataTestUtil
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock

class AcademyRepositoryTest {
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = mock(RemoteDataSource::class.java)
    private val local = mock(LocalDataSource::class.java)
    private val appExecutors = mock(AppExecutors::class.java)

    private val academyRepository = FakeAcademyRepository(remote, local, appExecutors)

    private val courseResponse = DataDummy.generateRemoteDummyCourses()
    private val courseId = courseResponse[0].id
    private val moduleResponse = DataDummy.generateRemoteDummyModules(courseId)
    private val moduleId = moduleResponse[0].moduleId
    private val content = DataDummy.generateRemoteDummyContent(moduleId)

    @Test
    fun getAllCourse() {
        val dummyCourses = MutableLiveData<List<CourseEntity>>()
        dummyCourses.value = DataDummy.generateDummyCourse()
        `when`(local.getAllCourses()).thenReturn(dummyCourses)

        val courseEntities = LiveDataTestUtil.getValue(academyRepository.getAllCourses())
        verify(local).getAllCourses()

        assertNotNull(courseEntities)
        assertEquals(courseResponse.size.toLong(), courseEntities.data?.size?.toLong())
    }


    @Test
    fun getAllModulesByCourse() {
        val dummyModules = MutableLiveData<List<ModuleEntity>>()
        dummyModules.value = DataDummy.generateDummyModules(courseId)
        `when`(local.getAllModulesByCourse(courseId)).thenReturn(dummyModules)

        val courseEntities =
            LiveDataTestUtil.getValue(academyRepository.getAllModulesByCourse(courseId))
        verify(local).getAllModulesByCourse(courseId)
        assertNotNull(courseEntities.data)
        assertEquals(moduleResponse.size.toLong(), courseEntities.data?.size?.toLong())
    }

    @Test
    fun getBookmarkedCourses() {
        val dummyCourses = MutableLiveData<List<CourseEntity>>()
        dummyCourses.value = DataDummy.generateDummyCourse()
        `when`(local.getBookmarkedCourses()).thenReturn(dummyCourses)

        val courseEntities = LiveDataTestUtil.getValue(academyRepository.getBookmarkedCourses())
        verify(local).getBookmarkedCourses()
        assertNotNull(courseEntities)
        assertEquals(courseResponse.size.toLong(), courseEntities.size.toLong())
    }

    @Test
    fun getContent() {
        val dummyEntity = MutableLiveData<ModuleEntity>()
        dummyEntity.value = DataDummy.generateDummyModuleWithContent(moduleId)
        `when`(local.getModuleWithContent(courseId)).thenReturn(dummyEntity)

        val courseEntitiesContent =
            LiveDataTestUtil.getValue(academyRepository.getContent(courseId))
        verify(local).getModuleWithContent(courseId)
        assertNotNull(courseEntitiesContent)
        assertNotNull(courseEntitiesContent.data?.contentEntity)
        assertNotNull(courseEntitiesContent.data?.contentEntity?.content)
        assertEquals(content.content, courseEntitiesContent.data?.contentEntity?.content)
    }


    @Test
    fun getCourseWithModules() {
        val dummyEntity = MutableLiveData<CourseWithModule>()
        dummyEntity.value =
            DataDummy.generateDummyCourseWithModules(DataDummy.generateDummyCourse()[0], false)
        `when`(local.getCourseWithModules(courseId)).thenReturn(dummyEntity)

        val courseEntities =
            LiveDataTestUtil.getValue(academyRepository.getCourseWithModules(courseId))
        verify(local).getCourseWithModules(courseId)
        assertNotNull(courseEntities.data)
        assertNotNull(courseEntities.data?.mCourse?.title)
        assertEquals(courseResponse[0].title, courseEntities.data?.mCourse?.title)
    }
}