package com.example.parciallendlyapp.data.repository

import com.example.parciallendlyapp.data.network.LendlyApiService
import com.example.parciallendlyapp.data.network.ShopResponse
import com.example.parciallendlyapp.domain.repository.ShopRepository
import javax.inject.Inject

class ShopRepositoryImpl @Inject constructor(
    private val apiService: LendlyApiService
) : ShopRepository {
    override suspend fun getShopData(): Result<ShopResponse> {
        return try {
            val response = apiService.getProducts()
            if (response.isSuccessful && response.body() != null) {
                Result.success(response.body()!!)
            } else {
                Result.failure(Exception("Error en API"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}