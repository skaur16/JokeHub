package com.example.jokehub.features.comp

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.jokehub.features.jokesViewModel

@Composable
fun Fav(viewModel : jokesViewModel) {

    LaunchedEffect(key1 = Unit){
        viewModel.updateFavJokesList()
    }

    Column(
        modifier = Modifier.fillMaxSize().padding(10.dp),
        horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally
    ){
        Text(text = "Favourites",
            style = MaterialTheme.typography.titleLarge
            )

        LazyColumn(){
            items(viewModel.favJokes.value){
                Log.e("FAVJoke", it.toString())
                JokeCard(it, viewModel)
            }
        }
    }
}