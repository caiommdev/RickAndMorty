package com.example.rickandmorty.data.character

import com.example.rickandmorty.data.GatewayBuilder
import com.example.rickandmorty.domain.Character
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CharacterService  {

    private val gateway: CharacterGateway by lazy {
        GatewayBuilder.build<CharacterGateway>()
    }

    suspend fun getAllCharacters(): List<Character> =
        withContext(Dispatchers.IO) {
            gateway
                .getAllCharacters()
                .results
                .map { CharacterMapper.toDomain(it) }
        }



    suspend fun getCharacter(id: Int): Character =
        withContext(Dispatchers.IO) {
             gateway
                .getCharacter(id)
                .let { CharacterMapper.toDomain(it) }
        }

}