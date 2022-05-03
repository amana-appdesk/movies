package com.example.movieapp.roomDB

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [MovieDB::class],
    version = 1,
    exportSchema = false
)
abstract class MovieDatabase : RoomDatabase() {

    abstract fun getBookmarkDao(): BookmarkDao

    companion object {

        @Volatile
        private var instance: MovieDatabase? = null

        fun getDatabase(context: Context): MovieDatabase {

            if (instance == null) {
                synchronized(this) {
                    instance = buildDatabase(context)
                }
            }
            return instance!!
        }

        private fun buildDatabase(context: Context): MovieDatabase {

            return Room.databaseBuilder(
                context.applicationContext,
                MovieDatabase::class.java,
                "movie_database"
            ).allowMainThreadQueries()
                .build()

        }
    }
}