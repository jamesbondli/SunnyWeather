package com.example.sunnyweather

import android.widget.Toast
import java.time.Duration

fun String.showToast(duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(SunnyWeatherApplication.context, this, duration).show()
}