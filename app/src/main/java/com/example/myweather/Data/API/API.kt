package com.example.myweather.Data.API

import com.example.myweather.Data.WeatherClasses.WeatherClass
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface API {

    @GET("weather")
    fun getWeather2(@Query("q") cityname : String, @Query("units") metric : String, @Query("appid") api : String) : Call<WeatherClass>
    

}