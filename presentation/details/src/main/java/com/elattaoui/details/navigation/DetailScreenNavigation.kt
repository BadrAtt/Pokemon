package com.elattaoui.details.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.elattaoui.details.DetailsScreen

const val DETAILS_ROUTE = "details/{pokemonName}"
const val ARG_POKEMON_NAME = "pokemonName"
fun NavGraphBuilder.detailsScreen(
) {
    composable(
        DETAILS_ROUTE,
        arguments = listOf(navArgument(ARG_POKEMON_NAME) { type = NavType.StringType })
    ) { navBackStackEntry ->
        DetailsScreen(
            pokemonName = navBackStackEntry.arguments?.getString(ARG_POKEMON_NAME).orEmpty()
        )
    }
}

fun NavController.navigateToDetails(name: String) {
    navigate("${DETAILS_ROUTE.split("/".toRegex()).first()}/$name")
}