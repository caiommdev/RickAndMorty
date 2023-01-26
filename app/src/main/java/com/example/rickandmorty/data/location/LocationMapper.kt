package com.example.rickandmorty.data.location

import com.example.rickandmorty.domain.Location

object LocationMapper {

    fun toDomain(response: LocationResponse) =
        with(response) {
            Location(
                id = id,
                name = name,
                type = type,
                dimension = dimension
            )
        }
}