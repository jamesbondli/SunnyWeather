package com.example.sunnyweather.logic.model

import com.google.gson.annotations.SerializedName

data class LiveResponse(
    val status: String,
    val count: String,
    val info: String,
    @SerializedName("infocode") val infoCode: String,
    val lives: List<Lives>
)

data class Lives(
    val province: String,
    val city: String,
    @SerializedName("adcode") val adCode: String,
    val weather: String,
    val temperature: String,
    @SerializedName("winddirection") val windDirection: String,
    @SerializedName("windpower") val windPower: String,
    val humidity: String,
    @SerializedName("reporttime") val reportTime: String
)