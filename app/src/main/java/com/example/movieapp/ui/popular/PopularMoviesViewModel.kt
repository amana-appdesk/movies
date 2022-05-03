package com.example.movieapp.ui.popular

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.movieapp.MovieRepository
import com.example.movieapp.network.Resource
import kotlinx.coroutines.Dispatchers
import java.net.SocketTimeoutException
import javax.inject.Inject

class PopularMoviesViewModel @Inject constructor(
    private val repository: MovieRepository
): ViewModel() {

    fun getPopularMovies() = liveData(Dispatchers.IO) {
        emit(Resource.loading())
        try {
            emit(Resource.success(repository.getPopularMovie()))
        }catch (e: Exception){
            if(e is SocketTimeoutException)
                emit(Resource.error("Something went wrong"))
        }
    }
}