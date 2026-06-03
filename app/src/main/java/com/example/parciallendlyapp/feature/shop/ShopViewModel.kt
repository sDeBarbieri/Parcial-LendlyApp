package com.example.parciallendlyapp.feature.shop

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import com.example.parciallendlyapp.data.repository.ShopRepository
import com.example.parciallendlyapp.domain.Resource

import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.parciallendlyapp.data.network.ShopResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ShopViewModel @Inject constructor(
    private val repository: ShopRepository
) : ViewModel() {

    // Cambiamos el tipo simple por el Wrapper Resource
    var uiState by mutableStateOf<Resource<ShopResponse>>(Resource.Loading)
        private set

    init {
        fetchShopData()
    }

    fun fetchShopData() {
        viewModelScope.launch {
            uiState = Resource.Loading

            // Al ser Resource (sealed class), usamos when en lugar de onSuccess/onFailure
            val result = repository.getShopData()
            uiState = result
        }
    }
}