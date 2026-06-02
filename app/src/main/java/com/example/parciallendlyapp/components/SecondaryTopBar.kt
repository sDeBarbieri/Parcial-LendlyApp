package com.example.parciallendlyapp.components

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.example.parciallendlyapp.ui.theme.ContainerGray

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SecondaryTopBar(
    title: String,
    onBackClick: () -> Unit,
    showInfoButton: Boolean = false,
    onInfoClick: () -> Unit = {},
    containerColor: Color = ContainerGray
) {
    CenterAlignedTopAppBar(
        windowInsets = WindowInsets(0, 0, 0, 0), // Mantiene la barra arriba
        title = {
            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium
            )
        },
        navigationIcon = {
            BackButton(onClick = onBackClick)
        },
        actions = {
            if (showInfoButton) {
                InfoButton(onClick = onInfoClick)
            }
        },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = containerColor
        )
    )
}