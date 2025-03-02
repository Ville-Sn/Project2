package com.example.project2.mvvm.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.project2.mvvm.model.Activities
import com.example.project2.navigation.NavigationManager
import com.example.project2.network.RetrofitInstance
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ContentViewModel(private val navigationManager: NavigationManager) : ViewModel() {

    fun onNavigateToHomeClicked() {
        navigationManager.navigateToHome()
    }

    fun onNavigateToDetailsClicked() {
        navigationManager.navigateToDetails()
    }

    private val _activities = MutableStateFlow<Activities?>(null)
    val activities: StateFlow<Activities?> = _activities.asStateFlow()

    init{
        loadActivities()
    }

    private fun loadActivities() {
        viewModelScope.launch {
            try {
                val result = RetrofitInstance.apiService.getActivities()
                Log.d("ContentViewModel", "Raw JSON: $result")
                _activities.value = result
            } catch (e: Exception) {
                Log.d("ContentViewModel", "Raw JSON: error here", e)
                // Handle error
                _activities.value = null
            }
        }
    }


}