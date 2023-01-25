package com.example.rickandmorty.data

import com.example.rickandmorty.domain.Character
import com.example.rickandmorty.domain.CharacterStatus

object CharacterMapper {

    fun toDomain(response: CharacterResponse) =
       with(response){
            Character(
                id = id,
                name = name,
                status = CharacterStatus.toStatus(status)
            )
        }

}