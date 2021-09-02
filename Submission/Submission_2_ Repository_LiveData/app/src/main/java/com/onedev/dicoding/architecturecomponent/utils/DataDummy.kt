package com.onedev.dicoding.architecturecomponent.utils

import com.onedev.dicoding.architecturecomponent.data.source.local.entity.MovieEntity
import com.onedev.dicoding.architecturecomponent.data.source.local.entity.TvShowEntity
import com.onedev.dicoding.architecturecomponent.data.source.remote.response.*

object DataDummy {
    fun getMovies(): List<MovieEntity> {
        return listOf(
            MovieEntity(
                531242,
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
            ),
            MovieEntity(
                531242,
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
            ),
            MovieEntity(
                531242,
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
                531242,
                "What If...?",
                "/lztz5XBMG1x6Y5ubz7CxfPFsAcW.jpg",
                8.6,
                "Animation",
                "Taking inspiration from the comic books of the same name, each episode explores a pivotal moment from the Marvel Cinematic Universe and turns it on its head, leading the audience into uncharted territory.",
                1622.843,
                "Returning Series",
                "One question changes everything."
            ),
            TvShowEntity(
                531242,
                "What If...?",
                "/lztz5XBMG1x6Y5ubz7CxfPFsAcW.jpg",
                8.6,
                "Animation",
                "Taking inspiration from the comic books of the same name, each episode explores a pivotal moment from the Marvel Cinematic Universe and turns it on its head, leading the audience into uncharted territory.",
                1622.843,
                "Returning Series",
                "One question changes everything."
            ),
            TvShowEntity(
                531242,
                "What If...?",
                "/lztz5XBMG1x6Y5ubz7CxfPFsAcW.jpg",
                8.6,
                "Animation",
                "Taking inspiration from the comic books of the same name, each episode explores a pivotal moment from the Marvel Cinematic Universe and turns it on its head, leading the audience into uncharted territory.",
                1622.843,
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
                id = 464052,
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
                original_title = "Wonder Woman 1984",
                overview = "Wonder Woman comes into conflict with the Soviet Union during the Cold War in the 1980s and finds a formidable foe by the name of the Cheetah.",
                popularity = 3342.686,
                poster_path = "/8UlWHLMpgZm9bx6QYh0NFoq67TZ.jpg",
                release_date = "2020-12-16",
                title = "Wonder Woman 1984",
                runtime = 123,
                status = "Release",
                tagline = "Wonder Woman Wanita Kuat",
                vote_average = 343.4,
                vote_count = 2641
            ),
            MovieResponseResult(
                backdrop_path = "/kf456ZqeC45XTvo6W9pW5clYKfQ.jpg",
                id = 508442,
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
                original_title = "Soul",
                overview = "Joe Gardner is a middle school teacher with a love for jazz music. After a successful gig at the Half Note Club, he suddenly gets into an accident that separates his soul from his body and is transported to the You Seminar, a center in which souls develop and gain passions before being transported to a newborn child. Joe must enlist help from the other souls-in-training, like 22, a soul who has spent eons in the You Seminar, in order to get back to Earth.",
                popularity = 2849.972,
                poster_path = "/hm58Jw4Lw8OIeECIq5qyPYhAeRJ.jpg",
                release_date = "2020-12-25",
                title = "Soul",
                runtime = 123,
                status = "Release",
                tagline = "Wonder Woman Wanita Kuat",
                vote_average = 76.4,
                vote_count = 3477
            ),
            MovieResponseResult(
                backdrop_path = "/ibwOX4xUndc6E90MYfglghWvO5Z.jpg",
                id = 517096,
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
                original_title = "Вратарь Галактики",
                overview = "Cosmoball is a mesmerizing intergalactic game of future played between humans and aliens at the giant extraterrestrial ship hovering in the sky over Earth. A young man with enormous power of an unknown nature joins the team of hot-headed superheroes in exchange for a cure for his mother’s deadly illness. The Four from Earth will fight not only to defend the honor of their home planet in the spectacular game, but to face the unprecedented threat to the Galaxy and embrace their own destiny.",
                popularity = 1893.591,
                poster_path = "/eDJYDXRoWoUzxjd52gtz5ODTSU1.jpg",
                release_date = "2020-08-27",
                title = "Cosmoball",
                runtime = 123,
                status = "Release",
                tagline = "Wonder Woman Wanita Kuat",
                vote_average = 432.4,
                vote_count = 59
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
            id = 34312,
            overview = "Wonder Woman comes into conflict with the Soviet Union during the Cold War in the 1980s and finds a formidable foe by the name of the Cheetah.",
            popularity = 3342.686,
            poster_path = "/8UlWHLMpgZm9bx6QYh0NFoq67TZ.jpg",
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
            runtime = 151,
            status = "Released",
            tagline = "A new era of wonder begins.",
            title = "Wonder Woman 1984",
            vote_average = 7.2,
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
            ),
            TvShowResponseResult(
                backdrop_path = "/o7qi2v4uWQ8bZ1tW3KI0Ztn2epk.jpg",
                first_air_date = "2019-11-12",
                id = 82856,
                name = "The Mandalorian",
                genres = listOf("Action", "Drama"),
                original_language = "en",
                original_name = "The Mandalorian",
                overview = "After the fall of the Galactic Empire, lawlessness has spread throughout the galaxy. A lone gunfighter makes his way through the outer reaches, earning his keep as a bounty hunter.",
                popularity = 1001.909,
                poster_path = "/sWgBv7LV2PRoQgkxwlibdGXKz1S.jpg",
                status = "Release",
                tagline = "tagline",
                vote_average = 8.5,
                vote_count = 5135
            ),
            TvShowResponseResult(
                backdrop_path = "/aq2yEMgRQBPfRkrO0Repo2qhUAT.jpg",
                first_air_date = "2013-03-03",
                id = 44217,
                name = "Vikings",
                genres = listOf("Action", "Drama"),
                original_language = "en",
                original_name = "Vikings",
                overview = "The adventures of Ragnar Lothbrok, the greatest hero of his age. The series tells the sagas of Ragnar's band of Viking brothers and his family, as he rises to become King of the Viking tribes. As well as being a fearless warrior, Ragnar embodies the Norse traditions of devotion to the gods. Legend has it that he was a direct descendant of Odin, the god of war and warriors.",
                popularity = 976.685,
                poster_path = "/bQLrHIRNEkE3PdIWQrZHynQZazu.jpg",
                status = "Release",
                tagline = "tagline",
                vote_average = 8.0,
                vote_count = 3794
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
            id = 1432,
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