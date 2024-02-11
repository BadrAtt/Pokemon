package com.elattaoui.data.entity

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PokemonStatsEntity(
    @field:Json(name = "base_stat") val baseStat: Int,
    val effort: Int,
    val stat: StatEntity
)

@JsonClass(generateAdapter = true)
data class StatEntity(
    val name: String,
    val url: String
)