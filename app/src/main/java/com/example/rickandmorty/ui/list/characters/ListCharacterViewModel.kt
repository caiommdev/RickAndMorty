package com.example.rickandmorty.ui.list.characters

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.rickandmorty.data.character.CharacterService
import com.example.rickandmorty.domain.Character
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ListCharacterViewModel(
    val service: CharacterService
): ViewModel() {

    suspend fun getCharacters(): List<Character> =
        withContext(Dispatchers.Default) {
            service.getAllCharacters()
        }

    object Factory {
        fun build() =
            object : ViewModelProvider.Factory {
                override fun <T : ViewModel> create(modelClass: Class<T>): T {
                    return ListCharacterViewModel(
                        service = CharacterService()
                    ) as T
                }
            }

    }
}