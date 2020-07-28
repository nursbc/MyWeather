package com.example.myweather.Data

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.myweather.Data.WeatherClasses.*

@Entity
class WeatherData {
    @PrimaryKey(autoGenerate = true)
    var id : Int = 0
    var countryId : Int= 0
    var updatedAt:Long = 0
    var tempMin = ""
    var tempMax = ""
    var temp = ""
    var sunrise:Long = 0
    var sunset:Long = 0
    var statuc_description = ""
    var windSpeed = ""
    var pressure = ""
    var humidity = ""

}