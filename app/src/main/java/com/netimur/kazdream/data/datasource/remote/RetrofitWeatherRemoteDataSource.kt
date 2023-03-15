package com.netimur.kazdream.data.datasource.remote

import com.netimur.kazdream.data.ProvideOkHttpClientBuilder
import com.netimur.kazdream.common.Constants
import com.netimur.kazdream.data.ProvideInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitWeatherRemoteDataSource {
    private lateinit var service: WeatherRemoteDataSource

    fun getService(): WeatherRemoteDataSource {

        if (!this::service.isInitialized) {
            val httpClientBuilder = ProvideOkHttpClientBuilder.Base(ProvideInterceptor.Debug())
            val httpClient = httpClientBuilder.httpClientBuilder().build()
            val retrofit: Retrofit = Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .client(httpClient)
                .addConverterFactory(GsonConverterFactory.create()).build()
            service = retrofit.create(WeatherRemoteDataSource::class.java)
        }
        return service
    }


}