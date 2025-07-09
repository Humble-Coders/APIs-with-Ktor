package com.yourbusiness.apiswithktor.screens

import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.yourbusiness.apiswithktor.viewModels.JokeViewModel
import io.ktor.client.*


@Composable
fun JokeApp() {
    val viewModel: JokeViewModel = viewModel()
    val joke by viewModel.joke.observeAsState()
    val isLoading by viewModel.isLoading.observeAsState(false)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(onClick = { viewModel.fetchJoke() }) {
            Text("Get Joke")
        }

        Spacer(modifier = Modifier.height(32.dp))

        val currentJoke = joke

        if (isLoading) {
            CircularProgressIndicator()
        } else if (currentJoke != null) {
            Text(
                text = currentJoke.setup,
                style = MaterialTheme.typography.headlineSmall,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = currentJoke.punchline,
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
        } else {
            Text("Click button to get a joke!")
        }
    }
}