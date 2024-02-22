package com.elattaoui.data.datasource.details

import com.elattaoui.domain.model.PokemonDetails
import com.elattaoui.domain.model.resource.ResultState

interface PokemonDetailsDataSource {
    suspend fun getPokemonsDetails(name: String): ResultState<PokemonDetails>
}