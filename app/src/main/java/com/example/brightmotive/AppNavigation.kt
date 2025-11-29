package com.example.brightmotive

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun AppNavigation(navController: NavHostController, vm: ThemeViewModel) {
    NavHost(
        navController = navController,
        startDestination = "mood"
    ) {
        composable("mood") { MoodSelectionScreen(navController, vm) }
        composable("motivation") { MotivationScreen(navController, vm) }
        composable("home") { HomeScreen(navController, vm) }
        composable("settings") { SettingsScreen(navController, vm) }
    }
}


