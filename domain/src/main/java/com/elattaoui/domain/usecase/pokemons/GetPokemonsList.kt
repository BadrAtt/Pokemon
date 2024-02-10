package com.elattaoui.domain.usecase.pokemons

import androidx.paging.PagingData
import androidx.paging.map
import com.elattaoui.data.repository.pokemons.PokemonsListRepository
import com.elattaoui.domain.mapper.toDomainModel
import com.elattaoui.domain.model.Pokemon
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetPokemonsList @Inject constructor(
    private val pokempnsListRepository: PokemonsListRepository
) : GetPokemonsListUseCase {
    override suspend fun invoke(): Flow<PagingData<Pokemon>> {
        return pokempnsListRepository.getPokemonsList().map { pokemonsPagingData ->
            pokemonsPagingData.map { pokemon ->
                pokemon.toDomainModel()
            }
        }
    }
}