package com.example.project2.navigation

import androidx.navigation.NavHostController

class NavigationManager(private val navController: NavHostController) {

    fun navigateToDetails(){
        navController.navigate(Screen.Details.route)
    }

    fun navigateToContent(){
        navController.navigate(Screen.Content.route)
    }

    fun navigateToHome(){
        navController.navigate(Screen.Home.route)
    }

}