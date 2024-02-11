package com.elattaoui.domain.usecase.detail

import com.elattaoui.domain.model.PokemonDetails

sealed class PokemonDetailsRequestState {
    data object Loading : PokemonDetailsRequestState()
    data class Success(val data: PokemonDetails) : PokemonDetailsRequestState()
    data class Exception(val code: Int, val exception: Throwable) : PokemonDetailsRequestState()
}