package com.example.parciallendlyapp.feature.loans.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.parciallendlyapp.components.InfoContainerProminent

@Composable
fun LoanScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        InfoContainerProminent(
            title = "Safe and sound",
            description = "All here, in one place. Your data is protected."
        )
    }
}
