package com.elattaoui.domain.repository.details

import com.elattaoui.domain.model.PokemonDetails
import com.elattaoui.domain.model.resource.ResultState

interface PokemonDetailsRepository {
    suspend fun getPokemonDetails(name: String): ResultState<PokemonDetails>
}