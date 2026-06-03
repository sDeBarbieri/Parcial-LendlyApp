package com.example.parciallendlyapp.feature.history.domain

/**
 * Modelo de datos para representar una transacción en la pantalla de historial.
 */
data class HistoryTransaction(
    val id: Int,
    val iconResId: Int,
    val time: String,
    val description: String,
    val company: String?,
    val amount: String
)
