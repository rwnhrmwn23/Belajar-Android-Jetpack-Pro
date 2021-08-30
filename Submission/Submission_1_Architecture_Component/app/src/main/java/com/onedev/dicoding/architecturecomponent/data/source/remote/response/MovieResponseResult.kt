package com.onedev.dicoding.architecturecomponent.data.source.remote.response

data class MovieResponseResult(
    val backdrop_path: String,
    val id: Int,
    val original_title: String,
    val overview: String,
    val popularity: Double,
    val poster_path: String,
    val release_date: String,
    val title: String,
    val vote_average: Double,
    val vote_count: Int
)