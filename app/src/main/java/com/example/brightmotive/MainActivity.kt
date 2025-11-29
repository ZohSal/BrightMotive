package com.example.brightmotive

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.brightmotive.ui.theme.BrightMotiveTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            val themeViewModel: ThemeViewModel = viewModel()
            val isDark = themeViewModel.isDarkMode.collectAsStateWithLifecycle()

            BrightMotiveTheme(darkTheme = isDark.value) {
                val navController = rememberNavController()
                AppNavigation(navController, themeViewModel)
            }
        }
    }
}
