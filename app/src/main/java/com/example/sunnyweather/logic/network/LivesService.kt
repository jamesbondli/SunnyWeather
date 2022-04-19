package com.example.sunnyweather.logic.network

import com.example.sunnyweather.SunnyWeatherApplication
import com.example.sunnyweather.logic.model.LiveResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface LivesService {

    @GET("v3/weather/weatherInfo?key=${SunnyWeatherApplication.KEY}&extensions=base&output=JSON")
    fun searchPlaces(@Query("city") city: String): Call<LiveResponse>
}