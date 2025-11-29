package com.example.brightmotive

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel


@Composable
fun HomeScreen(nav: NavController, vm: ThemeViewModel = viewModel()) {
    val quote = vm.selectedQuote.collectAsStateWithLifecycle(null)
    val mood = vm.selectedMood.collectAsStateWithLifecycle(null)
    val finalQuote = quote.value ?: QuotesRepository.randomQuoteForMood((mood.value ?: "motivation").lowercase())
    Surface(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Text(text = mood.value ?: "Your Motivation", modifier = Modifier.padding(bottom = 16.dp))

            Text(
                text = finalQuote,
                modifier = Modifier.padding(12.dp)
            )

            Spacer(Modifier.height(24.dp))

            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                Button(onClick = { nav.navigate("mood") }) {
                    Text("Another quote")
                }

                Button(onClick = { nav.navigate("settings") }) {
                    Text("Settings")
                }
            }
        }
    }
}
