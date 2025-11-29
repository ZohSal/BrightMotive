package com.example.brightmotive

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.compose.material3.Button


@Composable
fun SettingsScreen(nav: NavController, vm: ThemeViewModel) {
    val darkModeState = vm.isDarkMode.collectAsStateWithLifecycle()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = androidx.compose.ui.Alignment.Start
    ) {
        Text("Settings", style = MaterialTheme.typography.headlineMedium)
        Spacer(Modifier.height(20.dp))

        Row(verticalAlignment = androidx.compose.ui.Alignment.CenterVertically) {
            Switch(
                checked = darkModeState.value,
                onCheckedChange = { vm.setDarkMode(it) }
            )
            Spacer(Modifier.width(16.dp))
            Text("Enable Dark Mode")
        }

        Spacer(Modifier.height(24.dp))

        Button(onClick = { nav.navigate("mood") }) {
            Text("Choose Mood")
        }
    }
}

