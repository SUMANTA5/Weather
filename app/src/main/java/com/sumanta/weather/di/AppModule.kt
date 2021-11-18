package com.sumanta.weather.di

import com.sumanta.weather.network.api.ApiService
import com.sumanta.weather.network.constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    fun providesBaseurl() : String = constants.BASE_URL

    @Provides
    @Singleton
    fun providesRetrofitInstance(Base_Url: String): ApiService =
        Retrofit.Builder()
            .baseUrl(Base_Url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
}