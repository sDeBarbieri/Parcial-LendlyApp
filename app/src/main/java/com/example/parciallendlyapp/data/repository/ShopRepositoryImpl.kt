package com.example.parciallendlyapp.data.repository

import com.example.parciallendlyapp.data.network.LendlyApiService
import com.example.parciallendlyapp.data.network.ShopResponse
import com.example.parciallendlyapp.domain.Resource
import com.example.parciallendlyapp.data.repository.ShopRepository
import java.io.IOException
import javax.inject.Inject

class ShopRepositoryImpl @Inject constructor(
    private val apiService: LendlyApiService
) : ShopRepository {
    override suspend fun getShopData(): Resource<ShopResponse> {
        return try {
            val response = apiService.getProducts()
            if (response.isSuccessful) {
                response.body()?.let {
                    Resource.Success(it)
                } ?: Resource.Error("Cuerpo de respuesta vacío")
            } else {
                // Mapeo de errores HTTP (401 Unauthorized, 404, 500)
                Resource.Error("Error del servidor: ${response.code()}")
            }
        } catch (e: IOException) {
            Resource.Error("Sin conexión a internet. Revisa tu red.")
        } catch (e: Exception) {
            Resource.Error("Error inesperado: ${e.localizedMessage}")
        }
    }

}