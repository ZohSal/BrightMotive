package com.example.brightmotive

object QuotesRepository {
    val happyQuotes = listOf(
        "Happiness is a journey, not a destination!",
        "Smile, today is your day!",
        "Good vibes only!"
    )
    val sadQuotes = listOf(
        "It's okay to feel sad, brighter days are coming.",
        "Your story isn’t over yet.",
        "Crying doesn't mean you’re weak, it means you’re human."
    )
    val angryQuotes = listOf(
        "Breathe. Control the fire, don’t let the fire control you.",
        "You’re stronger than your anger.",
        "Frustration is temporary, your strength is permanent."
    )
    val motivatedQuotes = listOf(
        "Keep pushing, future you is watching!",
        "Small progress is still progress.",
        "Today is a good day to get better."
    )
    fun randomQuoteForMood(mood: String): String {
        return when (mood.lowercase()) {
            "happy" -> happyQuotes.random()
            "sad" -> sadQuotes.random()
            "angry" -> angryQuotes.random()
            "motivated" -> motivatedQuotes.random()
            else -> "You’re doing great — keep going!"
        }
    }
}
