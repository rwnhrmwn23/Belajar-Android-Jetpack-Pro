package com.onedev.dicoding.architecturecomponent.data.source.remote.response

data class TvShowResponse(
    val page: Int,
    val results: List<TvShowResponseResult>,
    val total_pages: Int,
    val total_results: Int
)