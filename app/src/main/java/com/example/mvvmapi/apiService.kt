package com.example.mvvmapi

import com.example.mvvmapi.Market
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface apiService {
    @GET("https://www.cryptingup.com/api/markets")
    fun fetchData(): Call<Market>

    companion object {
        operator fun invoke(): apiService {
            return Retrofit.Builder()
                .baseUrl("https://www.cryptingup.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(apiService::class.java)
        }
    }
}