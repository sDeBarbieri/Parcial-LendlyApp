package com.example.parciallendlyapp.data.network

import okhttp3.Interceptor
import okhttp3.Response // Asegúrate de que sea este import

class AuthInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()
            .addHeader("x-api-key", "123456789")
            .build()
        return chain.proceed(request)
    }
}