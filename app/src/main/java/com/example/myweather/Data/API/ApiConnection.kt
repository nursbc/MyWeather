package com.example.myweather.Data.API

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiConnection {
    lateinit var retrofit : Retrofit

    constructor()
    {
        initializeRetrofit()
    }


    fun initializeRetrofit()
    {
        retrofit = Retrofit.Builder()
            .baseUrl(ApiConstants.baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }


    fun initializeAPI(): API{
        return retrofit.create(API::class.java)
    }
}