package com.sumanta.weather.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sumanta.weather.model.Weather
import com.sumanta.weather.repo.WeatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel
@Inject
constructor(private val weatherRepository: WeatherRepository) : ViewModel() {

    private val resp = MutableLiveData<Weather>()
    val weatherResp : LiveData<Weather>
    get() = resp

    init {
        getWeather()
    }

    private fun getWeather() = viewModelScope.launch {
        weatherRepository.getWeather().let { response ->
           if (response.isSuccessful){
               resp.postValue(response.body())
           }else{
               Log.d("getWeather error", response.message())
           }
        }
    }


}