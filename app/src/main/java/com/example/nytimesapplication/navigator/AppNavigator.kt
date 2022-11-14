package com.example.nytimesapplication.navigator

enum class Screens {
    SEARCH
}

interface AppNavigator {
    fun navigateTo(screen: Screens)
}