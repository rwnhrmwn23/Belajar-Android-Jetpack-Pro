package com.onedev.dicoding.academy.ui.academy.data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.onedev.dicoding.academy.data.source.remote.RemoteDataSource
import com.onedev.dicoding.academy.utils.DataDummy
import com.onedev.dicoding.academy.utils.LiveDataTestUtil
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.eq
import com.nhaarman.mockitokotlin2.doAnswer
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.mock

class AcademyRepositoryTest {
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = mock(RemoteDataSource::class.java)
    private val academyRepository = FakeAcademyRepository(remote)

    private val courseResponse = DataDummy.generateRemoteDummyCourses()
    private val courseId = courseResponse[0].id
    private val moduleResponse = DataDummy.generateRemoteDummyModules(courseId)
    private val moduleId = moduleResponse[0].moduleId
    private val content = DataDummy.generateRemoteDummyContent(moduleId)

    @Test
    fun getAllCourse() {
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.LoadCourseCallback)
                .onAllCoursesReceived(courseResponse)
            null
        }.`when`(remote).getAllCourses(any())
        val courseEntities = LiveDataTestUtil.getValue(academyRepository.getAllCourses())
        verify(remote).getAllCourses(any())
        assertNotNull(courseEntities)
        assertEquals(courseResponse.size.toLong(), courseEntities.size.toLong())
    }


    @Test
    fun getAllModulesByCourse() {
        doAnswer { invocation ->
            (invocation.arguments[1] as RemoteDataSource.LoadModulesCallback)
                .onAllModulesReceived(moduleResponse)
            null
        }.`when`(remote).getModules(eq(courseId), any())

        val courseEntities =
            LiveDataTestUtil.getValue(academyRepository.getAllModulesByCourse(courseId))
        verify(remote).getModules(eq(courseId), any())

        assertNotNull(courseEntities)
        assertEquals(moduleResponse.size.toLong(), courseEntities.size.toLong())
    }

    @Test
    fun getBookmarkedCourses() {
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.LoadCourseCallback)
                .onAllCoursesReceived(courseResponse)
            null
        }.`when`(remote).getAllCourses(any())

        val courseEntities = LiveDataTestUtil.getValue(academyRepository.getBookmarkedCourses())

        verify(remote).getAllCourses(any())

        assertNotNull(courseEntities)
        assertEquals(courseResponse.size.toLong(), courseEntities.size.toLong())
    }

    @Test
    fun getContent() {
        doAnswer { invocation ->
            (invocation.arguments[1] as RemoteDataSource.LoadModulesCallback)
                .onAllModulesReceived(moduleResponse)
            null
        }.`when`(remote).getModules(eq(courseId), any())
        doAnswer { invocation ->
            (invocation.arguments[1] as RemoteDataSource.LoadContentCallback)
                .onContentReceived(content)
            null
        }.`when`(remote).getContent(eq(moduleId), any())

        val courseEntitiesContent =
            LiveDataTestUtil.getValue(academyRepository.getContent(courseId, moduleId))

        verify(remote).getModules(eq(courseId), any())

        verify(remote).getContent(eq(moduleId), any())

        assertNotNull(courseEntitiesContent)
        assertNotNull(courseEntitiesContent.contentEntity)
        assertNotNull(courseEntitiesContent.contentEntity?.content)
        assertEquals(content.content, courseEntitiesContent.contentEntity?.content)
    }

    @Test
    fun getCourseWithModules() {
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.LoadCourseCallback)
                .onAllCoursesReceived(courseResponse)
            null
        }.`when`(remote).getAllCourses(any())

        val courseEntities =
            LiveDataTestUtil.getValue(academyRepository.getCourseWithModules(courseId))

        verify(remote).getAllCourses(any())

        assertNotNull(courseEntities)
        assertNotNull(courseEntities.title)
        assertEquals(courseResponse[0].title, courseEntities.title)
    }
}