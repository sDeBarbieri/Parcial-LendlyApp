package com.example.parciallendlyapp.feature.home.domain.model

import androidx.annotation.DrawableRes
import com.example.parciallendlyapp.R

data class OTCCashinModel(
    val name: String,
    val maxAmount: String,
    @DrawableRes val logoRes: Int
)

val OTCCashinList = listOf(
    OTCCashinModel("7-Eleven", "$5,000", R.drawable.home_logo_7eleven),
    OTCCashinModel("Cebuana Lhuillier", "$5,000", R.drawable.home_logo_cebuana_lhullier),
    OTCCashinModel("LBC", "$5,000", R.drawable.home_logo_lbc),
    OTCCashinModel("M Lhuillier", "$5,000", R.drawable.home_logo_m_lhuillier)
)