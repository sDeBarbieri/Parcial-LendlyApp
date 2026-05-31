package com.example.parciallendlyapp.feature.history.screens

import com.example.parciallendlyapp.components.Description
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.parciallendlyapp.R
import com.example.parciallendlyapp.components.FilterChipComponent
import com.example.parciallendlyapp.components.Subtitle
import com.example.parciallendlyapp.components.Title
import com.example.parciallendlyapp.ui.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TransactionDetailsScreen(
    onBackClick: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {},
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Box(
                            modifier = Modifier
                                .size(40.dp)
                                .background(Color(0xFFE5E2E1), CircleShape),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.share_arrow_left),
                                contentDescription = stringResource(R.string.transaction_details_back_desc),
                                modifier = Modifier.size(20.dp),
                                tint = ContentPrimary
                            )
                        }
                    }
                },
                actions = {
                    IconButton(onClick = { /* TODO */ }) {
                        Icon(
                            painter = painterResource(id = R.drawable.share_info),
                            contentDescription = stringResource(R.string.transaction_details_info_desc),
                            modifier = Modifier.size(20.dp),
                            tint = ContentPrimary
                        )
                    }
                    IconButton(onClick = { /* TODO */ }) {
                        Icon(
                            painter = painterResource(id = R.drawable.share_options),
                            contentDescription = stringResource(R.string.transaction_details_options_desc),
                            modifier = Modifier.size(20.dp),
                            tint = ContentPrimary
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = ContainerGray
                )
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .background(Color.White)
        ) {
            // Header Section
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFFFCF8F8))
                    .padding(bottom = 32.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(24.dp))
                
                // Success Icon
                Box(
                    modifier = Modifier
                        .size(64.dp)
                        .background(InteractiveAccent, CircleShape),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.share_arrow_upward),
                        contentDescription = null,
                        modifier = Modifier.size(32.dp),
                        tint = ContentPrimary
                    )
                }
                
                Spacer(modifier = Modifier.height(8.dp))
                
                Text(
                    text = stringResource(R.string.history_item_paid_this_month),
                    style = TextStyle(
                        fontFamily = Inter,
                        fontWeight = FontWeight.Medium,
                        fontSize = 14.sp,
                        color = ContentTertiary
                    )
                )
                
                Spacer(modifier = Modifier.height(8.dp))

                Title(text = stringResource(R.string.transaction_details_mock_amount))
                
                Spacer(modifier = Modifier.height(8.dp))
                
                Text(
                    text = stringResource(R.string.transaction_details_to_apple, stringResource(R.string.history_item_apple)),
                    style = TextStyle(
                        fontFamily = Inter,
                        fontWeight = FontWeight.Medium,
                        fontSize = 14.sp,
                        color = ContentTertiary
                    )
                )
                
                Spacer(modifier = Modifier.height(16.dp))
                
                FilterChipComponent(text = stringResource(R.string.history_filter_paid_bills), isSelected = false)
            }
            
            // Details Section
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp)
            ) {

                Subtitle(title = stringResource(R.string.transaction_details_title))
                
                Spacer(modifier = Modifier.height(16.dp))
                
                DetailRow(
                    label = stringResource(R.string.transaction_details_fee_label),
                    value = stringResource(R.string.transaction_details_mock_fee),
                    valueColor = ContentTertiary
                )
                Spacer(modifier = Modifier.height(16.dp))
                DetailRow(
                    label = stringResource(R.string.transaction_details_date_time_label),
                    value = stringResource(R.string.transaction_details_mock_datetime),
                    valueColor = ContentTertiary
                )
                Spacer(modifier = Modifier.height(16.dp))
                DetailRow(
                    label = stringResource(R.string.transaction_details_number_label),
                    value = stringResource(R.string.transaction_details_mock_number),
                    valueColor = InteractiveControl,
                    isLink = true
                )
                
                Spacer(modifier = Modifier.height(32.dp))
                HorizontalDivider(color = Color(0xFFF0F0F0), thickness = 1.dp)
                Spacer(modifier = Modifier.height(32.dp))
                
                Text(
                    text = stringResource(R.string.transaction_details_not_found),
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    style = TextStyle(
                        fontFamily = Inter,
                        fontWeight = FontWeight.Normal,
                        fontSize = 14.sp,
                        color = ContentTertiary
                    )
                )
                
                Text(
                    text = stringResource(R.string.transaction_details_help_center),
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { /* TODO */ },
                    textAlign = TextAlign.Center,
                    style = TextStyle(
                        fontFamily = Inter,
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp,
                        color = InteractiveControl,
                        textDecoration = TextDecoration.Underline
                    )
                )
            }
        }
    }
}

@Composable
fun DetailRow(
    label: String,
    value: String,
    valueColor: Color,
    isLink: Boolean = false
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Description(text = label, color = ContentTertiary)

        Description(
            text = value,
            color = valueColor,
            fontWeight = if (isLink) FontWeight.Bold else FontWeight.Medium,
            textDecoration = if (isLink) TextDecoration.Underline else TextDecoration.None
        )
    }
}
