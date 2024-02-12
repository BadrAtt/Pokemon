package com.elattaoui.details

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import com.elattaoui.details.intent.DetailsIntent
import com.elattaoui.view.components.AppTopBar

@Composable
fun DetailsScreen(
    pokemonName: String,
    detailsViewModel: DetailsViewModel = hiltViewModel()
) {
    val state by detailsViewModel.pokemonDetailsState.collectAsStateWithLifecycle()
    LaunchedEffect(key1 = Unit) {
        detailsViewModel.processIntent(DetailsIntent.GetDetails(pokemonName))
    }

    Scaffold(modifier = Modifier.fillMaxSize(),
        topBar = {
            AppTopBar(title = pokemonName)
        }) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            when (state) {
                is DetailsUiState.Exception -> {
                    //TODO: handle errors...
                }

                DetailsUiState.Loading -> {
                    //TODO: handle Loading...
                }

                is DetailsUiState.Success -> {
                    val pokemonDetails = (state as DetailsUiState.Success).data
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp),
                        shape = MaterialTheme.shapes.medium,
                        elevation = CardDefaults.cardElevation(
                            defaultElevation = 0.dp
                        ),
                        colors = CardDefaults.cardColors(
                            containerColor = MaterialTheme.colorScheme.surface
                        ),
                    ) {

                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            AsyncImage(
                                model = pokemonDetails.imageUrl,
                                contentDescription = null
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            Text(
                                modifier = Modifier.padding(top = 12.dp),
                                text = pokemonDetails.name,
                                fontSize = 24.sp,
                                color = MaterialTheme.colorScheme.onBackground
                            )
                        }

                    }

                    Spacer(modifier = Modifier.height(8.dp))
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp),
                        shape = MaterialTheme.shapes.medium,
                        elevation = CardDefaults.cardElevation(
                            defaultElevation = 0.dp
                        ),
                        colors = CardDefaults.cardColors(
                            containerColor = MaterialTheme.colorScheme.surface
                        ),
                    ) {

                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp),
                            verticalArrangement = Arrangement.Top,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {

                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceEvenly
                            ) {
                                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                    Text(
                                        text = stringResource(
                                            id = R.string.weight_label
                                        ),
                                        fontWeight = FontWeight.Black,
                                        fontSize = 18.sp,
                                        color = MaterialTheme.colorScheme.onBackground
                                    )
                                    Text(
                                        text = stringResource(
                                            id = R.string.weight_value,
                                            pokemonDetails.weightKg,
                                        ),
                                        fontWeight = FontWeight.Medium,
                                        fontSize = 16.sp,
                                        color = MaterialTheme.colorScheme.onBackground
                                    )
                                }
                                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                    Text(
                                        text = stringResource(
                                            id = R.string.height_label
                                        ),
                                        fontWeight = FontWeight.Black,
                                        fontSize = 18.sp,
                                        color = MaterialTheme.colorScheme.onBackground
                                    )
                                    Text(
                                        text = stringResource(
                                            id = R.string.height_value,
                                            pokemonDetails.heightM,
                                        ),
                                        fontWeight = FontWeight.Medium,
                                        fontSize = 16.sp,
                                        color = MaterialTheme.colorScheme.onBackground
                                    )
                                }
                            }
                        }

                    }
                }

                else -> {}
            }
        }
    }
}