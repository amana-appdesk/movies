package com.example.movieapp

import com.example.movieapp.network.ApiService
import com.example.movieapp.network.RetrofitCallback
import com.example.movieapp.utils.Constants
import javax.inject.Inject

class MovieRepository @Inject constructor(
    private val apiService: ApiService
) : RetrofitCallback() {

    // Get Movie Details
    suspend fun getMovieDetails(movie_id: Int) = apiRequest {
        apiService.getMovieById(movie_id, Constants.API_KEY)
    }

    // Popular Movies
    suspend fun getPopularMovie() = apiRequest {
        apiService.getPopularMovies(Constants.API_KEY)
    }

    // Top Rated Movies
    suspend fun getTopRatedMovie() = apiRequest {
        apiService.getTopRatedMovies(Constants.API_KEY)
    }

}