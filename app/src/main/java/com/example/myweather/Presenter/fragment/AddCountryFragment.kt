package com.example.myweather.Presenter.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.room.Room
import com.example.myweather.Data.Country
import com.example.myweather.Data.Database.WeatherDatabase
import com.example.myweather.Presenter.contract.WeatherFragmentContract
import com.example.myweather.R
import kotlinx.android.synthetic.main.fragment_add_country.*
import kotlinx.android.synthetic.main.fragment_weather_selected_country.*
import kotlinx.android.synthetic.main.fragment_weather_selected_country.fragment_weather_app_toolbar

class AddCountryFragment : Fragment(), View.OnClickListener, WeatherFragmentContract.View {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_add_country, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fragment_weather_app_toolbar.setNavigationIcon(R.drawable.ic_baseline_arrow_back_24)
        fragment_weather_app_toolbar.setNavigationOnClickListener(View.OnClickListener { activity!!.onBackPressed() })
        initializeListeners()

    }

    override fun onClick(v: View?) {
        when(v?.id)
        {
            R.id.button_fragment_country_add_button -> {
                when {
                    edittext_fragment_country_add_city_name_text.text.toString().isEmpty() ->
                        edittext_fragment_country_add_city_name_text.setText("Write CityName")
                    edittext_fragment_country_add_country_code_text.text.toString().isEmpty() ->
                        edittext_fragment_country_add_country_code_text.setText("Write CountryCode")

                    else ->
                    {
                        var weatherDatabase = getDataBase()

                        val country = Country()

                        country.cityName = edittext_fragment_country_add_city_name_text.text.toString()
                        country.countryName = edittext_fragment_country_add_country_code_text.text.toString()

                        weatherDatabase.getWeatherDao().initiateInsertCountry(country)

                        val fragment =
                            fragmentManager?.findFragmentByTag("WeatherFragment") as WeatherFragment

                        fragment.presenter.initializeData()
                        fragment.initializeAdapter()

                        val fragmentManager = fragmentManager
                        fragmentManager?.popBackStack()
                    }
                }

            }
        }
    }

    fun getDataBase(): WeatherDatabase {
        var weatherDatabase = Room.databaseBuilder(
            context!!,
            WeatherDatabase::class.java,
            "WeatherDatabase")
            .allowMainThreadQueries()
            .build()

        return weatherDatabase
    }

    override fun initializePresenter() {
        TODO("Not yet implemented")
    }

    override fun initializeLayoutManager() {
        TODO("Not yet implemented")
    }

    override fun initializeAdapter() {
        TODO("Not yet implemented")
    }

    override fun initiateUpdateAdapter() {
        TODO("Not yet implemented")
    }

    override fun processData(weather: ArrayList<Country>) {
        TODO("Not yet implemented")
    }

    override fun initializeViews() {
        TODO("Not yet implemented")
    }

    override fun initializeListeners() {
        button_fragment_country_add_button.setOnClickListener(this)
    }

    override fun initializeArguments() {
        TODO("Not yet implemented")
    }

    override fun initializeDependencies() {
        TODO("Not yet implemented")
    }

}