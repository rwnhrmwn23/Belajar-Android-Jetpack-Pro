package com.onedev.dicoding.academy.ui.bookmark

import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class BookmarkViewModelTest {

    private lateinit var viewModel: BookmarkViewModel

    @Before
    fun setup() {
        viewModel = BookmarkViewModel()
    }

    @Test
    fun getBookmarks() {
        val bookmarkEntities = viewModel.getBookmarks()
        assertNotNull(bookmarkEntities) // Memastikan data bookmark tidak null.
        assertEquals(5, bookmarkEntities.size) //// Memastikan jumlah data course sesuai dengan yang diharapkan.
    }

}