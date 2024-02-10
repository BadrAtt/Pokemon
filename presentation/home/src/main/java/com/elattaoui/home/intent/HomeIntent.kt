package com.elattaoui.home.intent

sealed class HomeIntent {
    data object GetPokemonsList : HomeIntent()
}