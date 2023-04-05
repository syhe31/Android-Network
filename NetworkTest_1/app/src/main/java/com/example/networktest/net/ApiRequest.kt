package com.example.networktest.net

import retrofit2.Response

object ApiRequest {

    suspend fun <T : Any> safeApiCall(call: suspend () -> Response<T>): Result<T> {
        try {
            val response = call.invoke()
            if (response.isSuccessful) {
                response.body()?.let {
                    return Result.Success(it)
                } ?: run {
                    return Result.Failure(Exception("No response received"))
                }
            } else {
                val error = response.errorBody()?.string()
                val message = if (error.isNullOrEmpty()) {
                    response.message()
                } else {
                    error
                }
                return Result.Failure(Exception(message))
            }
        } catch (e: Exception) {
            return Result.Failure(e)
        }
        return Result.Complete
    }


}