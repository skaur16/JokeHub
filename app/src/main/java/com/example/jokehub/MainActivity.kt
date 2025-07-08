package com.example.jokehub

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.jokehub.features.JokeScreen
import com.example.jokehub.features.jokesViewModel
import com.example.jokehub.ui.theme.JokeHubTheme

class MainActivity : ComponentActivity() {

    val viewModel : jokesViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JokeHubTheme {
                JokeScreen(viewModel)
            }
        }
    }
}

