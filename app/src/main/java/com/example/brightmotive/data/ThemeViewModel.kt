package com.example.brightmotive

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlin.random.Random

class ThemeViewModel : ViewModel() {

    // Dark mode state (not persisted permanently in this example)
    private val _isDarkMode = MutableStateFlow(false)
    val isDarkMode: StateFlow<Boolean> = _isDarkMode

    fun setDarkMode(value: Boolean) { _isDarkMode.value = value }

    // Current selected mood and quote
    private val _selectedMood = MutableStateFlow<String?>(null)
    val selectedMood: StateFlow<String?> = _selectedMood

    private val _selectedQuote = MutableStateFlow<String?>(null)
    val selectedQuote: StateFlow<String?> = _selectedQuote

    // Choose mood and pick a random quote for it
    fun chooseMood(mood: String) {
        _selectedMood.value = mood
        _selectedQuote.value = QuotesRepository.randomQuoteForMood(mood)
    }

    // Force pick a new quote (can be called from Home to refresh)
    fun pickNewQuote() {
        _selectedMood.value?.let { mood ->
            _selectedQuote.value = QuotesRepository.randomQuoteForMood(mood)
        }
    }
}
