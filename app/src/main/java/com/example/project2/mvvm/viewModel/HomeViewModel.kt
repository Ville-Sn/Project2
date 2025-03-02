package com.example.project2.mvvm.viewModel

import androidx.lifecycle.ViewModel
import com.example.project2.navigation.NavigationManager

class HomeViewModel(private val navigationManager: NavigationManager) : ViewModel() {

    fun onNavigateToDetailsClicked() {
        navigationManager.navigateToDetails()
        }

    fun onNavigateToContentClicked() {
        navigationManager.navigateToContent()
    }


}