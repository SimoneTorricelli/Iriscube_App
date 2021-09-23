package com.example.iriscubeapp.model.networking

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

object Repository {
    private var client = RetrofitClient.retrofit

    suspend fun getBankAccount() = withContext(Dispatchers.IO) {
        try {
            client.getBankAccount(id = 1)
        } catch (cause: Throwable) {
            throw TodoException("Unable to retrieve todo", cause)
        }
    }
}