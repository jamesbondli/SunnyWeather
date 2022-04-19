package com.example.sunnyweather.logic

import androidx.lifecycle.liveData
import com.example.sunnyweather.logic.model.Lives
import com.example.sunnyweather.logic.network.SunnyWeatherNetWork
import kotlinx.coroutines.Dispatchers
import java.lang.Exception
import java.lang.RuntimeException

object Repository {

    fun searchPlaces(city: String) = liveData(Dispatchers.IO) {
        val result = try {
            val livesResponse = SunnyWeatherNetWork.searchPlaces(city)
            if (livesResponse.status == "1") {
                val lives = livesResponse.lives
                Result.success(lives)
            } else {
                Result.failure(RuntimeException("response status is ${livesResponse.status}"))
            }
        } catch (e: Exception) {
            Result.failure<List<Lives>>(e)
        }
        emit(result)
    }
}