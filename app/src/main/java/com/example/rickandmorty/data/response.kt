package com.example.rickandmorty.data

import kotlinx.serialization.Serializable

@Serializable
data class Response( //guarda a lista
    val results: List<CharacterResponse>
)

@Serializable
data class CharacterResponse ( // guarda o item da resposta
    val id: Int? = null,
    val name: String? = null
)