package com.elattaoui.data.repository.pokemons

import androidx.paging.PagingData
import com.elattaoui.data.entity.PokemonEntity
import kotlinx.coroutines.flow.Flow

interface PokemonsListRepository {
    suspend fun getPokemonsList(): Flow<PagingData<PokemonEntity>>
}