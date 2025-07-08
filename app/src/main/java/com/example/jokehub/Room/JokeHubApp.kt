package com.example.jokehub.Room

import android.app.Application
import androidx.room.Room

class JokeHubApp : Application() {

    companion object {
        lateinit var db : JokesDatabase
        private set
    }

    override fun onCreate(){
        super.onCreate()

        db = Room.databaseBuilder(
            applicationContext,
            JokesDatabase::class.java,
            "JokesDatabase"
        ).fallbackToDestructiveMigration()
            .build()
    }

}