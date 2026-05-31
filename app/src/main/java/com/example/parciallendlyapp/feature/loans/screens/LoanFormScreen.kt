package com.example.parciallendlyapp.feature.loans.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.parciallendlyapp.components.*
import com.example.parciallendlyapp.ui.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoanFormScreen(
    onBackClick: () -> Unit = {},
    onInfoClick: () -> Unit = {},
    onGetLoanClick: () -> Unit = {}
) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "Loan",
                        style = TextStyle(
                            fontFamily = Inter,
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 16.sp,
                            color = ContentPrimary
                        )
                    )
                },
                navigationIcon = {
                    BackButton(onClick = onBackClick)
                },
                actions = {
                    InfoButton(onClick = onInfoClick)
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.background
                )
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            Column(
                modifier = Modifier
                    .padding(horizontal = 24.dp, vertical = 16.dp)
            ) {
                Title(
                    text = "Please provide your details for your loan",
                    modifier = Modifier.fillMaxWidth()
                )
                
                Spacer(modifier = Modifier.height(8.dp))
                
                Text(
                    text = "Please provide your details for your loan",
                    style = TextStyle(
                        fontFamily = Inter,
                        fontWeight = FontWeight.Normal,
                        fontSize = 14.sp,
                        lineHeight = 20.sp,
                        color = ContentTertiary
                    )
                )

                Spacer(modifier = Modifier.height(32.dp))

                // Step 1
                StepLabel(text = "Step 1")
                Spacer(modifier = Modifier.height(12.dp))
                Text(
                    text = "Enter loan amount",
                    style = TextStyle(
                        fontFamily = Inter,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 14.sp,
                        color = SolidDark
                    )
                )
                Spacer(modifier = Modifier.height(24.dp))
                Text(
                    text = "₱2,000.00",
                    modifier = Modifier.fillMaxWidth(),
                    style = TextStyle(
                        fontFamily = Inter,
                        fontWeight = FontWeight.Bold,
                        fontSize = 32.sp,
                        textAlign = TextAlign.Center,
                        color = SolidDark
                    )
                )
                Spacer(modifier = Modifier.height(16.dp))
                HorizontalDivider(color = BorderNeutral, thickness = 1.dp)

                Spacer(modifier = Modifier.height(32.dp))

                // Step 2
                StepLabel(text = "Step 2")
                Spacer(modifier = Modifier.height(12.dp))
                Text(
                    text = "Select an installment plan",
                    style = TextStyle(
                        fontFamily = Inter,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 14.sp,
                        color = SolidDark
                    )
                )
                Spacer(modifier = Modifier.height(16.dp))
                InstallmentPlanCard()

                Spacer(modifier = Modifier.height(32.dp))

                // Step 3
                StepLabel(text = "Step 3")
                Spacer(modifier = Modifier.height(12.dp))
                Text(
                    text = "Select your loan purpose",
                    style = TextStyle(
                        fontFamily = Inter,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 14.sp,
                        color = SolidDark
                    )
                )
                Spacer(modifier = Modifier.height(16.dp))
                PurposeSelector(purpose = "Educational")
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Summary Section
            SummarySection()

            Column(
                modifier = Modifier
                    .padding(24.dp)
                    .fillMaxWidth()
            ) {
                LendlyButton(
                    text = "Get This Loan",
                    onClick = onGetLoanClick
                )
            }
            
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Composable
fun InstallmentPlanCard() {
    Surface(
        modifier = Modifier
            .fillMaxWidth(),
        color = Color.Transparent,
        shape = RoundedCornerShape(8.dp),
        border = androidx.compose.foundation.BorderStroke(1.dp, InteractiveAccent)
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(
                    text = "6 Months",
                    style = TextStyle(
                        fontFamily = Inter,
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp,
                        color = SolidDark
                    )
                )
                Text(
                    text = "2.99% Interest",
                    style = TextStyle(
                        fontFamily = Inter,
                        fontWeight = FontWeight.Medium,
                        fontSize = 12.sp,
                        color = ContentTertiary
                    )
                )
            }
            Text(
                text = "₱ 982.12/mo",
                style = TextStyle(
                    fontFamily = Inter,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 16.sp,
                    color = SolidDark
                )
            )
        }
    }
}

@Composable
fun PurposeSelector(purpose: String) {
    Surface(
        modifier = Modifier
            .fillMaxWidth(),
        color = Color.Transparent,
        shape = RoundedCornerShape(8.dp),
        border = androidx.compose.foundation.BorderStroke(1.dp, BorderNeutral)
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = purpose,
                style = TextStyle(
                    fontFamily = Inter,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 16.sp,
                    color = SolidDark
                )
            )
            Icon(
                imageVector = Icons.Default.KeyboardArrowDown,
                contentDescription = null,
                tint = ContentSecondary,
                modifier = Modifier.size(24.dp)
            )
        }
    }
}

@Composable
fun SummarySection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(ContainerGray)
    ) {
        // Light green line at the top
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(4.dp)
                .background(BackgroundNeutral)
        )
        
        Column(
            modifier = Modifier
                .padding(24.dp)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                text = "Summary",
                style = TextStyle(
                    fontFamily = Inter,
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp,
                    color = SolidDark
                )
            )
            
            SummaryRow(label = "Loan Amount", value = "PHP 2,000.00")
            SummaryRow(label = "3% Processing Fee", value = "-150.00")
            
            HorizontalDivider(color = BorderNeutral, thickness = 1.dp)
            
            SummaryRow(
                label = "Total amount to Receive", 
                value = "₱ 2,000.00", 
                valueFontWeight = FontWeight.Bold,
                valueFontSize = 18.sp
            )
            
            SummaryRow(label = "Lender", value = "null")
            
            Text(
                text = "What is this?",
                style = TextStyle(
                    fontFamily = Inter,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 14.sp,
                    color = ContentPrimary,
                    textDecoration = TextDecoration.Underline
                )
            )
        }
    }
}

@Composable
fun SummaryRow(
    label: String, 
    value: String, 
    valueFontWeight: FontWeight = FontWeight.Medium,
    valueFontSize: androidx.compose.ui.unit.TextUnit = 14.sp
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = label,
            style = TextStyle(
                fontFamily = Inter,
                fontWeight = FontWeight.Medium,
                fontSize = 14.sp,
                color = ContentTertiary
            )
        )
        Text(
            text = value,
            style = TextStyle(
                fontFamily = Inter,
                fontWeight = valueFontWeight,
                fontSize = valueFontSize,
                color = SolidDark
            )
        )
    }
}
