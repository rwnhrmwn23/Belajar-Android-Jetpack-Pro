package com.onedev.dicoding.architecturecomponent.data.source.local

import com.google.gson.annotations.SerializedName

data class MovieEntity(
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("poster_path")
    val posterPath: String,
    @SerializedName("vote_average")
    val voteAverage: Double
)