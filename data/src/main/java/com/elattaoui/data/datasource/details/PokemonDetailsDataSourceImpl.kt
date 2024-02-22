package com.elattaoui.data.datasource.details

import com.elattaoui.data.api.PokemonDetailsApi
import com.elattaoui.data.mapper.PokemonDetailsMapper
import com.elattaoui.data.response.handleApiReponse
import com.elattaoui.domain.model.PokemonDetails
import com.elattaoui.domain.model.resource.ResultState
import javax.inject.Inject

class PokemonDetailsDataSourceImpl @Inject constructor(
    private val api: PokemonDetailsApi
) : PokemonDetailsDataSource {
    override suspend fun getPokemonsDetails(name: String): ResultState<PokemonDetails> {
        return handleApiReponse(mapper = PokemonDetailsMapper) {
            api.getPokemonDetails(name)
        }
    }
}