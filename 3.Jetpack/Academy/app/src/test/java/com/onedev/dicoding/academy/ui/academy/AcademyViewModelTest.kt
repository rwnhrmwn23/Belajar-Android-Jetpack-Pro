package com.onedev.dicoding.academy.ui.academy

import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class AcademyViewModelTest {

    private lateinit var viewModel: AcademyViewModel

    @Before
    fun setup() {
        viewModel = AcademyViewModel()
    }

    @Test
    fun getCourse() {
        val courseEntities = viewModel.getCourse()
        assertNotNull(courseEntities) // Memastikan data course tidak null.
        assertEquals(5, courseEntities.size) // Memastikan jumlah data course sesuai dengan yang diharapkan.
    }

}