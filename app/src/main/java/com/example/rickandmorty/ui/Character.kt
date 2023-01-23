package com.example.rickandmorty.ui

import java.io.Serializable

data class Character (
    val id: String? = null,
    val title: String? = null,
    val description: String? = null,
    val status: String? = null,
    val origin: String? = null
): Serializable