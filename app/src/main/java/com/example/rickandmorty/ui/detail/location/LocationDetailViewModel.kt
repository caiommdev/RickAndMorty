package com.example.rickandmorty.ui.detail.location

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.rickandmorty.data.location.LocationService
import com.example.rickandmorty.domain.Location
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class LocationDetailViewModel (
    val service: LocationService
): ViewModel() {

    suspend fun getLocation(id: Int): Location =
        withContext(Dispatchers.Default){
            service.getLocation(id = id)
        }

    object Factory {
        fun build() =
            object : ViewModelProvider.Factory {
                override fun <T : ViewModel> create(modelClass: Class<T>): T {
                    return LocationDetailViewModel(
                        service = LocationService()
                    ) as T
                }
            }

    }
}