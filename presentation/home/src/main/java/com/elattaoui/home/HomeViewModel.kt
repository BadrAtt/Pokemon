package com.elattaoui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.elattaoui.domain.model.Pokemon
import com.elattaoui.domain.usecase.pokemons.GetPokemonsList
import com.elattaoui.home.intent.HomeIntent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getPokemonsList: GetPokemonsList
) : ViewModel() {


    private val _pokemonsListState: MutableStateFlow<PagingData<Pokemon>> =
        MutableStateFlow(value = PagingData.empty())
    val pokemonsListState: MutableStateFlow<PagingData<Pokemon>> get() = _pokemonsListState

    fun processIntent(intent: HomeIntent) {
        if (intent is HomeIntent.GetPokemonsList) {
            viewModelScope.launch {
                fetchPokemonsList()
            }
        }
    }


    private suspend fun fetchPokemonsList() {
        getPokemonsList.invoke()
            .distinctUntilChanged()
            .cachedIn(viewModelScope)
            .collect { pokemonsPagedData ->
                _pokemonsListState.value = pokemonsPagedData
            }

    }
}