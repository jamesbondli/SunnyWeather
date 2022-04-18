package com.example.sunnyweather.logic.network

import com.example.sunnyweather.SunnyWeatherApplication
import com.example.sunnyweather.logic.model.PlaceResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface PlaceService {

    @GET("API+${SunnyWeatherApplication.TOKEN}")
    fun searchPlaces(@Query("query") query: String): Call<PlaceResponse>
}