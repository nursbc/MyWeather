package com.example.myweather.Data.Database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.myweather.Data.Country
import com.example.myweather.Data.WeatherData

@Dao
interface WeatherDao {

    @Query("SELECT * FROM country")
    fun initiateGetAllCountry() : List<Country>

    @Query("SELECT * FROM country WHERE countryName IS :country AND cityName IS :city")
    fun initiateGetCountryByName(city : String, country : String) : Country

    @Insert
    fun initiateInsertCountry(country : Country)

    @Insert
    fun initiateInsertWeather(weather : WeatherData)

    @Query("SELECT MAX(w.id) FROM weatherdata w WHERE :id = w.countryId")
    fun initiateGetLastWeather(id : Int) : Int

    @Query("SELECT * FROM weatherdata WHERE id is :id")
    fun getWeatherById(id : Int) : WeatherData

    @Query("SELECT * FROM weatherdata WHERE countryId is :id")
    fun getAllWeatherByCountryId(id : Int) : List<WeatherData>
}