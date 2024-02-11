package com.elattaoui.data.datasource.details

import com.elattaoui.data.api.PokemonDetailsApi
import com.elattaoui.data.entity.PokemonDetailsEntity
import com.elattaoui.data.response.ApiResponse
import com.elattaoui.data.response.handleApiReponse
import javax.inject.Inject

class PokemonDetailsDataSourceImpl @Inject constructor(
    private val api: PokemonDetailsApi
) : PokemonDetailsDataSource {
    override suspend fun getPokemonsDetails(name: String): ApiResponse<PokemonDetailsEntity> {
        return handleApiReponse {
            api.getPokemonDetails(name)
        }
    }
}