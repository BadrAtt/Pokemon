package com.elattaoui.domain.usecase.detail


import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import app.cash.turbine.test
import com.elattaoui.common.MainDispatcherRule
import com.elattaoui.domain.MockData
import com.elattaoui.domain.model.resource.ResultState
import com.elattaoui.domain.repository.details.PokemonDetailsRepository
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.assertj.core.api.Assertions
import org.junit.Before
import org.junit.Rule
import org.junit.Test


class GetPokemonDetailsTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    private lateinit var pokemonDetailsRepository: PokemonDetailsRepository
    private lateinit var getPokemonDetails: GetPokemonDetails

    @Before
    fun setup() {
        pokemonDetailsRepository = mockk()
        getPokemonDetails = GetPokemonDetails(pokemonDetailsRepository)
    }

    @Test
    fun `should emit Loading and then Success`() = runTest {
        coEvery { pokemonDetailsRepository.getPokemonDetails(any()) } returns ResultState.Success(
            MockData.mockPokoemonDetails
        )

        val flow = getPokemonDetails.invoke("spearow")

        flow.test {
            val itemLoading = awaitItem()
            Assertions.assertThat(PokemonDetailsRequestState.Loading).isEqualTo(itemLoading)
            val itemSuccess = awaitItem()
            Assertions.assertThat(PokemonDetailsRequestState.Success(MockData.mockPokoemonDetails))
                .isEqualTo(itemSuccess)
            awaitComplete()
        }
    }

    @Test
    fun `should emit Loading and then Error`() = runTest {
        coEvery { pokemonDetailsRepository.getPokemonDetails(any()) } returns ResultState.Error(
            exception = MockData.exception
        )
        val flow = getPokemonDetails.invoke("po")

        flow.test {
            val itemLoading = awaitItem()
            Assertions.assertThat(PokemonDetailsRequestState.Loading).isEqualTo(itemLoading)
            val itemError = awaitItem()
            Assertions.assertThat(PokemonDetailsRequestState.Exception(exception = MockData.exception))
                .isEqualTo(itemError)
            awaitComplete()
        }
    }
}