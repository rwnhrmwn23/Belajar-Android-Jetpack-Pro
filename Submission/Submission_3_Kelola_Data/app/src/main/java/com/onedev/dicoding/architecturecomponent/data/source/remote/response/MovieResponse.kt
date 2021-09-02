package com.onedev.dicoding.architecturecomponent.data.source.remote.response

data class MovieResponse(
    val page: Int,
    val results: List<MovieResponseResult>,
    val total_pages: Int,
    val total_results: Int
)