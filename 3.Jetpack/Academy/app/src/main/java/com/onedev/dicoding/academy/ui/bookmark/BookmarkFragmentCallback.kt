package com.onedev.dicoding.academy.ui.bookmark

import com.onedev.dicoding.academy.data.CourseEntity

interface BookmarkFragmentCallback {
    fun onShareClick(course: CourseEntity)
}
