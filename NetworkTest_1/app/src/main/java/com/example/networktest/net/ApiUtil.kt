package com.example.networktest.net

import retrofit2.Response

object ApiUtil {

    private val apiInterface = RetrofitClient.getRetrofitInstance().create(ApiService::class.java)

    suspend fun getUser(userId: String): Response<User> {
        return apiInterface.getUser(userId)
    }
}