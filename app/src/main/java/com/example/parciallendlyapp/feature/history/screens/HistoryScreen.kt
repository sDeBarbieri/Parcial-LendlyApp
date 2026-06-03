package com.example.parciallendlyapp.feature.history.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.parciallendlyapp.R
import com.example.parciallendlyapp.components.FilterChipComponent
import com.example.parciallendlyapp.components.ItemRow
import com.example.parciallendlyapp.components.SearchInput
import com.example.parciallendlyapp.components.Title
import com.example.parciallendlyapp.components.TopBar
import com.example.parciallendlyapp.feature.history.domain.HistoryTransaction
import com.example.parciallendlyapp.ui.theme.ContentTertiary
import com.example.parciallendlyapp.ui.theme.Inter

@Composable
fun HistoryScreen(
    onTransactionClick: () -> Unit = {}
) {
    var searchQuery by remember { mutableStateOf("") }

    // Listas de datos de ejemplo
    val todayTransactions = listOf(
        HistoryTransaction(1, R.drawable.share_arrow_upward, stringResource(R.string.history_item_time_today), stringResource(R.string.history_item_paid_this_month), stringResource(R.string.history_item_apple), stringResource(R.string.history_item_amount_12555)),
        HistoryTransaction(2, R.drawable.share_arrow_upward, stringResource(R.string.history_item_time_today), stringResource(R.string.history_item_paid_this_month), stringResource(R.string.history_item_apple), stringResource(R.string.history_item_amount_12555)),
        HistoryTransaction(3, R.drawable.share_arrow_upward, stringResource(R.string.history_item_time_today), stringResource(R.string.history_item_paid_this_month), stringResource(R.string.history_item_apple), stringResource(R.string.history_item_amount_12555)),
        HistoryTransaction(4, R.drawable.share_add, stringResource(R.string.history_item_time_today), stringResource(R.string.history_filter_added), null, stringResource(R.string.history_item_amount_1200)),
        HistoryTransaction(5, R.drawable.share_add, stringResource(R.string.history_item_time_today), stringResource(R.string.history_item_paid_this_month), null, stringResource(R.string.history_item_amount_1200))
    )

    val recentLoans = listOf(
        HistoryTransaction(6, R.drawable.share_check, stringResource(R.string.history_item_date_recent), stringResource(R.string.history_item_iphone_15), stringResource(R.string.history_item_apple), stringResource(R.string.history_item_paid)),
        HistoryTransaction(7, R.drawable.share_check, stringResource(R.string.history_item_date_recent), stringResource(R.string.history_item_iphone_15), stringResource(R.string.history_item_apple), stringResource(R.string.history_item_paid)),
        HistoryTransaction(8, R.drawable.share_check, stringResource(R.string.history_item_date_recent), stringResource(R.string.history_item_iphone_15), stringResource(R.string.history_item_apple), stringResource(R.string.history_item_paid))
    )

    Scaffold(
        topBar = {
            TopBar(
                onNotificationClick = { /* TODO */ },
                onProfileClick = { /* TODO */ }
            )
        },
        containerColor = MaterialTheme.colorScheme.background
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            // Header: Title and Search
            item {
                Column(modifier = Modifier.padding(horizontal = 16.dp)) {
                    Spacer(modifier = Modifier.height(16.dp))
                    Title(text = stringResource(R.string.history_title))
                    Spacer(modifier = Modifier.height(16.dp))

                    SearchInput(
                        value = searchQuery,
                        onValueChange = { searchQuery = it },
                        placeholder = stringResource(R.string.history_search_placeholder)
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                }
            }

            // Filters - LazyRow
            item {
                val filters = listOf(
                    stringResource(R.string.history_filter_all),
                    stringResource(R.string.history_filter_type),
                    stringResource(R.string.history_filter_balance),
                    stringResource(R.string.history_filter_paid_bills),
                    stringResource(R.string.history_filter_added),
                    stringResource(R.string.history_filter_date),
                    stringResource(R.string.history_filter_status),
                    stringResource(R.string.history_filter_category),
                    stringResource(R.string.history_filter_merchant)
                )
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    contentPadding = PaddingValues(horizontal = 16.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    items(filters) { filter ->
                        FilterChipComponent(
                            text = filter,
                            isSelected = filter == stringResource(R.string.history_filter_all),
                            onClick = {}
                        )
                    }
                }
            }

            item {
                Spacer(modifier = Modifier.height(16.dp))
                HorizontalDivider(modifier = Modifier.padding(horizontal = 16.dp), color = Color(0xFFF0F0F0), thickness = 1.dp)
                Spacer(modifier = Modifier.height(24.dp))
            }

            // Today Section
            item {
                Box(modifier = Modifier.padding(horizontal = 16.dp)) {
                    SectionHeader(title = stringResource(R.string.history_section_today))
                }
                Spacer(modifier = Modifier.height(8.dp))
            }

            items(todayTransactions) { transaction ->
                Box(modifier = Modifier.padding(horizontal = 16.dp)) {
                    ItemRow(
                        iconResId = transaction.iconResId,
                        time = transaction.time,
                        description = transaction.description,
                        company = transaction.company,
                        amount = transaction.amount,
                        onClick = onTransactionClick
                    )
                }
            }

            // Recent Loans Section
            item {
                Spacer(modifier = Modifier.height(32.dp))
                Box(modifier = Modifier.padding(horizontal = 16.dp)) {
                    SectionHeader(title = stringResource(R.string.history_section_recent_loans))
                }
                Spacer(modifier = Modifier.height(16.dp))
            }

            items(recentLoans) { transaction ->
                Box(modifier = Modifier.padding(horizontal = 16.dp)) {
                    ItemRow(
                        iconResId = transaction.iconResId,
                        time = transaction.time,
                        description = transaction.description,
                        company = transaction.company,
                        amount = transaction.amount,
                        onClick = onTransactionClick
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
