package com.example.spendidly.models

import com.example.test.data.Budget

sealed class ResponseState {
    data class Success(val response: Budget) : ResponseState()

    sealed class Error : ResponseState() {
        data class NetworkError(val errorCode: Int): Error()
        object NoConnectivityError : Error()
    }

    object Unknown : ResponseState()
}