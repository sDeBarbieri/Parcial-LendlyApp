package com.example.parciallendlyapp.feature.home.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.parciallendlyapp.R
import com.example.parciallendlyapp.components.LendlyButton
import com.example.parciallendlyapp.components.TransactionComponent
import com.example.parciallendlyapp.components.TransactionDetailItem
import com.example.parciallendlyapp.ui.theme.InteractiveControl

@Composable
fun SuccesfulTransactionScreen(
    onBackClick: () -> Unit
) {
    TransactionComponent(
        navigationIconRes = R.drawable.share_close,
        iconRes = R.drawable.home_icon_add,
        statusText = stringResource(R.string.cashin_success_1),
        amount = stringResource(R.string.cashin_success_2),
        targetText = stringResource(R.string.cashin_success_3),
        transactionType = stringResource(R.string.cashin_topbar),
        details = listOf(
            TransactionDetailItem(
                label = stringResource(R.string.cashin_success_fee_1),
                value = stringResource(R.string.cashin_success_fee_2)
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
        helpText = stringResource(R.string.cashin_success_help),
        onBackClick = onBackClick,
        onDoneClick = onBackClick
    )
}