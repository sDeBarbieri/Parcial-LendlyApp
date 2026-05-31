package com.example.parciallendlyapp.feature.history.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.parciallendlyapp.R
import com.example.parciallendlyapp.components.TransactionComponent
import com.example.parciallendlyapp.components.TransactionDetailItem
import com.example.parciallendlyapp.ui.theme.InteractiveControl

@Composable
fun TransactionDetailsScreen(
    onBackClick: () -> Unit
) {
    TransactionComponent(
        navigationIconRes = R.drawable.share_arrow_left,
        iconRes = R.drawable.share_arrow_upward,
        statusText = stringResource(R.string.history_item_paid_this_month),
        amount = stringResource(R.string.transaction_details_mock_amount),
        targetText = stringResource(R.string.transaction_details_to_apple, stringResource(R.string.history_item_apple)),
        transactionType = stringResource(R.string.history_filter_paid_bills),
        details = listOf(
            TransactionDetailItem(
                label = stringResource(R.string.transaction_details_fee_label),
                value = stringResource(R.string.transaction_details_mock_fee)
            ),
            TransactionDetailItem(
                label = stringResource(R.string.transaction_details_date_time_label),
                value = stringResource(R.string.transaction_details_mock_datetime)
            ),
            TransactionDetailItem(
                label = stringResource(R.string.transaction_details_number_label),
                value = stringResource(R.string.transaction_details_mock_number),
                valueColor = InteractiveControl,
                isLink = true
            )
        ),
        helpText = stringResource(R.string.transaction_details_not_found),
        onBackClick = onBackClick
    )
}
