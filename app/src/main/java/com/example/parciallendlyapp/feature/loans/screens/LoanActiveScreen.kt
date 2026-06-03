package com.example.parciallendlyapp.feature.loans.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import com.example.parciallendlyapp.feature.loans.domain.LoanTransaction
import com.example.parciallendlyapp.ui.theme.ContentTertiary
import com.example.parciallendlyapp.ui.theme.Inter

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoanActiveScreen(
    onBackClick: () -> Unit = {}
) {
    // Datos de ejemplo para la sección Present
    val presentLoans = listOf(
        LoanTransaction(
            id = 1,
            iconResId = R.drawable.shop_logo_apple,
            title = stringResource(R.string.history_item_apple),
            subtitle = stringResource(R.string.history_item_iphone_15),
            rightTitle = stringResource(R.string.loan_active_fees_february),
            rightSubtitle = stringResource(R.string.history_item_amount_12555)
        ),
        LoanTransaction(
            id = 2,
            iconResId = R.drawable.shop_logo_apple,
            title = stringResource(R.string.history_item_apple),
            subtitle = stringResource(R.string.history_item_iphone_15),
            rightTitle = stringResource(R.string.loan_active_fees_february),
            rightSubtitle = stringResource(R.string.history_item_amount_12555)
        ),
        LoanTransaction(
            id = 3,
            iconResId = R.drawable.shop_logo_apple,
            title = stringResource(R.string.history_item_apple),
            subtitle = stringResource(R.string.history_item_iphone_15),
            rightTitle = stringResource(R.string.loan_active_fees_february),
            rightSubtitle = stringResource(R.string.history_item_amount_12555)
        )
    )

    // Datos de ejemplo para la sección Recent Loans
    val recentLoans = listOf(
        LoanTransaction(
            id = 4,
            iconResId = R.drawable.share_check,
            title = stringResource(R.string.history_item_date_recent),
            subtitle = stringResource(R.string.history_item_iphone_15),
            rightTitle = stringResource(R.string.history_item_apple),
            rightSubtitle = stringResource(R.string.history_item_paid)
        ),
        LoanTransaction(
            id = 5,
            iconResId = R.drawable.share_check,
            title = stringResource(R.string.history_item_date_recent),
            subtitle = stringResource(R.string.history_item_iphone_15),
            rightTitle = stringResource(R.string.history_item_apple),
            rightSubtitle = stringResource(R.string.history_item_paid)
        ),
        LoanTransaction(
            id = 6,
            iconResId = R.drawable.share_check,
            title = stringResource(R.string.history_item_date_recent),
            subtitle = stringResource(R.string.history_item_iphone_15),
            rightTitle = stringResource(R.string.history_item_apple),
            rightSubtitle = stringResource(R.string.history_item_paid)
        )
    )

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
        LazyColumn(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            item {
                Column(modifier = Modifier.padding(horizontal = 16.dp)) {
                    Spacer(modifier = Modifier.height(16.dp))
                    Title(text = stringResource(R.string.loan_active_title))
                    Spacer(modifier = Modifier.height(24.dp))
                }
            }

            // Sección "Present"
            item {
                Box(modifier = Modifier.padding(horizontal = 16.dp)) {
                    SectionHeader(title = stringResource(R.string.loan_active_present))
                }
                Spacer(modifier = Modifier.height(8.dp))
            }

            items(presentLoans) { loan ->
                Box(modifier = Modifier.padding(horizontal = 16.dp)) {
                    ItemRow(
                        iconResId = loan.iconResId,
                        time = loan.title,
                        description = loan.subtitle,
                        company = loan.rightTitle,
                        amount = loan.rightSubtitle,
                        onClick = { /* Ir a detalle */ }
                    )
                }
            }

            item {
                Spacer(modifier = Modifier.height(32.dp))
            }

            // Sección "Recent Loans"
            item {
                Box(modifier = Modifier.padding(horizontal = 16.dp)) {
                    SectionHeader(title = stringResource(R.string.history_section_recent_loans))
                }
                Spacer(modifier = Modifier.height(16.dp))
            }

            items(recentLoans) { loan ->
                Box(modifier = Modifier.padding(horizontal = 16.dp)) {
                    ItemRow(
                        iconResId = loan.iconResId,
                        time = loan.title,
                        description = loan.subtitle,
                        company = loan.rightTitle,
                        amount = loan.rightSubtitle,
                        onClick = { /* Ir a detalle */ }
                    )
                }
            }

            item {
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
