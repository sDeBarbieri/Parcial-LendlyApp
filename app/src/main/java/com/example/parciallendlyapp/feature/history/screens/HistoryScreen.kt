package com.example.parciallendlyapp.feature.history.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.parciallendlyapp.R
import com.example.parciallendlyapp.components.FilterChipComponent
import com.example.parciallendlyapp.components.ItemRow
import com.example.parciallendlyapp.components.Title
import com.example.parciallendlyapp.components.TopBar
import com.example.parciallendlyapp.ui.theme.ContentTertiary
import com.example.parciallendlyapp.ui.theme.Inter

@Composable
fun HistoryScreen(
    onTransactionClick: () -> Unit = {}
) {
    Scaffold(
        topBar = {
            TopBar(
                onNotificationClick = { /* TODO */ },
                onProfileClick = { /* TODO */ }
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
                Title(text = "History")
                Spacer(modifier = Modifier.height(16.dp))

                // Search Input
                OutlinedTextField(
                    value = "",
                    onValueChange = {},
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp),
                    placeholder = {
                        Text(
                            "Search...",
                            style = TextStyle(
                                fontFamily = Inter,
                                fontSize = 16.sp,
                                color = ContentTertiary
                            )
                        )
                    },
                    leadingIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.share_search),
                            contentDescription = null,
                            tint = ContentTertiary
                        )
                    },
                    shape = RoundedCornerShape(12.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        unfocusedBorderColor = Color(0x1F0E0F0C),
                        focusedBorderColor = Color(0x1F0E0F0C)
                    ),
                    singleLine = true
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Filters
                val filters = listOf("All", "Type", "Balance", "Paid Bills", "Added")
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    items(filters) { filter ->
                        FilterChipComponent(
                            text = filter,
                            isSelected = filter == "All"
                        )
                    }
                }
                
                Spacer(modifier = Modifier.height(16.dp))
            }

            HorizontalDivider(color = Color(0xFFF0F0F0), thickness = 1.dp)

            Column(modifier = Modifier.padding(horizontal = 16.dp)) {
                Spacer(modifier = Modifier.height(24.dp))

                // Today Section
                SectionHeader(title = "Today")
                Spacer(modifier = Modifier.height(8.dp))
                ItemRow(
                    iconResId = R.drawable.share_arrow_upward,
                    time = "9:07 AM",
                    description = "Paid this month",
                    company = "Apple Inc.",
                    amount = "1,2555 PHP",
                    onClick = onTransactionClick
                )
                ItemRow(
                    iconResId = R.drawable.share_arrow_upward,
                    time = "9:07 AM",
                    description = "Paid this month",
                    company = "Apple Inc.",
                    amount = "1,2555 PHP",
                    onClick = onTransactionClick
                )
                ItemRow(
                    iconResId = R.drawable.share_arrow_upward,
                    time = "9:07 AM",
                    description = "Paid this month",
                    company = "Apple Inc.",
                    amount = "1,2555 PHP",
                    onClick = onTransactionClick
                )
                ItemRow(
                    iconResId = R.drawable.share_add,
                    time = "9:07 AM",
                    description = "Added",
                    company = null,
                    amount = "1,200 PHP",
                    onClick = onTransactionClick
                )
                ItemRow(
                    iconResId = R.drawable.share_add,
                    time = "9:07 AM",
                    description = "Paid this month",
                    company = null,
                    amount = "1,200 PHP",
                    onClick = onTransactionClick
                )

                Spacer(modifier = Modifier.height(32.dp))

                // Recent Loans Section
                SectionHeader(title = "Recent Loans")
                Spacer(modifier = Modifier.height(16.dp))
                ItemRow(
                    iconResId = R.drawable.share_check,
                    time = "02/08/2024",
                    description = "iPhone 15 Pro Max",
                    company = "Apple Inc.",
                    amount = "Paid",
                    onClick = onTransactionClick
                )
                ItemRow(
                    iconResId = R.drawable.share_check,
                    time = "02/08/2024",
                    description = "iPhone 15 Pro Max",
                    company = "Apple Inc.",
                    amount = "Paid",
                    onClick = onTransactionClick
                )
                ItemRow(
                    iconResId = R.drawable.share_check,
                    time = "02/08/2024",
                    description = "iPhone 15 Pro Max",
                    company = "Apple Inc.",
                    amount = "Paid",
                    onClick = onTransactionClick
                )
                
                Spacer(modifier = Modifier.height(32.dp))
            }
        }
    }
}

@Composable
fun SectionHeader(title: String) {
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
