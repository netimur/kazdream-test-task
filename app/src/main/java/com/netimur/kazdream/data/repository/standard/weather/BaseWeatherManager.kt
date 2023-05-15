package com.netimur.kazdream.data.repository.standard.weather

import com.netimur.kazdream.data.datasource.remote.WeatherRemoteDataSource
import kotlinx.coroutines.CoroutineDispatcher

class BaseWeatherManager(
    weatherRemoteDataSource: WeatherRemoteDataSource,
    coroutineDispatcher: CoroutineDispatcher
) : HourWeatherRepository by BaseHourWeatherRepository(
    weatherRemoteDataSource,
    coroutineDispatcher
),
    CurrentWeatherRepository by BaseCurrentWeatherRepository(
        weatherRemoteDataSource,
        coroutineDispatcher
    )