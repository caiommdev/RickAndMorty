package com.example.rickandmorty.ui.detail.character

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.rickandmorty.data.character.CharacterService
import com.example.rickandmorty.domain.Character
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CharacterDetailViewModel (
    val service: CharacterService
): ViewModel() {

    suspend fun getCharacter(id: Int): Character =
        withContext(Dispatchers.Default){
            service.getCharacter(id = id)
        }

    object Factory {
        fun build() =
            object : ViewModelProvider.Factory {
                override fun <T : ViewModel> create(modelClass: Class<T>): T {
                    return CharacterDetailViewModel(
                        service = CharacterService()
                    ) as T
                }
            }

    }
}