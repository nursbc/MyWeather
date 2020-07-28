package com.example.myweather.Presenter.contract

import android.content.Context
import com.example.myweather.Data.Country
import com.example.myweather.Presenter.base.BaseContract

class WeatherFragmentContract {
    interface View : BaseContract.BaseView{
        fun initializePresenter()

        fun initializeLayoutManager()

        fun initializeAdapter()

        fun initiateUpdateAdapter()

        fun processData(weather: ArrayList<Country>)

    }

    interface Presenter : BaseContract.BasePresenter<View>{
        fun initializeData()

        fun initiateAddNewCountry(country : Country)
    }
}