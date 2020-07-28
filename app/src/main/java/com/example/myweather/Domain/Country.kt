package com.example.myweather.Domain


class Country {
    var id: Int = 0

    var cityName : String = ""
    var countryName : String = ""


    override fun toString(): String {
        return "${cityName.toString()},${countryName.toString()}"
    }
}