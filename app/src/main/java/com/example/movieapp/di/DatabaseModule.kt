package com.example.movieapp.di

import android.app.Application
import com.example.movieapp.roomDB.MovieDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(application: Application) = MovieDatabase.getDatabase(application)

    @Provides
    @Singleton
    fun provideBookmarkDao(database: MovieDatabase) = database.getBookmarkDao()

}