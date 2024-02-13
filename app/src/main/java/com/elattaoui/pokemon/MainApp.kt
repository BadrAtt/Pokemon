package com.elattaoui.pokemon

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.elattaoui.details.navigation.detailsScreen
import com.elattaoui.details.navigation.navigateToDetails
import com.elattaoui.home.navigation.HOME_ROUTE
import com.elattaoui.home.navigation.homeScreen

@Composable
fun MainApp() {
    val navController = rememberNavController()
    NavHost(
        modifier = Modifier.fillMaxSize(),
        navController = navController,
        startDestination = HOME_ROUTE
    ) {
        homeScreen { itemName ->
            navController.navigateToDetails(itemName)
        }
        detailsScreen(onNavigateUp = {
            navController.navigateUp()
        })
    }
}