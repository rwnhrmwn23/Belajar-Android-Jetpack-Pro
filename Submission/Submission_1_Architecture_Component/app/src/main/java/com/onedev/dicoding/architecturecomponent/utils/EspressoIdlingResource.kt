package com.onedev.dicoding.architecturecomponent.utils

import androidx.test.espresso.idling.CountingIdlingResource


object EspressoIdlingResource {

    private const val RESOURCE = "Global"
    val idlingResource = CountingIdlingResource(RESOURCE)

    fun increment() {
        idlingResource.increment()
    }

    fun decrement() {
        idlingResource.decrement()
    }

}