package com.onedev.dicoding.architecturecomponent.data.source.remote.response

data class MovieDetailResponse(
    val genres: List<DetailGenre>,
    val id: Int,
    val overview: String,
    val popularity: Double,
    val poster_path: String,
    val production_companies: List<DetailProductionCompany>,
    val release_date: String,
    val runtime: Int,
    val status: String,
    val tagline: String,
    val title: String,
    val vote_average: Double
)