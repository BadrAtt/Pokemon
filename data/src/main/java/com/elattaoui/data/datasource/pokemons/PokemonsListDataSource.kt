package com.elattaoui.data.datasource.pokemons

import com.elattaoui.data.response.PokemonsResponse

interface PokemonsListDataSource {
    suspend fun getPokemonsList(page: Int): PokemonsResponse
}