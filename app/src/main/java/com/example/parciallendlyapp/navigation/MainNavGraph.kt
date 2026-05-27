package com.example.parciallendlyapp.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.parciallendlyapp.feature.history.pages.HistoryScreen
import com.example.parciallendlyapp.feature.home.pages.HomeScreen
import com.example.parciallendlyapp.feature.loans.pages.LoanScreen
import com.example.parciallendlyapp.feature.manage.pages.ManageScreen
import com.example.parciallendlyapp.feature.shop.pages.ShopScreen

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
                HomeScreen()
            }
            composable(Routes.LOANS) {
                LoanScreen()
            }
            composable(Routes.SHOP) {
                ShopScreen()
            }
            composable(Routes.HISTORY) {
                HistoryScreen()
            }
            composable(Routes.MANAGE) {
                ManageScreen()
            }
        }
    }
}
