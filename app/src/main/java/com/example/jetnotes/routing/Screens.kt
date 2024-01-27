package com.example.jetnotes.routing

sealed class Screen(val route: String) {
    data object Notes : Screen("Notes")
    data object SaveNote : Screen("SaveNote")
    data object Trash : Screen("Trash")
}