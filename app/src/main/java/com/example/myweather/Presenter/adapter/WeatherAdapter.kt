package com.example.myweather.Presenter.adapter

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myweather.Data.Country
import com.example.myweather.Presenter.activity.MainActivity
import com.example.myweather.Presenter.fragment.SelectedCountryWeatherFragmentDetails
import com.example.myweather.Presenter.fragment.WeatherFragment
import com.example.myweather.Presenter.viewholder.WeatherHolder
import com.example.myweather.R

class WeatherAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder> {
    var context: Context? = null
    var weathers : List<Country>

    constructor(context: Context?, weathers: List<Country>){
        this.context = context
        this.weathers = weathers
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        var view = LayoutInflater.from(context).inflate(R.layout.viewholder_weather, parent, false)
        return WeatherHolder(view)
    }

    override fun getItemCount(): Int {
        return weathers.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as WeatherHolder).initiateBind(weathers.get(position))

        holder.itemView.setOnClickListener(View.OnClickListener {
            val bundle = Bundle()
            val fragment = SelectedCountryWeatherFragmentDetails()

            bundle.putSerializable("SelectedCountryWeatherFragmentDetails", weathers.get(position))
            fragment.setArguments(bundle)

            val fragmentManager: FragmentManager = (context as MainActivity).fragmentMenager
            fragmentManager?.beginTransaction()?.add(
                R.id.relativelayout_activity_weather_fragment_container,
                fragment, "SelectedCountryWeatherFragmentDetails"
            )
                ?.hide((context as MainActivity).fragmentMenager.findFragmentByTag("WeatherFragment") as WeatherFragment)
                ?.addToBackStack(null)
                ?.commit()
        })
    }
}