package com.onedev.dicoding.architecturecomponent.data.source.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movieEntities")
data class MovieEntity(
    @PrimaryKey
    val id: Int,
    val title: String? = null,
    val poster_path: String? = null,
    val vote_average: Double? = 0.0,
    val genres: String? = null,
    val overview: String? = null,
    val popularity: Double? = null,
    val release_date: String? = null,
    val runtime: Int? = 0,
    val status: String? = null,
    val tagline: String? = null,
    var favorite: Boolean = false
)