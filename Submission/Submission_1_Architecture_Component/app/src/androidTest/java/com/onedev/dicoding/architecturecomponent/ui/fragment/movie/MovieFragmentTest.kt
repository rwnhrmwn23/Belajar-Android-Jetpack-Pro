package com.onedev.dicoding.architecturecomponent.ui.fragment.movie

import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import com.onedev.dicoding.architecturecomponent.R
import com.onedev.dicoding.architecturecomponent.utils.DataDummy
import com.onedev.dicoding.architecturecomponent.ui.activity.main.MainActivity
import org.junit.Before
import org.junit.Test

class MovieFragmentTest {

    private val movies = DataDummy.generateDataDummyMovies()
    private val tvShows = DataDummy.generateDataDummyTvShows()

    @Before
    fun setup() {
        ActivityScenario.launch(MainActivity::class.java)
    }

    @Test
    fun loadMovies() {
        onView(withId(R.id.rv_movie)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movie)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                movies.size
            )
        )
    }

    @Test
    fun loadDetailMovie() {
        onView(withId(R.id.rv_movie)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )
        onView(withId(R.id.tv_title)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_title)).check(matches(withText(movies[0].title)))
        onView(withId(R.id.tv_genre)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_genre)).check(matches(withText(movies[0].genre)))
        onView(withId(R.id.tv_option_information)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_option_information)).check(matches(withText(movies[0].release_date)))
        onView(withId(R.id.tv_duration)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_duration)).check(matches(withText(movies[0].duration)))
        onView(withId(R.id.tv_overview)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_overview)).check(matches(withText(movies[0].overview)))
    }

    @Test
    fun loadTvShows() {
        onView(withText("TV Show")).perform(click())
        onView(withId(R.id.rv_tv_show)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_tv_show)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                tvShows.size
            )
        )
    }

    @Test
    fun loadDetailTvShow() {
        onView(withText("TV Show")).perform(click())
        onView(withId(R.id.rv_tv_show)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )
        onView(withId(R.id.tv_title)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_title)).check(matches(withText(tvShows[0].title)))
        onView(withId(R.id.tv_genre)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_genre)).check(matches(withText(tvShows[0].genre)))
        onView(withId(R.id.tv_option_information)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_option_information)).check(matches(withText(tvShows[0].tagline)))
        onView(withId(R.id.tv_duration)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_duration)).check(matches(withText(tvShows[0].duration)))
        onView(withId(R.id.tv_overview)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_overview)).check(matches(withText(tvShows[0].overview)))
    }

}