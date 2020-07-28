package com.example.myweather.Data

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity
class Country : Serializable {

    @PrimaryKey(autoGenerate = true)
    var id: Int = 0

    var cityName : String = ""

    var countryName : String = ""

    override fun toString(): String {
        return "${cityName.toString()},${countryName.toString()}"
    }


}