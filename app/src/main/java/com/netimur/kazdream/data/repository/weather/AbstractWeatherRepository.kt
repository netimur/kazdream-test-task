package com.netimur.kazdream.data.repository.weather

import com.netimur.kazdream.data.datasource.remote.WeatherRemoteDataSource
import com.netimur.kazdream.data.repository.coodinates.CoordinatesRepository
import kotlinx.coroutines.CoroutineDispatcher

abstract class AbstractWeatherRepository(
    protected val weatherRemoteDataSource: WeatherRemoteDataSource,
    protected val coroutineDispatcher: CoroutineDispatcher
) {
    protected val coordinatesRepository: CoordinatesRepository =
        BaseCoordinatesRepository(weatherRemoteDataSource, coroutineDispatcher)
}