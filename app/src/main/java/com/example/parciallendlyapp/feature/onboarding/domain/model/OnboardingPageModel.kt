package com.example.parciallendlyapp.feature.onboarding.domain.model

import androidx.annotation.DrawableRes

data class OnboardingPageModel(
    val title: String,
    val description: String,
    @param:DrawableRes val imageRes: Int
)