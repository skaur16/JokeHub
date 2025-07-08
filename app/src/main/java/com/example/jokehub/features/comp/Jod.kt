package com.example.jokehub.features.comp

import android.content.Context
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.jokehub.features.jokesViewModel

@Composable
fun Jod(viewModel : jokesViewModel, context : Context) {

    LaunchedEffect(key1 = Unit){
        viewModel.getRandomJoke(context)
    }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ){

        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.padding(top = 30.dp, bottom = 50.dp)
        ){

            Text(text = "Joke Of The Day",
                style = MaterialTheme.typography.titleLarge
            )
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ){

            if(viewModel.randomJoke.value != null){
                JokeCard(viewModel.randomJoke.value!!, viewModel)
            }
            else{
                Text(text = "Loading...")
            }
        }


    }
}