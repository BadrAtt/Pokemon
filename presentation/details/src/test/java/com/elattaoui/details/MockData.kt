package com.elattaoui.details

import com.elattaoui.domain.model.PokemonDetails

object MockData {
    fun mockPokemonDetails() = DetailsUiState.Success(
        PokemonDetails(
            id = 21,
            name = "spearow",
            height = 3,
            weight = 20,
            baseExperience = 52,
            order = 30,
            stats = emptyList(),
        )
    )
}