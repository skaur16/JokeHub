package com.example.jokehub.Room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.jokehub.models.Joke

@Database( entities = [Joke::class], version = 2)
abstract class JokesDatabase : RoomDatabase(){

    abstract fun jokeDao() : JokeDao
}