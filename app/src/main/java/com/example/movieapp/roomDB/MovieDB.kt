package com.example.movieapp.roomDB

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.movieapp.utils.Constants

@Entity(tableName = Constants.TABLE_NAME)
data class MovieDB(
    @PrimaryKey
    val id: Int,
    val poster_path: String,
    val overview: String,
    val title: String,
    val backdrop_path: String
)
