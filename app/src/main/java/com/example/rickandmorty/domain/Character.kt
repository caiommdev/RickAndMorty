package com.example.rickandmorty.domain

import com.example.rickandmorty.data.Origin

data class Character(
    val id: Int? = null,
    val name: String? = null,
    val status: CharacterStatus? = null,
    val species: String? = null,
    val origin: Origin? = null
)

enum class CharacterStatus(
    val status: String? = null
){
    Alive("alive"),
    Dead("dead"),
    Unknown("unknown");

    companion object {
        fun toStatus(status: String?) =
            CharacterStatus.values()
                .first { it.status.equals(status, ignoreCase = true) }
    }
}