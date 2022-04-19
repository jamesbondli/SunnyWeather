package com.example.sunnyweather.ui.place

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.sunnyweather.logic.Repository
import com.example.sunnyweather.logic.model.Lives

class PlaceViewModel : ViewModel() {
    private val searchLiveData = MutableLiveData<String>()

    val livesList = ArrayList<Lives>()

    val livesLiveData = Transformations.switchMap(searchLiveData) { city ->
        Repository.searchPlaces(city)
    }

    fun searchPlaces(city: String) {
        searchLiveData.value = city
    }
}