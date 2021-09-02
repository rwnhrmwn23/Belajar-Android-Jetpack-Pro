package com.onedev.dicoding.architecturecomponent.utils

import com.onedev.dicoding.architecturecomponent.data.source.local.entity.MovieEntity
import com.onedev.dicoding.architecturecomponent.data.source.local.entity.TvShowEntity
import com.onedev.dicoding.architecturecomponent.data.source.remote.response.*

object DataDummy {
    fun getMovies(): List<MovieEntity> {
        return listOf(
            MovieEntity(
                436969,
                "The Suicide Squad",
                "/gL8myjGc2qrmqVosyGm5CWTir9A.jpg",
                8.0,
                "Action",
                "Supervillains Harley Quinn, Bloodsport, Peacemaker and a collection of nutty cons at Belle Reve prison join the super-secret, super-shady Task Force X as they are dropped off at the remote, enemy-infused island of Corto Maltese.",
                3692.281,
                "2021-07-28",
                132,
                "Released",
                "They're dying to save the world.",
            )
        )
    }

    fun getTvShows(): List<TvShowEntity> {
        return listOf(
            TvShowEntity(
                77169,
                "Cobra Kai",
                "/obLBdhLxheKg8Li1qO11r2SwmYO.jpg",
                8.1,
                "Action",
                "This Karate Kid sequel series picks up 30 years after the events of the 1984 All Valley Karate Tournament and finds Johnny Lawrence on the hunt for redemption by reopening the infamous Cobra Kai karate dojo. This reignites his old rivalry with the successful Daniel LaRusso, who has been working to maintain the balance in his life without mentor Mr. Miyagi.",
                1132.227,
                "Release",
                "Cobra Kai never dies."
            )
        )
    }
    // Remote Data
    fun getRemoteMovies(): List<MovieResponseResult> {
        return listOf(
            MovieResponseResult(
                backdrop_path = "/srYya1ZlI97Au4jUYAktDe3avyA.jpg",
                id = 436969,
                genres = listOf(
                    DetailGenre(
                        id = 14,
                        name = "Fantasy"
                    ),
                    DetailGenre(
                        id = 28,
                        name = "Action"
                    ),
                    DetailGenre(
                        id = 12,
                        name = "Adventure"
                    )
                ),
                original_title = "The Suicide Squad",
                overview = "Supervillains Harley Quinn, Bloodsport, Peacemaker and a collection of nutty cons at Belle Reve prison join the super-secret, super-shady Task Force X as they are dropped off at the remote, enemy-infused island of Corto Maltese.",
                popularity = 3692.281,
                poster_path = "/gL8myjGc2qrmqVosyGm5CWTir9A.jpg",
                release_date = "2020-12-16",
                title = "The Suicide Squad",
                runtime = 132,
                status = "Released",
                tagline = "They're dying to save the world.",
                vote_average = 8.0,
                vote_count = 2641
            )
        )
    }

    fun getRemoteDetailMovie(): MovieDetailResponse {
        return MovieDetailResponse(
            genres = listOf(
                DetailGenre(
                    id = 14,
                    name = "Fantasy"
                ),
                DetailGenre(
                    id = 28,
                    name = "Action"
                ),
                DetailGenre(
                    id = 12,
                    name = "Adventure"
                )
            ),
            id = 436969,
            overview = "Supervillains Harley Quinn, Bloodsport, Peacemaker and a collection of nutty cons at Belle Reve prison join the super-secret, super-shady Task Force X as they are dropped off at the remote, enemy-infused island of Corto Maltese.",
            popularity = 3692.281,
            poster_path = "/gL8myjGc2qrmqVosyGm5CWTir9A.jpg",
            production_companies = listOf(
                DetailProductionCompany(
                    id = 128064,
                    logo_path = "/13F3Jf7EFAcREU0xzZqJnVnyGXu.png",
                    name = "DC Films",
                    origin_country = "US"
                ),
                DetailProductionCompany(
                    id = 507,
                    logo_path = "/z7H707qUWigbjHnJDMfj6QITEpb.png",
                    name = "Atlas Entertainment",
                    origin_country = "US"
                ),
                DetailProductionCompany(
                    id = 429,
                    logo_path = "/2Tc1P3Ac8M479naPp1kYT3izLS5.png",
                    name = "DC Comics",
                    origin_country = "US"
                )
            ),
            release_date = "2020-12-16",
            title = "The Suicide Squad",
            runtime = 132,
            status = "Released",
            tagline = "They're dying to save the world.",
            vote_average = 8.0,
        )
    }

    fun getRemoteTvShows(): List<TvShowResponseResult> {
        return listOf(
            TvShowResponseResult(
                backdrop_path = "/gL8myjGc2qrmqVosyGm5CWTir9A.jpg",
                first_air_date = "2018-05-02",
                id = 77169,
                name = "Cobra Kai",
                genres = listOf("Action", "Drama"),
                original_language = "en",
                original_name = "Cobra Kai",
                overview = "This Karate Kid sequel series picks up 30 years after the events of the 1984 All Valley Karate Tournament and finds Johnny Lawrence on the hunt for redemption by reopening the infamous Cobra Kai karate dojo. This reignites his old rivalry with the successful Daniel LaRusso, who has been working to maintain the balance in his life without mentor Mr. Miyagi.",
                popularity = 1132.227,
                poster_path = "/obLBdhLxheKg8Li1qO11r2SwmYO.jpg",
                status = "Release",
                tagline = "tagline",
                vote_average = 8.1,
                vote_count = 1717
            )
        )
    }

    fun getRemoteDetailTvShow(): TvShowDetailResponse {
        return TvShowDetailResponse(
            genres = listOf(
                DetailGenre(
                    id = 10759,
                    name = "Action & Adventure"
                ),
                DetailGenre(
                    id = 18,
                    name = "Drama"
                )
            ),
            id = 77169,
            name = "Cobra Kai",
            overview = "This Karate Kid sequel series picks up 30 years after the events of the 1984 All Valley Karate Tournament and finds Johnny Lawrence on the hunt for redemption by reopening the infamous Cobra Kai karate dojo. This reignites his old rivalry with the successful Daniel LaRusso, who has been working to maintain the balance in his life without mentor Mr. Miyagi.",
            popularity = 1132.227,
            poster_path = "/obLBdhLxheKg8Li1qO11r2SwmYO.jpg",
            production_companies = listOf(
                DetailProductionCompany(
                    id = 11073,
                    logo_path = "/wHs44fktdoj6c378ZbSWfzKsM2Z.png",
                    name = "Sony Pictures Television",
                    origin_country = "US"
                ),
                DetailProductionCompany(
                    id = 907,
                    logo_path = "/ca5SWI5uvU985f8Kbb4xc8AmVWH.png",
                    name = "Overbrook Entertainment",
                    origin_country = "US"
                ),
            ),
            status = "Returning Series",
            tagline = "Cobra Kai never dies.",
            vote_average = 8.1,
        )
    }
}