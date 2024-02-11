package com.elattaoui.domain.usecase.detail

import kotlinx.coroutines.flow.Flow

interface GetPokemonDetailsUseCase {
    suspend fun invoke(name: String): Flow<PokemonDetailsRequestState>
}