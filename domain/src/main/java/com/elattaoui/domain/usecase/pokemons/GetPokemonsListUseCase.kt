package com.elattaoui.domain.usecase.pokemons

import androidx.paging.PagingData
import com.elattaoui.domain.model.Pokemon
import kotlinx.coroutines.flow.Flow

interface GetPokemonsListUseCase {
    suspend fun invoke(): Flow<PagingData<Pokemon>>
}