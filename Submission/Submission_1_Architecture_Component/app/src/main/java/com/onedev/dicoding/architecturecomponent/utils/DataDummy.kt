package com.onedev.dicoding.architecturecomponent.utils

import com.onedev.dicoding.architecturecomponent.data.source.local.MovieDetailEntity
import com.onedev.dicoding.architecturecomponent.data.source.local.MovieEntity
import com.onedev.dicoding.architecturecomponent.data.source.local.TvShowDetailEntity
import com.onedev.dicoding.architecturecomponent.data.source.local.TvShowEntity

object DataDummy {
    fun getMovies(): List<MovieEntity> {
        return listOf(
            MovieEntity(
                464052,
                "Wonder Woman 1984",
                "/8UlWHLMpgZm9bx6QYh0NFoq67TZ.jpg",
                7.2
            ),
            MovieEntity(
                508442,
                "Soul",
                "/hm58Jw4Lw8OIeECIq5qyPYhAeRJ.jpg",
                8.4
            ),
            MovieEntity(
                517096,
                "Cosmoball",
                "/eDJYDXRoWoUzxjd52gtz5ODTSU1.jpg",
                5.3
            )
        )
    }

    fun getDetailMovie(): MovieDetailEntity {
        return MovieDetailEntity(
            listOf("Action", "Adventure", "Drama", "Fantasy"),
            531242,
            "Supervillains Harley Quinn, Bloodsport, Peacemaker and a collection of nutty cons at Belle Reve prison join the super-secret, super-shady Task Force X as they are dropped off at the remote, enemy-infused island of Corto Maltese.",
            3692.281,
            "/gL8myjGc2qrmqVosyGm5CWTir9A.jpg",
            listOf(
                "DC Entertainment",
                "DC Films",
                "Atlas Entertainment",
                "DC Comics",
                "The Safran Company",
                "Warner Bros. Pictures"
            ),
            "2021-07-28",
            132,
            "Released",
            "They're dying to save the world.",
            "The Suicide Squad",
            8.0
        )
    }

    fun getTvShows(): List<TvShowEntity> {
        return listOf(
            TvShowEntity(
                77169,
                "Cobra Kai",
                "/obLBdhLxheKg8Li1qO11r2SwmYO.jpg",
                8.1
            ),
            TvShowEntity(
                44217,
                "Vikings",
                "/bQLrHIRNEkE3PdIWQrZHynQZazu.jpg",
                8.0
            ),
            TvShowEntity(
                82856,
                "The Mandalorian",
                "/sWgBv7LV2PRoQgkxwlibdGXKz1S.jpg",
                8.5
            )
        )
    }

    fun getDetailTvShow(): TvShowDetailEntity {
        return TvShowDetailEntity(
            listOf("Action", "Adventure", "Drama", "Fantasy"),
            531242,
            "The Suicide Squad",
            "Supervillains Harley Quinn, Bloodsport, Peacemaker and a collection of nutty cons at Belle Reve prison join the super-secret, super-shady Task Force X as they are dropped off at the remote, enemy-infused island of Corto Maltese.",
            3692.281,
            "/gL8myjGc2qrmqVosyGm5CWTir9A.jpg",
            listOf(
                "DC Entertainment",
                "DC Films",
                "Atlas Entertainment",
                "DC Comics",
                "The Safran Company",
                "Warner Bros. Pictures"
            ),
            "2021-07-28",
            "They're dying to save the world.",
            8.0
        )
    }
}