package com.example.project2.navigation

//navigation routes
sealed class Screen (val route: String){
    object Home : Screen("home")
    object Details : Screen("details")
    object Content : Screen("content")
}