package com.example.parciallendlyapp.feature.loans.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.parciallendlyapp.R
import com.example.parciallendlyapp.components.*

@Composable
fun LoanScreen(
    onGetLoanClick: () -> Unit = {}
) {
    Scaffold(
        topBar = {
            TopBar(
                onNotificationClick = { /* Acción */ },
                onProfileClick = { /* Acción */ }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .padding(horizontal = 16.dp)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Spacer(modifier = Modifier.height(16.dp))

            InfoContainerProminent(
                title = "Safe and secure loans",
                description = "All here in Rayland"
            )

            InfoContainer()

            Subtitle(title = "How it works")

            // Cuadrícula de tarjetas
            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    CardContent(
                        imageResId = R.drawable.loan_how_it_works_1,
                        title = "Keep your credit score high",
                        description = "The offered loan amount is based on your credit score",
                        modifier = Modifier.weight(1f)
                    )
                    CardContent(
                        imageResId = R.drawable.loan_how_it_works_2,
                        title = "Get instant approval",
                        description = "Everything we need to process is already in the application",
                        modifier = Modifier.weight(1f)
                    )
                }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    CardContent(
                        imageResId = R.drawable.loan_how_it_works_3,
                        title = "Easy payments option available",
                        description = "Skip the queue and pay your due on the application",
                        modifier = Modifier.weight(1f)
                    )
                    CardContent(
                        imageResId = R.drawable.loan_how_it_works_4,
                        title = "Safe and secure",
                        description = "Rayland is working with trusted partners to provide this services",
                        modifier = Modifier.weight(1f)
                    )
                }
            }

            LendlyButton(
                text = "Get This Loan",
                onClick = onGetLoanClick
            )

            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}
