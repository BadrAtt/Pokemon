package com.elattaoui.data.response

import com.elattaoui.data.entity.PokemonEntity
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PokemonsResponse(
    val count: Int,
    val next: String?,
    val previous: String?,
    val results: List<PokemonEntity>,
)