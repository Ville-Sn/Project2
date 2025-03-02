package com.example.project2.network

import com.example.project2.mvvm.model.Activities

import retrofit2.http.GET

interface ApiService {
    @GET("worldState.php")
    suspend fun getActivities(): Activities
}