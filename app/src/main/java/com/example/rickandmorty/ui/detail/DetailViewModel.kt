package com.example.rickandmorty.ui.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.rickandmorty.data.CharacterService
import com.example.rickandmorty.domain.Character
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class DetailViewModel (
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
                    return DetailViewModel(
                        service = CharacterService()
                    ) as T
                }
            }

    }
}