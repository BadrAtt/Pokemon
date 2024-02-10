package com.elattaoui.view.theme.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.elattaoui.domain.model.Pokemon

@Composable
fun PokemonItem(
    pokemon: Pokemon,
    onPokemonItemClicked: (Pokemon) -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        shape = MaterialTheme.shapes.medium,
        elevation = CardDefaults.cardElevation(
            defaultElevation = 8.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        )
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            AsyncImage(model = pokemon.imageUrl, contentDescription = null)
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                modifier = Modifier.padding(top = 8.dp, bottom = 8.dp),
                text = pokemon.name,
                fontSize = 20.sp,
                color = MaterialTheme.colorScheme.onBackground
            )
        }

    }
}


@Preview
@Composable
fun PreviewPokemonItem() {
    PokemonItem(
        pokemon = Pokemon(
            name = "ivysaur",
            url = "https://pokeapi.co/api/v2/pokemon/2/"
        )
    ) {
    }
}