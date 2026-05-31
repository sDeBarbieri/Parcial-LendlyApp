package com.example.parciallendlyapp.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.parciallendlyapp.feature.history.screens.HistoryScreen
import com.example.parciallendlyapp.feature.home.screens.CashInScreen
import com.example.parciallendlyapp.feature.history.screens.TransactionDetailsScreen
import com.example.parciallendlyapp.feature.home.screens.HomeScreen
import com.example.parciallendlyapp.feature.loans.screens.LoanFormScreen
import com.example.parciallendlyapp.feature.loans.screens.LoanScreen
import com.example.parciallendlyapp.feature.shop.screens.ShopScreen

@Composable
fun MainNavGraph() {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = { BottomNavBar(navController) }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Routes.HOME,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(Routes.HOME) {
                HomeScreen(navController = navController)
            }
            composable(Routes.CASH_IN) {
                CashInScreen(onBackClick = { navController.popBackStack() })
            }
            composable(Routes.LOANS) {
                LoanScreen(
                    onGetLoanClick = {
                        navController.navigate(Routes.LOAN_FORM)
                    }
                )
            }
            composable(Routes.LOAN_FORM) {
                LoanFormScreen(
                    onBackClick = { navController.popBackStack() },
                    onGetLoanClick = { /* Handle success or final step */ }
                )
            }
            composable(Routes.SHOP) {
                ShopScreen()
            }
            composable(Routes.HISTORY) {
                HistoryScreen(
                    onTransactionClick = {
                        navController.navigate(Routes.TRANSACTION_DETAILS)
                    }
                )
            }
            composable(Routes.TRANSACTION_DETAILS) {
                TransactionDetailsScreen(
                    onBackClick = {
                        navController.popBackStack()
                    }
                )
            }
            manageNavGraph(navController)
        }
    }
}
