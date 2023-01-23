package com.example.rickandmorty.data

import retrofit2.http.GET
import retrofit2.http.Path

interface CharacterGateway {

     @GET("character")
     suspend fun getAllCharacters(): Response

     @GET("character/{id}")
     suspend fun getCharacter(
          @Path("id") id: Int
     ): CharacterResponse
}