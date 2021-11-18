package com.sumanta.weather.network.api

import com.sumanta.weather.model.Weather
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("weather/London")
   suspend fun getWeather():Response<Weather>


}