package com.onedev.dicoding.architecturecomponent.data.source.remote.response

data class TvShowDetailResponse(
    val backdrop_path: String,
    val first_air_date: String,
    val genres: List<DetailGenre>,
    val homepage: String,
    val id: Int,
    val in_production: Boolean,
    val last_air_date: String,
    val name: String,
    val number_of_episodes: Int,
    val number_of_seasons: Int,
    val original_name: String,
    val overview: String,
    val popularity: Double,
    val poster_path: String,
    val production_companies: List<DetailProductionCompany>,
    val status: String,
    val tagline: String,
    val type: String,
    val vote_average: Double,
    val vote_count: Int
)