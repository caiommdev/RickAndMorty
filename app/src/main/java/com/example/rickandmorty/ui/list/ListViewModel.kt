package com.example.rickandmorty.ui.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.rickandmorty.data.CharacterService

class ListViewModel(
    val service: CharacterService
): ViewModel() {

    object Factory {
        fun build() =
            object : ViewModelProvider.Factory {
                override fun <T : ViewModel> create(modelClass: Class<T>): T {
                    return ListViewModel(
                        service = CharacterService()
                    ) as T
                }
            }

    }
}