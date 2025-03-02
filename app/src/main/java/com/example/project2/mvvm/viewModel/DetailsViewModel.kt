package com.example.project2.mvvm.viewModel

import androidx.lifecycle.ViewModel
import com.example.project2.navigation.NavigationManager

class DetailsViewModel(private val navigationManager: NavigationManager) : ViewModel() {

    fun onNavigateToHomeClicked() {
        navigationManager.navigateToHome()
    }

    fun onNavigateToContentClicked() {
        navigationManager.navigateToContent()
    }


}