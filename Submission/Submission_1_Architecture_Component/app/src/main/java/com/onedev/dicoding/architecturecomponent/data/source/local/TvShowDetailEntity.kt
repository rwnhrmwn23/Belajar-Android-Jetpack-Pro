package com.onedev.dicoding.architecturecomponent.data.source.local

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class TvShowDetailEntity(
    val genres: List<String>,
    val id: Int,
    val name: String,
    val overview: String,
    val popularity: Double,
    val poster_path: String,
    val production_companies: List<String>,
    val status: String,
    val tagline: String,
    val vote_average: Double
) : Parcelable