package com.netimur.kazdream.data

import com.netimur.kazdream.data.model.hourweather.HourWeatherDataServerModel
import com.netimur.kazdream.data.model.hourweather.HourWeatherServerModel
import com.netimur.kazdream.data.repository.Resource
import retrofit2.Response

class HourWeatherResponseHandler :
    ResponseHandler<HourWeatherServerModel, List<HourWeatherDataServerModel>> {

    override fun handleResponse(response: Response<HourWeatherServerModel>): Resource<List<HourWeatherDataServerModel>> {

        return if (response.isSuccessful) {
            if (response.body() == null) {
                Resource.Error(errorMessage = "")
            } else {
                Resource.Success(data = response.body()!!.list)
            }
        } else {
            Resource.Error(errorMessage = response.errorBody().toString())
        }
    }
}