package com.example.brightmotive

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kotlinx.coroutines.delay
import androidx.lifecycle.compose.collectAsStateWithLifecycle
@Composable
fun MotivationScreen(navController: NavController, vm: ThemeViewModel) {
    val moodState = vm.selectedMood.collectAsStateWithLifecycle()
    val currentMood = moodState.value ?: "motivated"
    val quote = remember(currentMood) {
        QuotesRepository.randomQuoteForMood(currentMood.lowercase())
    }
    LaunchedEffect(Unit) {
        vm.chooseMood(currentMood)
        kotlinx.coroutines.delay(5000)
        navController.navigate("home") {
            popUpTo("motivation") { inclusive = true }
        }
    }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = quote,
                fontSize = 28.sp,
                color = MaterialTheme.colorScheme.onBackground
            )
        }
    }
}


