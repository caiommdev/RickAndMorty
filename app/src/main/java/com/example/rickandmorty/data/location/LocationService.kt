package com.example.rickandmorty.data.location

import com.example.rickandmorty.data.GatewayBuilder
import com.example.rickandmorty.domain.Location
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class LocationService {
    private val gateway by lazy {
        GatewayBuilder.build<LocationGateway>()
    }

    suspend fun getAllLocations(): List<Location> =
        withContext(Dispatchers.IO){
            gateway
                .getAllLocations()
                .results
                .map { LocationMapper.toDomain(it) }
        }

    suspend fun getLocation(id: Int): Location =
        gateway
            .getLocation(id)
            .let { LocationMapper.toDomain(it) }
}