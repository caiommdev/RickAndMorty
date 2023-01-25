package com.example.rickandmorty.data

class CharacterService  {

    private val gateway: CharacterGateway by lazy {
        GatewayBuilder.build<CharacterGateway>()
    }

    suspend fun getAllCharacters(): List<CharacterResponse> {
        return gateway
            .getAllCharacters()
            .results
    }

    suspend fun getCharacter(id: Int): CharacterResponse {
        return gateway
            .getCharacter(id)
    }
}