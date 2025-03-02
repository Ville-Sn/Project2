package com.example.project2.mvvm.view

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.project2.mvvm.viewModel.ContentViewModel
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.KeyboardArrowDown

@Composable
fun ContentView(viewModel: ContentViewModel) {
    val activities by viewModel.activities.collectAsState()

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        item {
            Row(modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center){
                Text(
                    text = "Sorties and Invasions screen",
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.Bold
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
        }

        item {
            var sortiesExpanded by remember { mutableStateOf(false) }
            ExpandableSection(
                title = "Sorties",
                isExpanded = sortiesExpanded,
                onExpandChange = { sortiesExpanded = it }
            ) {
                activities?.sorties?.let { sorties ->
                    Column {
                        sorties.forEach { sortie ->
                            Text(text = "expires: ${sortie.time.date.numberLong}")
                            Text(text = "Sortie: ${sortie.boss}")
                            Spacer(modifier = Modifier.height(8.dp))
                            var variantsExpanded by remember { mutableStateOf(false) }
                            ExpandableSection(
                                title = "Variants",
                                isExpanded = variantsExpanded,
                                onExpandChange = { variantsExpanded = it }
                            ) {
                                Column{
                                    sortie.variants.forEach { variant ->
                                        Text(text = "Mission Type: ${variant.missionType}")
                                        Text(text = "Modifier Type: ${variant.modifierType}")
                                        Text(text = "Node: ${variant.node}")
                                        Text(text = "Tileset: ${variant.tileset}")
                                        Spacer(modifier = Modifier.height(8.dp))
                                    }
                                }

                            }
                        }
                    }
                }
            }
        }

        item {
            var invasionsExpanded by remember { mutableStateOf(false) }
            ExpandableSection(
                title = "Invasions",
                isExpanded = invasionsExpanded,
                onExpandChange = { invasionsExpanded = it }
            ) {
                activities?.invasions?.let { invasions ->
                    Column {
                        invasions.forEach { invasion ->
                            Text(text = "Invasion location: ${invasion.node}")
                            Text(text = "Defender: ${invasion.defenderFaction}")
                            Text(text = "Attacker: ${invasion.faction}")
                            Spacer(modifier = Modifier.height(8.dp))
                        }
                    }
                }
            }
        }

        item {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Button(onClick = { viewModel.onNavigateToHomeClicked() }) {
                    Text(text = "go to Home screen")
                }
                Spacer(modifier = Modifier.width(16.dp))
                Button(onClick = { viewModel.onNavigateToDetailsClicked() }) {
                    Text(text = "go to Details screen")
                }

            }

            }

        }
    }


@Composable
fun ExpandableSection(
    title: String,
    isExpanded: Boolean,
    onExpandChange: (Boolean) -> Unit,
    content: @Composable () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { onExpandChange(!isExpanded) },
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.weight(1f)
            )
            Icon(
                imageVector = if (isExpanded) Icons.Filled.KeyboardArrowUp else Icons.Filled.KeyboardArrowDown,
                contentDescription = if (isExpanded) "Collapse" else "Expand"
            )
        }
        androidx.compose.animation.AnimatedVisibility(visible = isExpanded) {
            content()
        }
    }
}
