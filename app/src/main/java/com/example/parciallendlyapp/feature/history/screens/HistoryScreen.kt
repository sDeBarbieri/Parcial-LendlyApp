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
import androidx.compose.ui.res.stringResource
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
                Title(text = stringResource(R.string.history_title))
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
                            stringResource(R.string.history_search_placeholder),
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
                val filters = listOf(
                    stringResource(R.string.history_filter_all),
                    stringResource(R.string.history_filter_type),
                    stringResource(R.string.history_filter_balance),
                    stringResource(R.string.history_filter_paid_bills),
                    stringResource(R.string.history_filter_added)
                )
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    items(filters) { filter ->
                        FilterChipComponent(
                            text = filter,
                            isSelected = filter == stringResource(R.string.history_filter_all)
                        )
                    }
                }
                
                Spacer(modifier = Modifier.height(16.dp))
            }

            HorizontalDivider(color = Color(0xFFF0F0F0), thickness = 1.dp)

            Column(modifier = Modifier.padding(horizontal = 16.dp)) {
                Spacer(modifier = Modifier.height(24.dp))

                // Today Section
                SectionHeader(title = stringResource(R.string.history_section_today))
                Spacer(modifier = Modifier.height(8.dp))
                ItemRow(
                    iconResId = R.drawable.share_arrow_upward,
                    time = stringResource(R.string.history_item_time_today),
                    description = stringResource(R.string.history_item_paid_this_month),
                    company = stringResource(R.string.history_item_apple),
                    amount = stringResource(R.string.history_item_amount_12555),
                    onClick = onTransactionClick
                )
                ItemRow(
                    iconResId = R.drawable.share_arrow_upward,
                    time = stringResource(R.string.history_item_time_today),
                    description = stringResource(R.string.history_item_paid_this_month),
                    company = stringResource(R.string.history_item_apple),
                    amount = stringResource(R.string.history_item_amount_12555),
                    onClick = onTransactionClick
                )
                ItemRow(
                    iconResId = R.drawable.share_arrow_upward,
                    time = stringResource(R.string.history_item_time_today),
                    description = stringResource(R.string.history_item_paid_this_month),
                    company = stringResource(R.string.history_item_apple),
                    amount = stringResource(R.string.history_item_amount_12555),
                    onClick = onTransactionClick
                )
                ItemRow(
                    iconResId = R.drawable.share_add,
                    time = stringResource(R.string.history_item_time_today),
                    description = stringResource(R.string.history_filter_added),
                    company = null,
                    amount = stringResource(R.string.history_item_amount_1200),
                    onClick = onTransactionClick
                )
                ItemRow(
                    iconResId = R.drawable.share_add,
                    time = stringResource(R.string.history_item_time_today),
                    description = stringResource(R.string.history_item_paid_this_month),
                    company = null,
                    amount = stringResource(R.string.history_item_amount_1200),
                    onClick = onTransactionClick
                )

                Spacer(modifier = Modifier.height(32.dp))

                // Recent Loans Section
                SectionHeader(title = stringResource(R.string.history_section_recent_loans))
                Spacer(modifier = Modifier.height(16.dp))
                ItemRow(
                    iconResId = R.drawable.share_check,
                    time = stringResource(R.string.history_item_date_recent),
                    description = stringResource(R.string.history_item_iphone_15),
                    company = stringResource(R.string.history_item_apple),
                    amount = stringResource(R.string.history_item_paid),
                    onClick = onTransactionClick
                )
                ItemRow(
                    iconResId = R.drawable.share_check,
                    time = stringResource(R.string.history_item_date_recent),
                    description = stringResource(R.string.history_item_iphone_15),
                    company = stringResource(R.string.history_item_apple),
                    amount = stringResource(R.string.history_item_paid),
                    onClick = onTransactionClick
                )
                ItemRow(
                    iconResId = R.drawable.share_check,
                    time = stringResource(R.string.history_item_date_recent),
                    description = stringResource(R.string.history_item_iphone_15),
                    company = stringResource(R.string.history_item_apple),
                    amount = stringResource(R.string.history_item_paid),
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
