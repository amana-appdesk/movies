package com.example.movieapp.network

import android.util.Log
import retrofit2.Response

abstract class RetrofitCallback {
    private val TAG = RetrofitCallback::class.java.simpleName

    suspend fun <T: Any> apiRequest(call : suspend() -> Response<T>): T {

        Log.e(TAG,"Api Request")
        val response = call.invoke()

        if (response.isSuccessful && response.body() != null) {
            Log.e(TAG,response.body().toString())
            return response.body()!!
        }
        else {
            Log.e(TAG,response.code().toString())
            Log.e(TAG,response.message())
            throw Exception(response.code().toString())
        }

    }

}