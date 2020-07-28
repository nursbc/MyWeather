package com.example.myweather.Presenter.viewholder

import android.content.Context
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myweather.Data.Country
import com.example.myweather.R

class WeatherHolder (itemview : View) : RecyclerView.ViewHolder(itemview) {

/*    var context : Context? = null
    var address : String? = null
    var update_at : String? = null
    var status : String? = null
    var temp : String? = null
    var temp_min : String? = null
    var temp_max : String? = null
    var sunrise : String? = null
    var sunset : String? = null
    var pressure : String? = null
    var humidity : String? = null*/

    var context : Context? = null
    var city : TextView? = null
    var country : TextView? = null
    var id : TextView? = null

    init {
        initiateViews()
    }

    fun initiateViews()
    {
        id = itemView.findViewById(R.id.textview_viewholder_id_text)
        city = itemView.findViewById(R.id.textview_viewholder_city_text)
        country = itemView.findViewById(R.id.textview_viewholder_country_text)
    }

    fun initiateBind(testCountry: Country)
    {
        id?.setText(testCountry.id.toString())
        city?.setText(testCountry.cityName)
        country?.setText(testCountry.countryName)
    }

}