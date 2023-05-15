package com.netimur.kazdream.data

import com.netimur.kazdream.data.repository.Resource
import retrofit2.Response

interface ResponseHandler<T, R> {
    fun handleResponse(response: Response<T>): Resource<R>

    @Suppress("UNCHECKED_CAST")
    class Base<T, R> : ResponseHandler<T, R> {
        override fun handleResponse(response: Response<T>): Resource<R> {
            return if (response.isSuccessful) {
                if (response.body() == null) {
                    Resource.Error(errorMessage = "")
                } else {
                    Resource.Success(data = response.body())
                }
            } else {
                Resource.Error(errorMessage = response.errorBody().toString())
            }
                    as Resource<R>
        }
    }

}