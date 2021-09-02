package com.onedev.dicoding.academy.ui.bookmark

import com.onedev.dicoding.academy.data.source.local.entity.CourseEntity

interface BookmarkFragmentCallback {
    fun onShareClick(course: CourseEntity)
}
