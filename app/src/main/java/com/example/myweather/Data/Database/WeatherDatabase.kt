package com.example.myweather.Data.Database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.myweather.Data.Country
import com.example.myweather.Data.WeatherData

@Database(entities = arrayOf(Country::class, WeatherData::class), version = 3)
abstract class WeatherDatabase : RoomDatabase() {

abstract fun getWeatherDao() : WeatherDao

}