package com.example.parciallendlyapp.feature.history.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.parciallendlyapp.R
import com.example.parciallendlyapp.components.Title
import com.example.parciallendlyapp.components.TopBar
import com.example.parciallendlyapp.ui.theme.ContentSecondary
import com.example.parciallendlyapp.ui.theme.ContentTertiary
import com.example.parciallendlyapp.ui.theme.InteractiveAccent
import com.example.parciallendlyapp.ui.theme.Inter

@Composable
fun HistoryScreen() {
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
                .padding(horizontal = 16.dp)
        ) {
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
                    unfocusedBorderColor = Color(0x1F0E0F0C), // BorderNeutral if available, using 0x1F0E0F0C from Color.kt
                    focusedBorderColor = Color(0x1F0E0F0C)
                ),
                singleLine = true
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Filters
            val filters = listOf("All", "Type", "Balance", "Paid Bills", "Added")
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(filters) { filter ->
                    FilterChipComponent(
                        text = filter,
                        isSelected = filter == "All"
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Today Section
            SectionHeader(title = "Today")
            Spacer(modifier = Modifier.height(8.dp))
            HistoryItemRow(
                iconResId = R.drawable.share_arrow_upward,
                time = "9:07 AM",
                description = "Paid this month",
                company = "Apple Inc.",
                amount = "1,2555 PHP"
            )
            HistoryItemRow(
                iconResId = R.drawable.share_arrow_upward,
                time = "9:07 AM",
                description = "Paid this month",
                company = "Apple Inc.",
                amount = "1,2555 PHP"
            )
            HistoryItemRow(
                iconResId = R.drawable.share_arrow_upward,
                time = "9:07 AM",
                description = "Paid this month",
                company = "Apple Inc.",
                amount = "1,2555 PHP"
            )
            HistoryItemRow(
                iconResId = R.drawable.home_icon_add,
                time = "9:07 AM",
                description = "Added",
                company = null,
                amount = "1,200 PHP"
            )
            HistoryItemRow(
                iconResId = R.drawable.home_icon_add,
                time = "9:07 AM",
                description = "Paid this month",
                company = null,
                amount = "1,200 PHP"
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Recent Loans Section
            SectionHeader(title = "Recent Loans")
            Spacer(modifier = Modifier.height(8.dp))
            HistoryItemRow(
                iconResId = R.drawable.share_check,
                time = "02/08/2024",
                description = "iPhone 15 Pro Max",
                company = "Apple Inc.",
                amount = "Paid"
            )
            HistoryItemRow(
                iconResId = R.drawable.share_check,
                time = "02/08/2024",
                description = "iPhone 15 Pro Max",
                company = "Apple Inc.",
                amount = "Paid"
            )
            HistoryItemRow(
                iconResId = R.drawable.share_check,
                time = "02/08/2024",
                description = "iPhone 15 Pro Max",
                company = "Apple Inc.",
                amount = "Paid"
            )
            
            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}

@Composable
fun FilterChipComponent(text: String, isSelected: Boolean) {
    Box(
        modifier = Modifier
            .background(
                color = if (isSelected) InteractiveAccent else Color.Transparent,
                shape = RoundedCornerShape(8.dp)
            )
            .border(
                width = 1.dp,
                color = if (isSelected) InteractiveAccent else Color(0x1F0E0F0C),
                shape = RoundedCornerShape(8.dp)
            )
            .padding(horizontal = 16.dp, vertical = 8.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            style = TextStyle(
                fontFamily = Inter,
                fontWeight = FontWeight.Medium,
                fontSize = 14.sp,
                color = if (isSelected) Color.Black else ContentSecondary
            )
        )
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

@Composable
fun HistoryItemRow(
    iconResId: Int,
    time: String,
    description: String,
    company: String?,
    amount: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(40.dp)
                .background(Color(0xFFFDF7F7), CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = painterResource(id = iconResId),
                contentDescription = null,
                modifier = Modifier.size(20.dp),
                tint = Color.Unspecified
            )
        }
        
        Spacer(modifier = Modifier.width(16.dp))
        
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = time,
                style = TextStyle(
                    fontFamily = Inter,
                    fontSize = 10.sp,
                    color = ContentTertiary
                )
            )
            Text(
                text = description,
                style = TextStyle(
                    fontFamily = Inter,
                    fontWeight = FontWeight.Medium,
                    fontSize = 14.sp,
                    color = Color.Black
                )
            )
        }
        
        Column(horizontalAlignment = Alignment.End) {
            if (company != null) {
                Text(
                    text = company,
                    style = TextStyle(
                        fontFamily = Inter,
                        fontSize = 10.sp,
                        color = ContentTertiary
                    )
                )
            }
            Text(
                text = amount,
                style = TextStyle(
                    fontFamily = Inter,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 14.sp,
                    color = if (amount == "Paid") ContentTertiary else Color.Black
                )
            )
        }
    }
}
