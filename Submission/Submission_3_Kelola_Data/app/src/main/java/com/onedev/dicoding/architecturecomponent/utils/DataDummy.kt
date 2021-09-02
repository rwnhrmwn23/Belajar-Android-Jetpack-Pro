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
                91363,
                "What If...?",
                "/lztz5XBMG1x6Y5ubz7CxfPFsAcW.jpg",
                8.5,
                "Action",
                "Taking inspiration from the comic books of the same name, each episode explores a pivotal moment from the Marvel Cinematic Universe and turns it on its head, leading the audience into uncharted territory.",
                3180.772,
                "Returning Series",
                 "One question changes everything."
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
                id = 91363,
                name = "What If...?",
                genres = listOf("Action", "Drama"),
                original_language = "en",
                original_name = "What If...?",
                overview = "Taking inspiration from the comic books of the same name, each episode explores a pivotal moment from the Marvel Cinematic Universe and turns it on its head, leading the audience into uncharted territory.",
                popularity = 3180.772,
                poster_path = "/lztz5XBMG1x6Y5ubz7CxfPFsAcW.jpg",
                status = "Returning Series",
                tagline = "tagline",
                vote_average = 8.5,
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
            id = 91363,
            name = "What If...?",
            overview = "Taking inspiration from the comic books of the same name, each episode explores a pivotal moment from the Marvel Cinematic Universe and turns it on its head, leading the audience into uncharted territory.",
            popularity = 3180.772,
            poster_path = "/lztz5XBMG1x6Y5ubz7CxfPFsAcW.jpg",
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
            tagline =  "One question changes everything.",
            vote_average = 8.5,
        )
    }
}