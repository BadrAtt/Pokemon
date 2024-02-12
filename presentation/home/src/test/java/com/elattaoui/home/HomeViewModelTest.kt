package com.elattaoui.home

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.elattaoui.common.MainDispatcherRule
import com.elattaoui.domain.usecase.pokemons.GetPokemonsList
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Rule


@ExperimentalCoroutinesApi
class HomeViewModelTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    private lateinit var getPokemonsList: GetPokemonsList
    private lateinit var viewModel: HomeViewModel


    @Before
    fun setup() {
        getPokemonsList = mockk()
        viewModel = HomeViewModel(getPokemonsList)
    }

}