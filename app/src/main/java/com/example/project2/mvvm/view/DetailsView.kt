package com.example.project2.mvvm.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.project2.mvvm.viewModel.DetailsViewModel
import com.example.project2.navigation.Screen

@Composable
fun DetailsView(viewModel: DetailsViewModel){

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(text = "Welcome to the Details screen!", style = MaterialTheme.typography.bodyLarge)
        Text(text = "not much to see here yet")
        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick =  { viewModel.onNavigateToHomeClicked() }) {
            Text(text = "go to Home screen")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick =  { viewModel.onNavigateToContentClicked() }) {
            Text(text = "go to Content screen")
        }
    }
}