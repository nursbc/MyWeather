package com.example.myweather.Domain

import com.example.myweather.Data.WeatherClasses.*
import com.example.myweather.Data.WeatherClasses.Weather


class Weather {
    var clouds : Clouds? = null;
    var coord : Coord? = null
    var main : Main? = null
    var sys : Sys? = null
    var weather : List<Weather>? = null
    var wind : Wind? = null

}
