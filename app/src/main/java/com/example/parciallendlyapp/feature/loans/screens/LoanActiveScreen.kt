package com.example.parciallendlyapp.feature.loans.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.parciallendlyapp.R
import com.example.parciallendlyapp.components.BackButton
import com.example.parciallendlyapp.components.ItemRow
import com.example.parciallendlyapp.components.Title
import com.example.parciallendlyapp.ui.theme.ContentTertiary
import com.example.parciallendlyapp.ui.theme.Inter

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoanActiveScreen(
    onBackClick: () -> Unit = {}
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {},
                navigationIcon = {
                    BackButton(onClick = onBackClick)
                },
                actions = {
                    IconButton(onClick = { /* Acción del calendario */ }) {
                        Icon(
                            painter = painterResource(id = R.drawable.share_event),
                            contentDescription = "Calendar",
                            modifier = Modifier.size(24.dp),
                            tint = Color.Unspecified
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.background
                )
            )
        },
        containerColor = MaterialTheme.colorScheme.background
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            Column(modifier = Modifier.padding(horizontal = 16.dp)) {
                Spacer(modifier = Modifier.height(16.dp))
                Title(text = stringResource(R.string.loan_active_title))
                Spacer(modifier = Modifier.height(24.dp))

                // Sección "Present"
                SectionHeader(title = stringResource(R.string.loan_active_present))
                Spacer(modifier = Modifier.height(8.dp))

                // Lista de préstamos activos (según el diseño hay 3 repetidos)
                repeat(3) {
                    ItemRow(
                        iconResId = R.drawable.shop_logo_apple,
                        time = stringResource(R.string.history_item_apple), // "Apple Inc." arriba a la izquierda
                        description = stringResource(R.string.history_item_iphone_15), // "iPhone 15 Pro Max" abajo a la izquierda
                        company = stringResource(R.string.loan_active_fees_february), // "Fees of february" arriba a la derecha
                        amount = stringResource(R.string.history_item_amount_12555), // "1,2555 PHP" abajo a la derecha
                        onClick = { /* Ir a detalle */ }
                    )
                }

                Spacer(modifier = Modifier.height(32.dp))

                // Sección "Recent Loans"
                SectionHeader(title = stringResource(R.string.history_section_recent_loans))
                Spacer(modifier = Modifier.height(16.dp))

                repeat(3) {
                    ItemRow(
                        iconResId = R.drawable.share_check,
                        time = stringResource(R.string.history_item_date_recent), // "02/08/2024" arriba a la izquierda
                        description = stringResource(R.string.history_item_iphone_15), // "iPhone 15 Pro Max" abajo a la izquierda
                        company = stringResource(R.string.history_item_apple), // "Apple Inc." arriba a la derecha
                        amount = stringResource(R.string.history_item_paid), // "Paid" abajo a la derecha
                        onClick = { /* Ir a detalle */ }
                    )
                }

                Spacer(modifier = Modifier.height(32.dp))
            }
        }
    }
}

@Composable
private fun SectionHeader(title: String) {
    Column {
        Text(
            text = title,
            style = TextStyle(
                fontFamily = Inter,
                fontWeight = FontWeight.Normal,
                fontSize = 14.sp,
                color = ContentTertiary
            )
        )
        Spacer(modifier = Modifier.height(8.dp))
        HorizontalDivider(color = Color(0xFFF0F0F0), thickness = 1.dp)
    }
}