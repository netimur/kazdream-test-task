package com.netimur.kazdream.data.repository.reactive.weather

import com.netimur.kazdream.data.datasource.remote.WeatherRemoteDataSource
import kotlinx.coroutines.CoroutineDispatcher

class ReactiveWeatherManager(
    weatherRemoteDataSource: WeatherRemoteDataSource,
    coroutineDispatcher: CoroutineDispatcher
) : CurrentWeatherRepository by ReactiveCurrentWeatherRepository(
    weatherRemoteDataSource,
    coroutineDispatcher
), HourWeatherRepository by ReactiveHourWeatherRepository(
    weatherRemoteDataSource,
    coroutineDispatcher
)