package com.example.jokehub.features

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.example.jokehub.R
import com.example.jokehub.Screens
import com.example.jokehub.features.comp.Fav
import com.example.jokehub.features.comp.Home
import com.example.jokehub.features.comp.Jod

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun JokeScreen(viewModel: jokesViewModel) {

    val context = LocalContext.current
    Scaffold (
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Joke Hub")
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = colorResource(id = R.color.primary),
                    titleContentColor = Color.White

                )
            )
        },
        bottomBar = {
            Surface (
                color = colorResource(id = R.color.primary),
                contentColor = Color.White
            ){

                Row(
                    modifier = Modifier.fillMaxWidth().padding(10.dp).padding(bottom = 20.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ){
                    IconButton(
                        onClick = {
                            viewModel.navigate.value = Screens.JOD
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Default.DateRange,
                            contentDescription = null
                        )
                    }

                    IconButton(
                        onClick = {
                            viewModel.navigate.value = Screens.HOME
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Default.Home,
                            contentDescription = null
                        )
                    }

                    IconButton(
                        onClick = {
                            viewModel.navigate.value = Screens.FAV
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Default.Favorite,
                            contentDescription = null
                        )
                    }

                }
            }
        }
    ){
        Column(
            modifier = Modifier.fillMaxSize()
                .padding(it)
        ){
            if(viewModel.navigate.value == Screens.JOD){
             Jod(viewModel, context)
            }
            else if(viewModel.navigate.value == Screens.HOME){
                Home(viewModel, context)
            }
            else if(viewModel.navigate.value == Screens.FAV) {
                Fav(viewModel)
            }
        }
    }
}