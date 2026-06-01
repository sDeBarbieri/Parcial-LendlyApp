package com.example.parciallendlyapp.feature.loans.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.parciallendlyapp.R
import com.example.parciallendlyapp.components.TransactionComponent
import com.example.parciallendlyapp.components.TransactionDetailItem
import com.example.parciallendlyapp.ui.theme.InteractiveControl

@Composable
fun LoanTransactionScreen(
    onBackClick: () -> Unit,
    onDoneClick: () -> Unit
) {
    TransactionComponent(
        navigationIconRes = R.drawable.share_close,
        iconRes = R.drawable.home_icon_add,
        statusText = stringResource(R.string.transaction_details_added_to_account),
        amount = stringResource(R.string.transaction_details_mock_loan_amount),
        targetText = stringResource(R.string.transaction_details_from_apple, "Apple Inc."),
        transactionType = stringResource(R.string.transaction_details_loan_amount),
        details = listOf(
            TransactionDetailItem(
                label = stringResource(R.string.transaction_details_monthly_fee),
                value = stringResource(R.string.transaction_details_mock_monthly_fee)
            ),
            TransactionDetailItem(
                label = stringResource(R.string.transaction_details_interest),
                value = stringResource(R.string.transaction_details_mock_interest)
            ),
            TransactionDetailItem(
                label = stringResource(R.string.transaction_details_installment_plan),
                value = stringResource(R.string.transaction_details_mock_installment)
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
        helpText = stringResource(R.string.transaction_details_need_help),
        onBackClick = onBackClick,
        onDoneClick = onDoneClick
    )
}
