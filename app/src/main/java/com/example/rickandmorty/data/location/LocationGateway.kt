package com.example.rickandmorty.data.location

import retrofit2.http.GET
import retrofit2.http.Path

interface LocationGateway {
    @GET("location")
    suspend fun getAllLocations(): ApiResponseForLocation

    @GET("location/{id}")
    suspend fun getLocation(
        @Path("id") id: Int
    ): LocationResponse
}