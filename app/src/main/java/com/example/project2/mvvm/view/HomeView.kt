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
import com.example.project2.mvvm.viewModel.HomeViewModel
import com.example.project2.navigation.Screen


@Composable
fun HomeView(viewModel: HomeViewModel){

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(15.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.height(50.dp))

        Text(text = "Warframe invasion and sortie companion", style = MaterialTheme.typography.bodyLarge)

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick =  { viewModel.onNavigateToContentClicked() }) {
            Text(text = "view invasions and sorties")
        }

        Spacer(modifier = Modifier.height(15.dp))

        Button(onClick =  { viewModel.onNavigateToDetailsClicked() }) {
            Text(text = "Details")
        }

        Spacer(modifier = Modifier.height(16.dp))


    }
}