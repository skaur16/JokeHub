package com.example.jokehub.features.comp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.unit.dp
import com.example.jokehub.R
import com.example.jokehub.features.jokesViewModel
import com.example.jokehub.models.Joke

@Composable
fun JokeCard(joke : Joke, viewModel: jokesViewModel) {

    Card(
        modifier = Modifier.fillMaxWidth()
            .padding(10.dp),
        colors = CardDefaults.cardColors(
            containerColor = colorResource(id = R.color.screen)
        )
    ){
        Column(
            modifier = Modifier.padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Text(text = joke.setup)
            Text(text = joke.punchline)

            Row(
                modifier = Modifier.fillMaxWidth().padding(top = 8.dp),
                horizontalArrangement = Arrangement.Center
            ){

                IconButton(
                    onClick = {
                        if(viewModel.checkFav(joke) == Icons.Default.Favorite){
                            viewModel.deleteJoke(joke)
                        }
                        else
                            viewModel.addToFav(joke)
                    }
                ){
                    Icon(
                        imageVector = viewModel.checkFav(joke),
                        contentDescription = null
                    )
                }
            }
        }
    }
}