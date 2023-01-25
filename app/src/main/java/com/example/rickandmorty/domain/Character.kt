package com.example.rickandmorty.domain

data class Character(
    val id: Int? = null,
    val name: String? = null,
    val status: CharacterStatus? = null
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