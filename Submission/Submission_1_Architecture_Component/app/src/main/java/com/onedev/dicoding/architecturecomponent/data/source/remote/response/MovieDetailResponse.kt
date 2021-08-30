package com.onedev.dicoding.architecturecomponent.data.source.remote.response

data class MovieDetailResponse(
    val adult: Boolean,
    val backdrop_path: String,
    val budget: Int,
    val genres: List<MovieDetailGenre>,
    val homepage: String,
    val id: Int,
    val original_language: String,
    val original_title: String,
    val overview: String,
    val popularity: Double,
    val poster_path: String,
    val production_companies: List<MovieDetailProductionCompany>,
    val release_date: String,
    val revenue: Int,
    val runtime: Int,
    val status: String,
    val tagline: String,
    val title: String,
    val vote_average: Double,
    val vote_count: Int
)