package com.example.parciallendlyapp.feature.home.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.parciallendlyapp.components.Title
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
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 20.dp) // Margen estándar para la app
        ) {
            // Separación de la TopBar
            Spacer(modifier = Modifier.height(24.dp))

            // Llamamos a nuestro nuevo componente
            Title(text = "Account")

            // Aquí iría el resto del contenido de la Home
        }
    }

}