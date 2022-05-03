package com.example.movieapp.network

import com.example.movieapp.model.Movie
import com.example.movieapp.model.MovieResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("movie/{movie_id}")
    suspend fun getMovieById(
        @Path("movie_id") movie_id: Int,
        @Query("api_key") apiKey: String
    ): Response<Movie>

    @GET("movie/{movie_id}/images")
    suspend fun getMovieImage(
        @Path("movie_id") movie_id: Int,
        @Query("api_key") apiKey: String
    ): Response<Movie>


    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query("api_key") apiKey: String,
        @Query("page") page: Int = 1
    ): Response<MovieResponse>

    @GET("movie/top_rated")
    suspend fun getTopRatedMovies(
        @Query("api_key") apiKey: String,
        @Query("page") page: Int = 1
    ): Response<MovieResponse>
}