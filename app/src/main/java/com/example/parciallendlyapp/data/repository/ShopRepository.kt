package com.example.parciallendlyapp.data.repository

import com.example.parciallendlyapp.data.network.ShopResponse
import com.example.parciallendlyapp.domain.Resource

interface ShopRepository {
    suspend fun getShopData(): Resource<ShopResponse>
}