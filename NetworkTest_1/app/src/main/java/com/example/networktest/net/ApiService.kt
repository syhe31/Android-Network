package com.example.networktest.net

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("/todos/{userId}")
    suspend fun getUser(@Path("userId") userId: String): Response<User>

}
