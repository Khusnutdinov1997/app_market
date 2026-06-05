package com.example.appmarket.ui.screens

sealed class Screens(val route: String) {
    object MainScreen: Screens(route = "MainScreen")
    object CartScreen: Screens(route = "CartScreen")
}