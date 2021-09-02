package com.onedev.dicoding.architecturecomponent.data.source.remote.response

data class TvShowResponseResult(
    val backdrop_path: String,
    val first_air_date: String,
    val id: Int,
    val name: String,
    val genres: List<String>,
    val original_language: String,
    val original_name: String,
    val overview: String,
    val popularity: Double,
    val poster_path: String,
    val status: String,
    val tagline: String,
    val vote_average: Double,
    val vote_count: Int
)