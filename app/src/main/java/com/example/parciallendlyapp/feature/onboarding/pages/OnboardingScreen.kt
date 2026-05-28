package com.example.parciallendlyapp.feature.onboarding.pages

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun OnboardingScreen(onFinish: () -> Unit) {
    Button(onClick = onFinish) {
        Text("OnboardingScreen")
    }
}