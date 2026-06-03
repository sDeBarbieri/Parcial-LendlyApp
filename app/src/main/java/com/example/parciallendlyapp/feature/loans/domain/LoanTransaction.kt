package com.example.parciallendlyapp.feature.loans.domain

/**
 * Modelo de datos para representar un préstamo en la pantalla de préstamos activos.
 */
data class LoanTransaction(
    val id: Int,
    val iconResId: Int,
    val title: String,
    val subtitle: String,
    val rightTitle: String?,
    val rightSubtitle: String
)
