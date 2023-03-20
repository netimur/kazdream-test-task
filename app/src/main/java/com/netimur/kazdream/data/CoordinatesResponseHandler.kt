package com.netimur.kazdream.data

import com.netimur.kazdream.data.model.coordinates.Coordinates
import com.netimur.kazdream.data.model.coordinates.CoordinatesServerModel
import com.netimur.kazdream.data.repository.Resource
import retrofit2.Response

class CoordinatesResponseHandler:ResponseHandler<List<CoordinatesServerModel>, Coordinates> {
    override fun handleResponse(response: Response<List<CoordinatesServerModel>>): Resource<Coordinates> {
        return if (response.isSuccessful) {
            val responseBody = response.body()!!
            if (responseBody.isEmpty()) {
                Resource.Error(errorMessage = "Coordinates error")
            } else {
                Resource.Success(
                    Coordinates(
                        responseBody[0].longitude,
                        responseBody[0].latitude
                    )
                )
            }
        } else {
            Resource.Error(errorMessage = "Coordinates error")
        }
    }
}