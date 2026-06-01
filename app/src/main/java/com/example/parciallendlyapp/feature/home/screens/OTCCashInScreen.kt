package com.example.parciallendlyapp.feature.home.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.parciallendlyapp.R
import com.example.parciallendlyapp.components.BackButton
import com.example.parciallendlyapp.components.OTCCashInItem
import com.example.parciallendlyapp.components.Title
import com.example.parciallendlyapp.componentsimport.SecondaryTopBar
import com.example.parciallendlyapp.feature.home.domain.model.OTCCashinList
import com.example.parciallendlyapp.ui.theme.BackgroundScreen
import com.example.parciallendlyapp.ui.theme.ContainerGray

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OTCCashInScreen(
    onBackClick: () -> Unit
) {
    Scaffold(
        containerColor = ContainerGray,
        topBar = {
            SecondaryTopBar(
                title = "",
                onBackClick = onBackClick,
                showInfoButton = false,
                onInfoClick = { /* Lógica de info */ }
            )
        }
    ) { innerPadding ->
        OTCCashInContent(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        )
    }
}

@Composable
fun OTCCashInContent(
    modifier: Modifier = Modifier
) {
    val otcOptions = OTCCashinList

    Column(
        modifier = modifier
            .padding(horizontal = 20.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Spacer(modifier = Modifier.height(24.dp))

        Title(text = stringResource(id = R.string.otc_cashin_title))

        Spacer(modifier = Modifier.height(24.dp))

        Surface(
            modifier = Modifier
                .width(361.dp)
                .wrapContentHeight(),
            color = BackgroundScreen,
            shape = RoundedCornerShape(12.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            ) {
                otcOptions.forEachIndexed { index, option ->
                    OTCCashInItem(
                        title = option.name,
                        subtitle = stringResource(id = R.string.otc_cashin_subtext) + option.maxAmount,
                        leadingIcon = option.logoRes,
                        onClick = { /* Lógica para seleccionar punto de pago */ }
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(24.dp))
    }
}