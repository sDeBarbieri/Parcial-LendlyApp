package com.example.parciallendlyapp.feature.shop

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.parciallendlyapp.data.network.ShopResponse
import com.example.parciallendlyapp.domain.repository.ShopRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ShopViewModel @Inject constructor(
    private val repository: ShopRepository
) : ViewModel() {

    var shopData by mutableStateOf<ShopResponse?>(null)
        private set

    init {
        viewModelScope.launch {
            repository.getShopData().onSuccess {
                shopData = it
            }
        }
    }
}
