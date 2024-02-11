package com.elattaoui.data.repository.details

import com.elattaoui.data.entity.PokemonDetailsEntity
import com.elattaoui.data.response.ApiResponse

interface PokemonDetailsRepository {
    suspend fun getPokemonDetails(name: String): ApiResponse<PokemonDetailsEntity>
}