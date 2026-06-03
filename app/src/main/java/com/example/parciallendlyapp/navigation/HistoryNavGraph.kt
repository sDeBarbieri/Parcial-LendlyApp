package com.example.parciallendlyapp.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.parciallendlyapp.feature.history.screens.HistoryScreen
import com.example.parciallendlyapp.feature.history.screens.TransactionDetailsScreen

fun NavGraphBuilder.historyNavGraph(navController: NavHostController) {
    navigation(
        route = Routes.HISTORY_GRAPH,
        startDestination = Routes.HISTORY
    ) {
        composable(Routes.HISTORY) {
            HistoryScreen(
                navController = navController,
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
    }
}