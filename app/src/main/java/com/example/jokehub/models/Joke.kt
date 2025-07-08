package com.example.jokehub.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Joke(
    @PrimaryKey(autoGenerate = true)val id: Int,
    val type: String,
    val setup: String,
    val punchline: String
)
