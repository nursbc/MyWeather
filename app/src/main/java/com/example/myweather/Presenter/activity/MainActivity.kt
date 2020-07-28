@file:Suppress("UNREACHABLE_CODE")

package com.example.myweather.Presenter.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.myweather.Presenter.fragment.WeatherFragment
import com.example.myweather.R

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {

    var currentFragment: Fragment? = null
    lateinit var fragmentMenager : FragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initializeFragmentManager()
        initializeDefaultFragment()
    }

    fun initializeFragmentManager(){
        fragmentMenager = supportFragmentManager
    }

    fun initializeDefaultFragment(){
        if(currentFragment==null){
            currentFragment = WeatherFragment()

            fragmentMenager.beginTransaction()
                .add(R.id.relativelayout_activity_weather_fragment_container, currentFragment!!,"WeatherFragment")
                .commit()
        }
    }


}