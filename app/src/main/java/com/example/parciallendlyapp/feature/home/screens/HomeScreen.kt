package com.example.parciallendlyapp.feature.home.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.parciallendlyapp.components.TopBar

@Composable
fun HomeScreen() {
    // Scaffold nos permite estructurar la pantalla con la TopBar
    Scaffold(
        topBar = {
            TopBar(
                onNotificationClick = { /* Acción */ },
                onProfileClick = { /* Acción */ }
            )
        }

    ) { innerPadding ->
        // El contenido de la pantalla debe ir dentro de Box o Column
        // usando el innerPadding para que la TopBar no lo tape.
        Box(modifier = Modifier.padding(innerPadding)) {
            Text("Contenido de HomeScreen")
        }
    }
}