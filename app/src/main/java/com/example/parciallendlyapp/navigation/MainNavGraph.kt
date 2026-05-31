package com.example.parciallendlyapp.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.parciallendlyapp.feature.shop.screens.FilterScreen
import com.example.parciallendlyapp.feature.history.screens.HistoryScreen
import com.example.parciallendlyapp.feature.home.screens.CashInScreen
import com.example.parciallendlyapp.feature.history.screens.TransactionDetailsScreen
import com.example.parciallendlyapp.feature.home.screens.CashInInputScreen
import com.example.parciallendlyapp.feature.home.screens.HomeScreen
import com.example.parciallendlyapp.feature.home.screens.OTCCashInScreen
import com.example.parciallendlyapp.feature.home.screens.OnlineCashInScreen
import com.example.parciallendlyapp.feature.loans.screens.LoanScreen
import com.example.parciallendlyapp.feature.notifications.NotificationScreen
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
                CashInScreen(
                    navController = navController,
                    onBackClick = { navController.popBackStack() }
                )
            }
            composable(Routes.ONLINE_CASH_IN) {
                OnlineCashInScreen(
                    navController = navController,
                    onBackClick = { navController.popBackStack() })
            }
            composable(Routes.OTC_CASH_IN) {
                OTCCashInScreen(onBackClick = { navController.popBackStack() })
            }
            composable(Routes.CASH_IN_INPUT) {
                CashInInputScreen(onBackClick = { navController.popBackStack() })
            }

            // Grafo modularizado de Préstamos
            loanNavGraph(navController)

            composable(Routes.SHOP) {
                ShopScreen(navController)
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

            // Grafo modularizado de Gestión
            manageNavGraph(navController)

            composable(Routes.NOTIFICATIONS) {
                NotificationScreen(navController)
            }

            composable(Routes.FILTER) {
                FilterScreen(navController)
            }
        }
    }
}
