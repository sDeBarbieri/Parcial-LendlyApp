package com.example.parciallendlyapp.feature.home.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.parciallendlyapp.R
import com.example.parciallendlyapp.components.BackButton
import com.example.parciallendlyapp.components.CashInOptionItem
import com.example.parciallendlyapp.components.InfoButton
import com.example.parciallendlyapp.components.Title
import com.example.parciallendlyapp.componentsimport.SecondaryTopBar
import com.example.parciallendlyapp.navigation.Routes
import com.example.parciallendlyapp.ui.theme.BackgroundScreen
import com.example.parciallendlyapp.ui.theme.ContainerGray

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CashInScreen(
    navController: NavHostController,
    onBackClick: () -> Unit
) {
    Scaffold(
        // Usamos el color de fondo gris que definimos para las pantallas secundarias
        containerColor = ContainerGray,
        topBar = {
            SecondaryTopBar(
                title = stringResource(id = R.string.cashin_topbar),
                onBackClick = onBackClick,
                showInfoButton = true,
                onInfoClick = { /* Lógica de info */ }
            )
        }
    ) { innerPadding ->
        CashInContent(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            navController = navController
        )
    }
}

@Composable
fun CashInContent(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    Column(
        modifier = modifier
            .padding(horizontal = 20.dp)
    ) {
        Spacer(modifier = Modifier.height(24.dp))

        Title(text = stringResource(id = R.string.cashin_title))

        Spacer(modifier = Modifier.height(32.dp))
        // Contenedor rectangular para los ítems
        Surface(
            modifier = Modifier
                .width(361.dp)
                .height(152.dp),
            color = BackgroundScreen,
            shape = androidx.compose.foundation.shape.RoundedCornerShape(12.dp)
        ) {
            Column {
                CashInOptionItem(
                    title = stringResource(id = R.string.cashin_option_1_title),
                    subtitle = stringResource(id = R.string.cashin_option_1_subtitle),
                    leadingIcon = R.drawable.home_account_balance_wallet,
                    onClick = { navController.navigate(Routes.ONLINE_CASH_IN) }
                )
                CashInOptionItem(
                    title = stringResource(id = R.string.cashin_option_2_title),
                    subtitle = stringResource(id = R.string.cashin_option_2_subtitle),
                    leadingIcon = R.drawable.home_location_on,
                    onClick = { navController.navigate(Routes.OTC_CASH_IN) }
                )
            }
        }
    }
}