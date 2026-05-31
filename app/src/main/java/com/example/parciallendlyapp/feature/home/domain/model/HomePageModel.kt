package com.example.parciallendlyapp.feature.home.domain.model

import androidx.annotation.DrawableRes

data class LoanModel(
    val name: String,
    val amount: String,
    val date: String,
    @DrawableRes val imageRes: Int
)

data class ProductModel(
    val name: String,
    val price: String,
    @DrawableRes val imageRes: Int
)