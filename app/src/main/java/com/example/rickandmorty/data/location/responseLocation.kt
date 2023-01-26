package com.example.rickandmorty.data.location

import kotlinx.serialization.Serializable

@Serializable
data class ApiResponseForLocation(
    val results: List<LocationResponse>
)

@Serializable
data class LocationResponse (
    val id: Int? = null,
    val name: String? = null,
    val type: String? = null,
    val dimension: String? = null
)
