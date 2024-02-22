package com.elattaoui.domain.usecase.detail

import com.elattaoui.domain.model.resource.ResultState
import com.elattaoui.domain.repository.details.PokemonDetailsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onStart
import javax.inject.Inject

class GetPokemonDetails @Inject constructor(
    private val repository: PokemonDetailsRepository
) : GetPokemonDetailsUseCase {
    override suspend fun invoke(name: String): Flow<PokemonDetailsRequestState> {
        return flow {
            when (val response = repository.getPokemonDetails(name)) {
                is ResultState.Success -> {
                    emit(PokemonDetailsRequestState.Success(response.data))
                }

                is ResultState.Error -> {
                    emit(
                        PokemonDetailsRequestState.Exception(
                            code = response.code,
                            exception = response.exception
                        )
                    )
                }
            }
        }.onStart {
            emit(PokemonDetailsRequestState.Loading)
        }
    }
}