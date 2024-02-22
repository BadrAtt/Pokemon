package com.elattaoui.domain.repository.pokemons

import androidx.paging.PagingData
import com.elattaoui.domain.model.Pokemon
import kotlinx.coroutines.flow.Flow

interface PokemonsListRepository {
    suspend fun getPokemonsList(): Flow<PagingData<Pokemon>>
}