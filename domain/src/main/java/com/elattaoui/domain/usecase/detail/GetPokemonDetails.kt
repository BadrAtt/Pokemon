package com.elattaoui.domain.usecase.detail

import com.elattaoui.data.repository.details.PokemonDetailsRepository
import com.elattaoui.data.response.ApiResponse
import com.elattaoui.domain.mapper.toDomainModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetPokemonDetails @Inject constructor(
    private val repository: PokemonDetailsRepository
) : GetPokemonDetailsUseCase {
    override suspend fun invoke(name: String): Flow<PokemonDetailsRequestState> {
        return flow {
            emit(PokemonDetailsRequestState.Loading)
            when (val response = repository.getPokemonDetails(name)) {
                is ApiResponse.Success -> {
                    emit(PokemonDetailsRequestState.Success(response.data.toDomainModel()))
                }

                is ApiResponse.Error -> {
                    emit(
                        PokemonDetailsRequestState.Exception(
                            code = response.code,
                            exception = response.exception
                        )
                    )
                }
            }
        }
    }
}