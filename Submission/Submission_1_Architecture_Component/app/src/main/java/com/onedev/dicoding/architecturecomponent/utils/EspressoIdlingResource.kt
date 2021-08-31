package com.onedev.dicoding.architecturecomponent.utils

import androidx.test.espresso.IdlingResource
import androidx.test.espresso.idling.CountingIdlingResource


object EspressoIdlingResource {

    private const val RESOURCE = "Global"
    private val espressoIdlingResource = CountingIdlingResource(RESOURCE)

    fun increment() = espressoIdlingResource.increment()
    fun decrement() = espressoIdlingResource.decrement()
    fun getEspressoIdlingResource(): IdlingResource = espressoIdlingResource


}