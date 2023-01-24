package com.example.rickandmorty.data

import kotlinx.serialization.Serializable

@Serializable
data class ApiResponse(
    val results: List<CharacterResponse>
)

@Serializable
data class CharacterResponse (
    val id: Int? = null,
    val name: String? = null
)