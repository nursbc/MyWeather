package com.example.myweather.Presenter.base

import com.example.myweather.Data.Database.WeatherDatabase

interface BaseContract {
    interface BaseView{

        fun initializeViews()

        fun initializeListeners()

        fun initializeArguments()

        fun initializeDependencies()
    }

    interface BasePresenter<T>{
        fun attach(view: T, database: WeatherDatabase)

        fun onStop()
    }
}