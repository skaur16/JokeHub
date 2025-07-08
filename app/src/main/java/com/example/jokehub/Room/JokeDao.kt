package com.example.jokehub.Room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.jokehub.models.Joke

@Dao
interface JokeDao {

    @Query("SELECT * from Joke")
    suspend fun getFavJokes() : List<Joke>

    @Insert
    suspend fun addToFav(joke : Joke)

    @Delete
    suspend fun deleteJoke(joke : Joke)
}