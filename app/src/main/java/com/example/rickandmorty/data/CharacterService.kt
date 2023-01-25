package com.example.rickandmorty.data

import com.example.rickandmorty.domain.Character

class CharacterService  {

    private val gateway: CharacterGateway by lazy {
        GatewayBuilder.build<CharacterGateway>()
    }

    suspend fun getAllCharacters(): List<Character> =
        gateway
            .getAllCharacters()
            .results
            .map { CharacterMapper.toDomain(it) }


    suspend fun getCharacter(id: Int): Character {
        return gateway
            .getCharacter(id)
            .let { CharacterMapper.toDomain(it) }
    }
}