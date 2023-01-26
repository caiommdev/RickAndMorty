package com.example.rickandmorty.data.character

import kotlinx.serialization.Serializable

@Serializable
data class ApiResponseForCharacter(
    val results: List<CharacterResponse>
)

@Serializable
data class CharacterResponse (
    val id: Int? = null,
    val name: String? = null,
    val status: String? = null,
    val species: String? = null,
    val origin: Origin? = null
)
@Serializable
data class Origin (
    val name: String? = null
)