package com.netimur.kazdream.data.repository

sealed class Resource<T>(val data: T? = null, val errorMessage: String? = null) {
    class Success<T>(data: T?) : Resource<T>(data)
    class Error<T>(data: T? = null, errorMessage: String?) :
        Resource<T>(errorMessage = errorMessage)
}