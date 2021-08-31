package com.onedev.dicoding.architecturecomponent.data.source.local

data class MovieDetailEntity(
    val genres: List<String>,
    val id: Int,
    val overview: String,
    val popularity: Double,
    val poster_path: String,
    val production_companies: List<String>,
    val release_date: String? = null,
    val runtime: Int? = 0,
    val status: String,
    val tagline: String,
    val title: String? = null,
    val vote_average: Double
)