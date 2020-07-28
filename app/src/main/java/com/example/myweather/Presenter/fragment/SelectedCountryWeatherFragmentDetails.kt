package com.example.myweather.Presenter.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.room.Room
import com.example.myweather.Data.API.ApiConnection
import com.example.myweather.Data.Country
import com.example.myweather.Data.Database.WeatherDatabase
import com.example.myweather.Data.WeatherClasses.WeatherClass
import com.example.myweather.Data.WeatherData
import com.example.myweather.Domain.Weather
import com.example.myweather.R
import kotlinx.android.synthetic.main.fragment_weather.*
import kotlinx.android.synthetic.main.fragment_weather_selected_country.*
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Response
import java.text.SimpleDateFormat
import java.util.*

class SelectedCountryWeatherFragmentDetails : Fragment() {

    var country : Country? = null
    val api = "13f94dabfe94f9c34b63bf7e17787055"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments.let {
            country = it?.getSerializable("SelectedCountryWeatherFragmentDetails") as Country?
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_weather_selected_country, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fragment_weather_selected_county_visibility.visibility = View.VISIBLE
        fragment_weather_selected_no_internet_connection.visibility = TextView.INVISIBLE


        fragment_weather_app_toolbar.setNavigationIcon(R.drawable.ic_baseline_arrow_back_24)
        fragment_weather_app_toolbar.setNavigationOnClickListener(View.OnClickListener { activity!!.onBackPressed() })

        var weatherDatabase = getDatabase()

        var temp = String.format("%s,%s", country?.cityName, country?.countryName);
        var connectionCheck = false

        var call = ApiConnection().initializeAPI().getWeather2(temp,"metric", api)

        call.enqueue(object : retrofit2.Callback<WeatherClass>{
            override fun onFailure(call: Call<WeatherClass>, t: Throwable) {
                Log.d("EpicFail", t.message.toString())
                initiateWeather()
            }

            override fun onResponse(call: Call<WeatherClass>, response: Response<WeatherClass>) {
                if(response.isSuccessful)
                {
                    Log.d("DATA", response.body().toString())

                    val updatedAt = response.body()?.dt
                    val tempMin = "Min Temp: " + response.body()?.main?.temp_min + "°C"
                    val tempMax = "Max Temp: " + response.body()?.main?.temp_max + "°C"
                    val temp = response.body()?.main?.temp.toString() + "°C"
                    val sunrise = response?.body()?.sys?.sunrise
                    val sunset = response?.body()?.sys?.sunset
                    val status_description = response?.body()!!.weather?.get(0)?.description
                    val windSpeed = response?.body()?.wind?.speed.toString()
                    val pressure = response?.body()?.main?.pressure.toString()
                    val humidity = response?.body()?.main?.humidity.toString() + "%"
                    val updatedAtText = "Updated at: "+ SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).format(Date(updatedAt as Long * 1000))

                    var weatrherData : WeatherData = WeatherData()
                    weatrherData.countryId = country!!.id
                    weatrherData.updatedAt = updatedAt
                    weatrherData.tempMin = tempMin
                    weatrherData.tempMax = tempMax
                    weatrherData.temp = temp
                    weatrherData.sunrise = sunrise!!
                    weatrherData.sunset = sunset!!
                    weatrherData.statuc_description = status_description!!
                    weatrherData.windSpeed = windSpeed
                    weatrherData.pressure = pressure
                    weatrherData.humidity = humidity

                    weatherDatabase.getWeatherDao().initiateInsertWeather(weatrherData)

                    fragment_weather_selected_county_address_text.setText(country?.cityName + " " + country?.countryName)
                    fragment_weather_selected_county_updated_at_text.setText(updatedAtText)
                    fragment_weather_selected_county_status_text.setText(status_description)
                    fragment_weather_selected_county_temp_text.setText(temp)
                    fragment_weather_selected_county_temp_min_text.setText(tempMin)
                    fragment_weather_selected_county_temp_max_text.setText(tempMax)
                    fragment_weather_selected_county_sunrise_text.setText(SimpleDateFormat("hh:mm", Locale.ENGLISH).format(Date((sunrise as Long)*9)))
                    fragment_weather_selected_county_sunset_text.setText(SimpleDateFormat("hh:mm", Locale.ENGLISH).format(Date((sunset as Long)*58)))
                    fragment_weather_selected_county_wind_text.setText(windSpeed)
                    fragment_weather_selected_county_pressure_text.setText(pressure)
                    fragment_weather_selected_county_humidity_text.setText(humidity)
                }
            }
        })
    }

    fun initiateWeather() {

        val weatherDatabase = getDatabase()
        val getLastWeatherId = weatherDatabase.getWeatherDao().initiateGetLastWeather(country!!.id)

        if (getLastWeatherId == 0) {
            fragment_weather_selected_county_visibility.visibility = View.INVISIBLE
            fragment_weather_selected_no_internet_connection.visibility = TextView.VISIBLE
            return
        }

        fragment_weather_selected_no_internet_connection.visibility = TextView.INVISIBLE

         var getWeatherInDB = weatherDatabase.getWeatherDao().getWeatherById(getLastWeatherId)

        val updatedAtText = "Updated at: " + SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)
            .format(Date(getWeatherInDB.updatedAt as Long * 1000))
        fragment_weather_selected_county_address_text.setText(country?.cityName + " " + country?.countryName)
        fragment_weather_selected_county_updated_at_text.setText(updatedAtText)
        fragment_weather_selected_county_status_text.setText(getWeatherInDB.statuc_description)
        fragment_weather_selected_county_temp_text.setText(getWeatherInDB.temp)
        fragment_weather_selected_county_temp_min_text.setText(getWeatherInDB.tempMin)
        fragment_weather_selected_county_temp_max_text.setText(getWeatherInDB.tempMax)
        fragment_weather_selected_county_sunrise_text.setText(
            SimpleDateFormat(
                "hh:mm",
                Locale.ENGLISH
            ).format(Date((getWeatherInDB.sunrise as Long) * 9))
        )
        fragment_weather_selected_county_sunset_text.setText(
            SimpleDateFormat(
                "hh:mm",
                Locale.ENGLISH
            ).format(Date((getWeatherInDB.sunset as Long) * 58))
        )
        fragment_weather_selected_county_wind_text.setText(getWeatherInDB.windSpeed)
        fragment_weather_selected_county_pressure_text.setText(getWeatherInDB.pressure)
        fragment_weather_selected_county_humidity_text.setText(getWeatherInDB.humidity)

    }

    fun getDatabase(): WeatherDatabase {
        var weatherDatabase = Room.databaseBuilder(
            context!!,
            WeatherDatabase::class.java,
            "WeatherDatabase")
            .allowMainThreadQueries()
            .build()

        return weatherDatabase
    }
}