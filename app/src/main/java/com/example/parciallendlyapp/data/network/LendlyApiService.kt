package com.example.parciallendlyapp.data.network

import retrofit2.http.Path
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

// Define estos DTOs (puedes moverlos a archivos separados luego)
data class LoginRequest(val email: String, val password: String)
data class LoginResponse(val token: String)
data class UserResponse(val id: String, val name: String, val email: String)
data class LoanResponse(val id: String, val amount: Double, val status: String)
data class LoanRequest(val amount: Double, val term: Int)
data class TransactionResponse(val id: String, val date: String, val amount: Double)
data class ShopResponse(
    val success: Boolean,
    val featured: List<ProductDto>,
    val categories: List<CategoryDto>,
    val brands: List<BrandDto>,
    val products: List<ProductDto>
)

data class ProductDto(
    val id: String,
    val name: String,
    val brand: String,
    val price: Double,
    val currency: String,
    val image: String, // Ahora es String (URL)
    val monthlyInstallment: Double,
    val installmentMonths: Int
)

data class CategoryDto(
    val id: String,
    val name: String,
    val icon: String
)

data class BrandDto(
    val id: String,
    val name: String,
    val logo: String
)
interface LendlyApiService {
    @POST("/auth/login")
    suspend fun login(@Body request: LoginRequest): Response<LoginResponse>

    @POST("/auth/create")
    suspend fun register(@Body user: UserResponse): Response<Unit>

    @GET("/users/{id}")
    suspend fun getUserProfile(@Path("id") userId: String): Response<UserResponse>

    @GET("/loans")
    suspend fun getLoans(): Response<List<LoanResponse>>

    @POST("/loans/apply")
    suspend fun applyLoan(@Body loanData: LoanRequest): Response<Unit>

    @GET("/transactions")
    suspend fun getTransactions(): Response<List<TransactionResponse>>

    @GET("/products")
    suspend fun getProducts(): Response<ShopResponse>
}