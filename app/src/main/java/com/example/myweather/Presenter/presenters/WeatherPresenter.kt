package com.example.myweather.Presenter.presenters

import android.util.Log
import androidx.room.Room
import com.example.myweather.Data.Country
import com.example.myweather.Data.Database.WeatherDatabase
import com.example.myweather.Presenter.contract.WeatherFragmentContract

class WeatherPresenter : WeatherFragmentContract.Presenter {

    var view : WeatherFragmentContract.View? = null

    var weatherDatabase : WeatherDatabase? = null

    var countryes : ArrayList<Country> = ArrayList()

    override fun initializeData() {

/*
        weatherDatabase?.getWeatherDao()?.initiateInsertCountry(Country().apply {
            countryName = "kz"
            cityName = "almaty"
        })
*/

        countryes.clear()
        countryes.addAll(weatherDatabase?.getWeatherDao()?.initiateGetAllCountry() as ArrayList<Country>)

        view?.processData(countryes)
        view?.initiateUpdateAdapter()
    }

    override fun initiateAddNewCountry(country: Country) {
        countryes.add(country)
        view?.processData(countryes)
        view?.initiateUpdateAdapter()

    }

    override fun attach(view: WeatherFragmentContract.View, database: WeatherDatabase) {
        this.view = view
        this.weatherDatabase = database
    }

    override fun onStop() {
        this.view = null
    }
}