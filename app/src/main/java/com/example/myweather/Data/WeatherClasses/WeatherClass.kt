package com.example.myweather.Data.WeatherClasses

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class WeatherClass {

	@SerializedName("coord")
	@Expose
	val coord: Coord? = null
	@SerializedName("weather")
	val weather: List<Weather>? = null
	@SerializedName("base")
	val base: String? = null
	@SerializedName("main")
	val main: Main? = null
	@SerializedName("visibility")
	val visibility: Int? = null
	@SerializedName("wind")
	val wind: Wind? = null
	@SerializedName("clouds")
	val clouds: Clouds? = null
	@SerializedName("dt")
	val dt: Long? = null
	@SerializedName("sys")
	val sys: Sys? = null
	@SerializedName("timezone")
	val timezone: Int? = null
	@SerializedName("id")
	val id: Int? = null
	@SerializedName("name")
	val name: String? = null
	@SerializedName("cod")
	val cod: Int? = null
}

/*
class WeatherClass {

	@SerializedName("coord")
	@Expose
	var coord: Coord? = null
	@SerializedName("weather")
	@Expose
	var weather: List<Weather>?= ArrayList()
	@SerializedName("base")
	@Expose
	var base: String ?= null
	@SerializedName("main")
	@Expose
	var main: Main?= null
	@SerializedName("visibility")
	@Expose
	var visibility: Int ?= null
	@SerializedName("wind")
	@Expose
	var wind: Wind?= null
	@SerializedName("clouds")
	@Expose
	var clouds: Clouds?= null
	@SerializedName("dt")
	@Expose
	var dt: Int ?= null
	@SerializedName("sys")
	@Expose
	var sys: Sys?= null
	@SerializedName("timezone")
	@Expose
	var timezone: Int ?= null
	@SerializedName("id")
	@Expose
	var id: Int ?= null
	@SerializedName("name")
	@Expose
	var name: String ?= null
	@SerializedName("cod")
	@Expose
	var cod: Int ?= null

	inner class Clouds {
		@SerializedName("all")
		@Expose
		var all: Int? = null

	}

	inner class Coord {
		@SerializedName("lon")
		@Expose
		var lon: Double? = null

		@SerializedName("lat")
		@Expose
		var lat: Double? = null

	}

	inner class Main {
		@SerializedName("temp")
		@Expose
		var temp: Int? = null

		@SerializedName("feels_like")
		@Expose
		var feelsLike: Double? = null

		@SerializedName("temp_min")
		@Expose
		var tempMin: Int? = null

		@SerializedName("temp_max")
		@Expose
		var tempMax: Int? = null

		@SerializedName("pressure")
		@Expose
		var pressure: Int? = null

		@SerializedName("humidity")
		@Expose
		var humidity: Int? = null

		override fun toString(): String {
			return "Main(temp=$temp, feelsLike=$feelsLike, tempMin=$tempMin, tempMax=$tempMax, pressure=$pressure, humidity=$humidity)"
		}


	}

	inner class Sys {
		@SerializedName("type")
		@Expose
		var type: Int? = null

		@SerializedName("id")
		@Expose
		var id: Int? = null

		@SerializedName("country")
		@Expose
		var country: String? = null

		@SerializedName("sunrise")
		@Expose
		var sunrise: Int? = null

		@SerializedName("sunset")
		@Expose
		var sunset: Int? = null

	}

	inner class Weather {
		@SerializedName("coord")
		@Expose
		var coord: Coord? = null

		@SerializedName("weather")
		@Expose
		var weather: List<Weather_>? = ArrayList()

		@SerializedName("base")
		@Expose
		var base: String? = null

		@SerializedName("main")
		@Expose
		var main: Main? = null

		@SerializedName("visibility")
		@Expose
		var visibility: Int? = null

		@SerializedName("wind")
		@Expose
		var wind: Wind? = null

		@SerializedName("clouds")
		@Expose
		var clouds: Clouds? = null

		@SerializedName("dt")
		@Expose
		var dt: Int? = null

		@SerializedName("sys")
		@Expose
		var sys: Sys? = null

		@SerializedName("timezone")
		@Expose
		var timezone: Int? = null

		@SerializedName("id")
		@Expose
		var id: Int? = null

		@SerializedName("name")
		@Expose
		var name: String? = null

		@SerializedName("cod")
		@Expose
		var cod: Int? = null

	}

	inner class Weather_ {
		@SerializedName("id")
		@Expose
		var id: Int? = null

		@SerializedName("main")
		@Expose
		var main: String? = null

		@SerializedName("description")
		@Expose
		var description: String? = null

		@SerializedName("icon")
		@Expose
		var icon: String? = null

	}

	inner class Wind {
		@SerializedName("speed")
		@Expose
		var speed: Int? = null

		@SerializedName("deg")
		@Expose
		var deg: Int? = null

	}

}*/
