package com.example.movieapp.ui.topRated

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.movieapp.MovieRepository
import com.example.movieapp.network.Resource
import kotlinx.coroutines.Dispatchers
import java.net.SocketTimeoutException
import javax.inject.Inject

class TopRatedMoviesViewModel @Inject constructor(private val repository: MovieRepository) :
    ViewModel() {

    fun getTopRatedMovies() = liveData(Dispatchers.IO) {
        emit(Resource.loading())
        try {
            emit(Resource.success(repository.getTopRatedMovie()))
        } catch (e: Exception) {
            if (e is SocketTimeoutException)
                emit(Resource.error("Something went wrong"))
        }
    }

    fun getMovieDetails(movieId: Int) = liveData(Dispatchers.IO) {
        emit(Resource.loading())
        try {
            emit(Resource.success(repository.getMovieDetails(movieId)))
        } catch (e: Exception) {
            if (e is SocketTimeoutException)
                emit(Resource.error("Something went wrong"))
        }
    }
}