package com.elattaoui.data.datasource.details

import com.elattaoui.data.entity.PokemonDetailsEntity
import com.elattaoui.data.response.ApiResponse

interface PokemonDetailsDataSource {
    suspend fun getPokemonsDetails(name: String): ApiResponse<PokemonDetailsEntity>
}