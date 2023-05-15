package com.netimur.kazdream.data.repository.standard.weather

import com.netimur.kazdream.data.datasource.remote.WeatherRemoteDataSource
import com.netimur.kazdream.data.repository.standard.coodinates.BaseCoordinatesRepository
import com.netimur.kazdream.data.repository.standard.coodinates.CoordinatesRepository
import kotlinx.coroutines.CoroutineDispatcher

abstract class AbstractWeatherRepository(
    protected val weatherRemoteDataSource: WeatherRemoteDataSource,
    protected val coroutineDispatcher: CoroutineDispatcher
) {
    protected val coordinatesRepository: CoordinatesRepository =
        BaseCoordinatesRepository(weatherRemoteDataSource, coroutineDispatcher)
}