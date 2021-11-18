package com.sumanta.weather.repo

import com.sumanta.weather.network.api.ApiService
import javax.inject.Inject

class WeatherRepository
@Inject
constructor(private val apiService: ApiService) {

    suspend fun getWeather() = apiService.getWeather()

}