package com.elattaoui.data.repository.details

import com.elattaoui.data.datasource.details.PokemonDetailsDataSource
import com.elattaoui.data.entity.PokemonDetailsEntity
import com.elattaoui.data.response.ApiResponse
import javax.inject.Inject

class PokemonDetailsRepositoryImpl @Inject constructor(
    private val dataSource: PokemonDetailsDataSource
) : PokemonDetailsRepository {
    override suspend fun getPokemonDetails(name: String): ApiResponse<PokemonDetailsEntity> {
        return dataSource.getPokemonsDetails(name)
    }
}