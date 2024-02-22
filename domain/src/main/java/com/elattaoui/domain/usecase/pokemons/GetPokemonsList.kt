package com.elattaoui.domain.usecase.pokemons

import androidx.paging.PagingData
import com.elattaoui.domain.model.Pokemon
import com.elattaoui.domain.repository.pokemons.PokemonsListRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetPokemonsList @Inject constructor(
    private val pokempnsListRepository: PokemonsListRepository
) : GetPokemonsListUseCase {
    override suspend fun invoke(): Flow<PagingData<Pokemon>> {
        return pokempnsListRepository.getPokemonsList()
    }
}