package com.example.parciallendlyapp.feature.home.domain.model

import androidx.annotation.DrawableRes
import com.example.parciallendlyapp.R

data class OnlineCashinModel(
    val name: String,
    val maxAmount: String,
    @DrawableRes val logoRes: Int
)

val onlineCashinBanksList = listOf(
    OnlineCashinModel("BPI", "", R.drawable.home_logo_bpi),
    OnlineCashinModel("Chinabank", "", R.drawable.home_logo_chinabank),
    OnlineCashinModel("RCBC", "", R.drawable.home_logo_rcbc),
    OnlineCashinModel("Unionbank", "", R.drawable.home_logo_unionbank)
)

val onlineCashinWalletsList = listOf(
    OnlineCashinModel("G-Cash", "", R.drawable.home_logo_gcash),
    OnlineCashinModel("Pay Maya", "", R.drawable.home_logo_pay_maya),
    OnlineCashinModel("PayPal", "", R.drawable.home_logo_paypal)
)