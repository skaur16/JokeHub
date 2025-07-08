package com.example.jokehub.features.comp

import android.content.Context
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.jokehub.features.jokesViewModel

@Composable
fun Home(viewModel : jokesViewModel, context : Context) {

    LaunchedEffect(key1 = Unit){
        viewModel.getTechJokes(context)
    }

    Column(
        modifier = Modifier.fillMaxSize().padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){

        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.padding(top = 30.dp, bottom = 20.dp)
        ){

            Text(text = "Tech Jokes",
                style = MaterialTheme.typography.titleLarge
            )
        }

        LazyColumn (){
            items(viewModel.jokes.value){
                JokeCard(it, viewModel)
            }
        }
    }
}