package com.example.jokehub.features

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import com.android.volley.Request
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.jokehub.Room.JokeHubApp
import com.example.jokehub.Room.JokesDatabase
import com.example.jokehub.Screens
import com.example.jokehub.models.Joke
import kotlinx.coroutines.launch
import org.json.JSONArray

class jokesViewModel(application : Application) : AndroidViewModel(application) {


    val navigate = mutableStateOf(Screens.HOME)
    val jokes = mutableStateOf(listOf<Joke>())
    val favIcon = mutableStateOf(Icons.Default.FavoriteBorder)
    var randomJoke = mutableStateOf<Joke?>(null)
    var favJokes = mutableStateOf(listOf<Joke>())

    val db = JokeHubApp.db
    val jokeDao = db.jokeDao()



    fun getTechJokes(context: Context) {

        val queue = Volley.newRequestQueue(context)

        val url = "https://official-joke-api.appspot.com/jokes/programming/ten"

        val techJokesRequest =  JsonArrayRequest(
            Request.Method.GET,
            url,
            null,
            { response ->
                for(i in 0 until response.length()){
                    val joke = response.getJSONObject(i)
                    val id = joke.getInt("id")
                    val type = joke.getString("type")
                    val setup = joke.getString("setup")
                    val punchline = joke.getString("punchline")
                    jokes.value += Joke(id, type, setup, punchline)
                    Log.e("JOkes", jokes.value.toString())
                }
            },
            { error ->
                error.printStackTrace()
            }
        )
        queue.add(techJokesRequest)
    }

    fun getRandomJoke(context: Context) {

        val queue = Volley.newRequestQueue(context)
        val url = "https://official-joke-api.appspot.com/random_joke"
        val randomJokeRequest = JsonObjectRequest(
            Request.Method.GET,
            url,
            null,
            { response ->
                val id = response.getInt("id")
                val type = response.getString("type")
                val setup = response.getString("setup")
                val punchline = response.getString("punchline")
                randomJoke.value = Joke(id, type, setup, punchline)
            },
            {error->
                error.printStackTrace()
            }
        )
        queue.add(randomJokeRequest)

    }

    fun getTechJokesString(context : Context){

        val queue = Volley.newRequestQueue(context)

        val url = "https://official-joke-api.appspot.com/jokes/programming/ten"

        val strRequest = StringRequest(
            Request.Method.GET, url,
            {response->
                Log.e("Response", response.toString())
                val jsonArray = JSONArray(response)
                for(i in 0 until jsonArray.length()){
                    val joke = jsonArray.getJSONObject(i)
                    val id = joke.getInt("id")
                    val type = joke.getString("type")
                    val setup = joke.getString("setup")
                    val punchline = joke.getString("punchline")
                    jokes.value += Joke(id, type, setup, punchline)
                }

            },
            {error->
                Log.e("Try Again", error.message.toString())
            }
        )
        queue.add(strRequest)
    }

    fun addToFav(joke: Joke) {
        //TODO : save the joke to local DB

        viewModelScope.launch{
            val existing = jokeDao.getFavJokes().find {
                it.id == joke.id
            }
            if(existing == null){
                jokeDao.addToFav(joke)
                updateFavJokesList()
            }

        }

    }

    fun checkFav(joke: Joke): ImageVector {
        for(i in favJokes.value){
            if(i == joke){
                return Icons.Default.Favorite
            }
        }
        return Icons.Default.FavoriteBorder

    }


    fun updateFavJokesList() {
        viewModelScope.launch{

            favJokes.value = jokeDao.getFavJokes()
                .distinctBy {
                    it.id
                }
        }

    }

    fun deleteJoke(joke : Joke){
        viewModelScope.launch{
            jokeDao.deleteJoke(joke)
            updateFavJokesList()

        }
    }



}