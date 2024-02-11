package com.elattaoui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import com.elattaoui.domain.model.Pokemon
import com.elattaoui.view.theme.components.AppTopBar
import com.elattaoui.view.theme.components.PokemonItem

@Composable
fun HomeScreen(
    homeViewModel: HomeViewModel = hiltViewModel(),
    onHomeItemSelected: (String) -> Unit
) {
    val pokemons: LazyPagingItems<Pokemon> =
        homeViewModel.pokemonsListState.collectAsLazyPagingItems()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            AppTopBar(title = stringResource(id = R.string.app_title))
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(MaterialTheme.colorScheme.background),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Top
        ) {

            if (pokemons.loadState.refresh is LoadState.Loading) {
                //TODO: Display progress bar
            } else {
                LazyVerticalGrid(columns = GridCells.Fixed(2)) {
                    items(pokemons.itemCount) { pokemonItemIndex ->
                        val pokemon = pokemons[pokemonItemIndex]
                        pokemon?.let { current ->
                            PokemonItem(
                                pokemon = current
                            ) {
                                onHomeItemSelected(pokemon.name)
                            }
                        }
                    }
                }
            }
        }
    }
}