package com.example.rickandmorty.data.character

import com.example.rickandmorty.data.character.ApiResponseForCharacter
import com.example.rickandmorty.data.character.CharacterResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface CharacterGateway {

     @GET("character")
     suspend fun getAllCharacters(): ApiResponseForCharacter

     @GET("character/{id}")
     suspend fun getCharacter(
          @Path("id") id: Int
     ): CharacterResponse
}