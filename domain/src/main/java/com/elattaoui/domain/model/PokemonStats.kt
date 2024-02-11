package com.elattaoui.domain.model

data class PokemonStats(
    val baseStat: Int,
    val effort: Int,
    val stat: Stat
)

data class Stat(
    val name: String,
    val url: String
)

