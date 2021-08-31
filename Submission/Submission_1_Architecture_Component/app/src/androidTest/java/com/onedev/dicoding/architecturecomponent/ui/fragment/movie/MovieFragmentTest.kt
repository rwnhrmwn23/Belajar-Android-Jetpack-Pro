package com.onedev.dicoding.architecturecomponent.ui.fragment.movie

import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import com.onedev.dicoding.architecturecomponent.BuildConfig
import com.onedev.dicoding.architecturecomponent.R
import com.onedev.dicoding.architecturecomponent.data.source.remote.response.MovieDetailResponse
import com.onedev.dicoding.architecturecomponent.data.source.remote.response.MovieResponseResult
import com.onedev.dicoding.architecturecomponent.ui.activity.main.MainActivity
import com.onedev.dicoding.architecturecomponent.utils.FakeJsonHelper
import org.junit.Before
import org.junit.Test

class MovieFragmentTest {

    private lateinit var jsonHelper: FakeJsonHelper
    private val apiKey = BuildConfig.API_KEY

    @Before
    fun setup() {
        ActivityScenario.launch(MainActivity::class.java)
        jsonHelper = FakeJsonHelper()
    }

    @Test
    fun loadMovies() {
        jsonHelper.getPopularMovie(apiKey, 1, object : FakeJsonHelper.GetPopularMovieCallback {
            override fun getPopularMovieCallback(listMovieResponseResult: List<MovieResponseResult>) {
                onView(withId(R.id.rv_movie)).check(matches(isDisplayed()))
                onView(withId(R.id.rv_movie)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(listMovieResponseResult.size))
            }
        })
    }

    @Test
    fun loadDetailMovie() {
        val movieId = MutableLiveData<Int>()
        jsonHelper.getPopularMovie(apiKey, 1, object : FakeJsonHelper.GetPopularMovieCallback {
            override fun getPopularMovieCallback(listMovieResponseResult: List<MovieResponseResult>) {
                movieId.value = listMovieResponseResult[0].id
            }
        })

        delayTwoSecond()

        val movieDetail = MutableLiveData<MovieDetailResponse>()
        movieId.value?.let {
            jsonHelper.getDetailMovie(it, apiKey, object : FakeJsonHelper.GetDetailMovieCallback {
                override fun getDetailMovieCallback(movieDetailResponse: MovieDetailResponse) {
                    movieDetail.value = movieDetailResponse
                }
            })
        }

        delayTwoSecond()

        onView(withId(R.id.rv_movie)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.tv_title)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_title)).check(matches(withText(movieDetail.value?.title)))

        onView(withId(R.id.tv_genre)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_genre)).check(matches(withText(movieDetail.value?.genres?.get(0)?.name)))

        onView(withId(R.id.tv_option_information)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_option_information)).check(matches(withText(movieDetail.value?.release_date)))

        onView(withId(R.id.tv_duration)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_duration)).check(matches(withText(movieDetail.value?.runtime.toString())))

        onView(withId(R.id.tv_overview)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_overview)).check(matches(withText(movieDetail.value?.overview)))
    }
//
//    @Test
//    fun loadTvShows() {
//        onView(withText("TV Show")).perform(click())
//        onView(withId(R.id.rv_tv_show)).check(matches(isDisplayed()))
//        onView(withId(R.id.rv_tv_show)).perform(
//            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
//                tvShows.size
//            )
//        )
//    }
//
//    @Test
//    fun loadDetailTvShow() {
//        onView(withText("TV Show")).perform(click())
//        onView(withId(R.id.rv_tv_show)).perform(
//            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
//                0,
//                click()
//            )
//        )
//        onView(withId(R.id.tv_title)).check(matches(isDisplayed()))
//        onView(withId(R.id.tv_title)).check(matches(withText(tvShows[0].title)))
//        onView(withId(R.id.tv_genre)).check(matches(isDisplayed()))
//        onView(withId(R.id.tv_genre)).check(matches(withText(tvShows[0].genre)))
//        onView(withId(R.id.tv_option_information)).check(matches(isDisplayed()))
//        onView(withId(R.id.tv_option_information)).check(matches(withText(tvShows[0].tagline)))
//        onView(withId(R.id.tv_duration)).check(matches(isDisplayed()))
//        onView(withId(R.id.tv_duration)).check(matches(withText(tvShows[0].duration)))
//        onView(withId(R.id.tv_overview)).check(matches(isDisplayed()))
//        onView(withId(R.id.tv_overview)).check(matches(withText(tvShows[0].overview)))
//    }

    private fun delayTwoSecond() {
        try {
            Thread.sleep(2000)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }
    }

}