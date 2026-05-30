package com.example.parciallendlyapp.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.parciallendlyapp.R
import com.example.parciallendlyapp.ui.theme.ContentPrimary
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    onNotificationClick: () -> Unit = {},
    onProfileClick: () -> Unit = {}
) {
    CenterAlignedTopAppBar(
        // 1. IZQUIERDA: Foto de perfil / Avatar
        navigationIcon = {
            IconButton(onClick = onProfileClick) {
                Box(
                    modifier = Modifier
                        .offset(x = 4.dp, y = (-4).dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.share_avatar),
                        contentDescription = "Profile",
                        modifier = Modifier
                            .size(width = 17.dp, height = 15.5.dp),
                        tint = MaterialTheme.colorScheme.onBackground
                    )
                }
            }
        },

        // 2. CENTRO: El Logo
        title = {
            Image(
                painter = painterResource(id = R.drawable.share_icon),
                contentDescription = "Lendly Logo",
                modifier = Modifier
                    .size(45.dp)
                    .offset(y = (-5).dp)
            )
        },

        // 3. DERECHA: Notificaciones
        actions = {
            IconButton(onClick = onNotificationClick) {
                Box(
                    modifier = Modifier
                        .offset(x = 1.dp, y = (-4).dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.share_notifications),
                        contentDescription = "Notifications",
                        modifier = Modifier
                            .size(width = 15.dp, height = 19.2.dp),
                        tint = MaterialTheme.colorScheme.onBackground
                    )
                }
            }
        },

        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.background
        )
    )
}