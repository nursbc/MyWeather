package com.example.myweather.Presenter.fragment

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.example.myweather.Data.Country
import com.example.myweather.Data.Database.WeatherDatabase
import com.example.myweather.Presenter.adapter.WeatherAdapter
import com.example.myweather.Presenter.contract.WeatherFragmentContract
import com.example.myweather.Presenter.presenters.WeatherPresenter
import com.example.myweather.R
import kotlinx.android.synthetic.main.fragment_weather.*


@Suppress("UNREACHABLE_CODE")
class WeatherFragment : Fragment(), WeatherFragmentContract.View {

    var countryes : ArrayList<Country> = ArrayList()

    var weatherDatabase : WeatherDatabase? = null

    var adapter : WeatherAdapter? = null

    lateinit var presenter : WeatherPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        setHasOptionsMenu(true)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view: View = inflater.inflate(R.layout.fragment_weather, container, false)

        return view;
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initializeViews()
        initializePresenter()
        initializeLayoutManager()
        initializeAdapter()
        presenter.initializeData()

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater!!.inflate(R.menu.weather_app_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item!!.itemId
        if (id == R.id.weather_app_menu_add_country){
            val fragment = AddCountryFragment();
            val fragmentManager = fragmentManager
            fragmentManager?.beginTransaction()?.add(
                R.id.relativelayout_activity_weather_fragment_container,
                fragment, "AddCountryFragment")
                ?.hide(this)
                ?.addToBackStack(null)
                ?.commit()
        }

        return super.onOptionsItemSelected(item)
    }


    override fun initializePresenter() {

        presenter = WeatherPresenter()
        weatherDatabase?.let { presenter.attach(this, it) }
    }

    override fun initializeLayoutManager() {
        recyclerview_fragment_weather?.layoutManager = LinearLayoutManager(context)
    }

    override fun initializeAdapter() {
        adapter = WeatherAdapter(context, countryes)
        recyclerview_fragment_weather?.adapter = adapter
    }

    override fun initiateUpdateAdapter() {
        adapter?.notifyDataSetChanged()
    }


    override fun processData(counryes: ArrayList<Country>) {
        this.countryes.clear()
        this.countryes.addAll(counryes)
    }

    override fun initializeViews() {
        weatherDatabase = Room.databaseBuilder(
            context!!,
            WeatherDatabase::class.java,
            "WeatherDatabase")
            .allowMainThreadQueries()
            .build()
        recyclerview_fragment_weather?.visibility = View.VISIBLE

    }

    override fun initializeListeners() {
        TODO("Not yet implemented")
    }

    override fun initializeArguments() {
        TODO("Not yet implemented")
    }

    override fun initializeDependencies() {
        TODO("Not yet implemented")
    }

}