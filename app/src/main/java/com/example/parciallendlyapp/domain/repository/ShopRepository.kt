package com.example.parciallendlyapp.domain.repository

import com.example.parciallendlyapp.data.network.ProductDto
import com.example.parciallendlyapp.data.network.ShopResponse

interface ShopRepository {
    suspend fun getShopData(): Result<ShopResponse>
}