package com.example.parciallendlyapp.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.parciallendlyapp.feature.home.screens.CashInInputScreen
import com.example.parciallendlyapp.feature.home.screens.CashInScreen
import com.example.parciallendlyapp.feature.home.screens.HomeScreen
import com.example.parciallendlyapp.feature.home.screens.OTCCashInScreen
import com.example.parciallendlyapp.feature.home.screens.OnlineCashInScreen
import com.example.parciallendlyapp.feature.home.screens.SuccesfulTransactionScreen

fun NavGraphBuilder.homeNavGraph(navController: NavHostController) {
    navigation(
        route = Routes.HOME_GRAPH,
        startDestination = Routes.HOME
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
            CashInInputScreen(
                navController= navController,
                onBackClick = { navController.popBackStack() }
            )
        }
        composable(Routes.CASH_IN_SUCCESS) {
            SuccesfulTransactionScreen(
                onBackClick = {
                    navController.navigate(Routes.HOME) {
                        popUpTo(Routes.HOME) { inclusive = true }
                    }
                }
            )
        }
    }
}