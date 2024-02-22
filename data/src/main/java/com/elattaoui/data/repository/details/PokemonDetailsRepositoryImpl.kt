package com.elattaoui.data.repository.details

import com.elattaoui.data.datasource.details.PokemonDetailsDataSource
import com.elattaoui.domain.model.PokemonDetails
import com.elattaoui.domain.model.resource.ResultState
import com.elattaoui.domain.repository.details.PokemonDetailsRepository
import javax.inject.Inject

class PokemonDetailsRepositoryImpl @Inject constructor(
    private val dataSource: PokemonDetailsDataSource
) : PokemonDetailsRepository {
    override suspend fun getPokemonDetails(name: String): ResultState<PokemonDetails> {
        return dataSource.getPokemonsDetails(name)
    }
}