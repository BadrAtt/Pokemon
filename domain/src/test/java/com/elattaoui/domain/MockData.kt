package com.elattaoui.domain

import com.elattaoui.domain.model.PokemonDetails


object MockData {

    val mockPokoemonDetails = PokemonDetails(
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