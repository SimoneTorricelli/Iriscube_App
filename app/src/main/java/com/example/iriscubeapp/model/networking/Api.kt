package com.example.iriscubeapp.model.networking

import retrofit2.http.GET
import retrofit2.http.Path
import sampleData

interface WebService {
    @GET("")
    suspend fun getBankAccount(@Path("id")id: Int): sampleData
}