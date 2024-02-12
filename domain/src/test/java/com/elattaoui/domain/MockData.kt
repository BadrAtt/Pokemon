package com.elattaoui.domain

import com.elattaoui.data.entity.PokemonDetailsEntity

object MockData {

    val mockPokoemonDetails = PokemonDetailsEntity(
        id = 21,
        name = "spearow",
        height = 3,
        weight = 20,
        baseExperience = 52,
        order = 30,
        stats = emptyList(),
    )

    val exception = Throwable()
}