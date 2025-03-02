package com.example.project2.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.project2.mvvm.viewModel.*
import com.example.project2.mvvm.view.*
import com.example.project2.mvvm.model.*

@Composable
fun AppNavGraph(navController: NavHostController) {

    //navigation functionality
    NavHost(navController = navController, startDestination = Screen.Home.route){

        composable(route = Screen.Home.route){
            val viewModel = HomeViewModel(navigationManager = NavigationManager(navController))
            HomeView(viewModel = viewModel)
        }

        composable(route = Screen.Details.route){
            val viewModel = DetailsViewModel(navigationManager = NavigationManager(navController))
            DetailsView(viewModel = viewModel)
        }

        composable(route = Screen.Content.route){
            val viewModel = ContentViewModel(navigationManager = NavigationManager(navController))
            ContentView(viewModel = viewModel)
        }

    }
}