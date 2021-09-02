package com.onedev.dicoding.architecturecomponent.data.source.remote.response

data class TvShowDetailResponse(
    val genres: List<DetailGenre>,
    val id: Int,
    val name: String,
    val overview: String,
    val popularity: Double,
    val poster_path: String,
    val production_companies: List<DetailProductionCompany>,
    val status: String,
    val tagline: String,
    val vote_average: Double
)