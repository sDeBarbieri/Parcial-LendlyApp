
package com.example.parciallendlyapp.feature.shop.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import com.example.parciallendlyapp.R
import com.example.parciallendlyapp.components.SecondaryTopBar
import com.example.parciallendlyapp.ui.theme.ContainerGray

@Composable
fun SearchScreen(
    navController: NavHostController,
    onBackClick: () -> Unit
) {
    Scaffold(
        containerColor = ContainerGray,
        topBar = {
            SecondaryTopBar(
                title = stringResource(id = R.string.shop_search_title),
                onBackClick = onBackClick,
                showInfoButton = false,
                onInfoClick = { /* Lógica de info */ }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            // Contenido de búsqueda
        }
    }
}