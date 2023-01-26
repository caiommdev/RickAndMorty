package com.example.rickandmorty.ui.list.locations

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.rickandmorty.data.location.LocationService
import com.example.rickandmorty.domain.Location
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ListLocationViewModel (
    val service: LocationService
): ViewModel() {

    suspend fun getLocations(): List<Location> =
        withContext(Dispatchers.Default) {
            service.getAllLocations()
        }

    object Factory {
        fun build() =
            object : ViewModelProvider.Factory {
                override fun <T : ViewModel> create(modelClass: Class<T>): T {
                    return ListLocationViewModel(
                        service = LocationService()
                    ) as T
                }
            }

    }
}