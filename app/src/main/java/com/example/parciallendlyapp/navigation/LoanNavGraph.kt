package com.example.parciallendlyapp.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.parciallendlyapp.feature.loans.screens.LoanActiveScreen
import com.example.parciallendlyapp.feature.loans.screens.LoanFormScreen
import com.example.parciallendlyapp.feature.loans.screens.LoanScreen
import com.example.parciallendlyapp.feature.loans.screens.LoanTransactionScreen

fun NavGraphBuilder.loanNavGraph(navController: NavHostController) {
    navigation(
        route = Routes.LOAN_GRAPH,
        startDestination = Routes.LOANS
    ) {
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
                onGetLoanClick = {
                    navController.navigate(Routes.LOAN_TRANSACTION)
                }
            )
        }
        composable(Routes.LOAN_TRANSACTION) {
            LoanTransactionScreen(
                onBackClick = { navController.popBackStack() },
                onDoneClick = {
                    navController.navigate(Routes.HOME) {
                        popUpTo(Routes.HOME) { inclusive = true }
                    }
                }
            )
        }
        composable(Routes.LOAN_ACTIVE) {
            LoanActiveScreen(
                onBackClick = { navController.popBackStack() }
            )
        }
    }
}
