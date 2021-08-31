package com.onedev.dicoding.architecturecomponent.data.source.local

import com.google.gson.annotations.SerializedName

data class TvShowEntity(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("poster_path")
    val posterPath: String,
    @SerializedName("vote_average")
    val voteAverage: Double
)