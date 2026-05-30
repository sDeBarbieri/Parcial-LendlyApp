package com.example.parciallendlyapp.feature.home.screens

import androidx.compose.animation.core.copy
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.parciallendlyapp.components.Title
import com.example.parciallendlyapp.components.TopBar
import com.example.parciallendlyapp.R
import com.example.parciallendlyapp.components.CashInButton
import com.example.parciallendlyapp.components.SeeAllButton
import com.example.parciallendlyapp.components.Subtitle
import com.example.parciallendlyapp.ui.theme.ContainerGray

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

            // Título
            Title(text = stringResource(id = R.string.home_screen_title))

            Spacer(modifier = Modifier.height(16.dp)) // Espacio entre título y marco

            Surface(
                modifier = Modifier
                    .width(361.dp)  // Ancho exacto solicitado
                    .height(136.dp), // Alto exacto solicitado
                color = ContainerGray,
                shape = RoundedCornerShape(16.dp)
            ) {
                Column(
                    modifier = Modifier
                        .padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    // PARTE SUPERIOR: Texto pequeño y Botón
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = androidx.compose.ui.Alignment.CenterVertically
                    ) {
                        Text(
                            text = stringResource(id = R.string.home_balance),
                            style = androidx.compose.ui.text.TextStyle(
                                fontFamily = com.example.parciallendlyapp.ui.theme.Inter,
                                fontWeight = androidx.compose.ui.text.font.FontWeight.Medium,
                                fontSize = 12.sp,
                                lineHeight = 16.sp,
                                letterSpacing = 0.5.sp,
                                textAlign = androidx.compose.ui.text.style.TextAlign.Center
                            ),
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )

                        CashInButton(
                            text = stringResource(id = R.string.home_cashin_button),
                            iconResId = R.drawable.home_icon_add,
                            onClick = { /* Lógica de cash in */ }
                        )
                    }

                    // PARTE INFERIOR: Texto grande
                    Text(
                        text = stringResource(id = R.string.home_balance_number),
                        style = androidx.compose.ui.text.TextStyle(
                            fontFamily = com.example.parciallendlyapp.ui.theme.Montserrat,
                            fontWeight = androidx.compose.ui.text.font.FontWeight.SemiBold,
                            fontSize = 32.sp,
                            lineHeight = 40.sp,
                            letterSpacing = 0.sp
                        ),
                        color = MaterialTheme.colorScheme.onSurface
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Subtitle(title = stringResource(id = R.string.home_sutitle_1))
                SeeAllButton(onClick = {
                    /* Acción de navegación */
                })
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Acá va a estar la lista

        }
    }

}