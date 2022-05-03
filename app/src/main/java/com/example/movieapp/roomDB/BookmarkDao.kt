package com.example.movieapp.roomDB

import androidx.room.*
import com.example.movieapp.utils.Constants.Companion.TABLE_NAME

@Dao
interface BookmarkDao {

    // insert movie into table
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovie(Movie: MovieDB)

    // delete movie from database
    @Delete
    suspend fun removeMovie(movie: MovieDB)

    // delete movie by ID

    @Query("Delete from ${TABLE_NAME} where id=:id")
    suspend fun deleteMovieById(id : Int)

    // get all movies from database
    @Query("Select * from $TABLE_NAME")
    fun getAllBookmark() : List<MovieDB>

    // check movie if exist in database
    @Query("Select exists (select 1 from $TABLE_NAME where id = :id)")
    fun bookmarkExist(id: Int): Boolean

}