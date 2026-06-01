package com.example.parciallendlyapp.componentsimport

import androidx.compose.foundation.layout.WindowInsets
import com.example.parciallendlyapp.components.BackButton
import com.example.parciallendlyapp.components.InfoButton
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
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
