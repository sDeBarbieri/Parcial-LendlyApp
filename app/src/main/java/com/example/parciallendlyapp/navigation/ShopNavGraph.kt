package com.example.parciallendlyapp.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.parciallendlyapp.feature.shop.screens.FilterScreen
import com.example.parciallendlyapp.feature.shop.screens.ProductScreen
import com.example.parciallendlyapp.feature.shop.screens.SearchScreen
import com.example.parciallendlyapp.feature.shop.screens.ShopScreen

fun NavGraphBuilder.shopNavGraph(navController: NavHostController) {
    navigation(
        route = Routes.SHOP_GRAPH,
        startDestination = Routes.SHOP
    ) {
        composable(Routes.SHOP) {
            ShopScreen(navController)
        }
        composable(Routes.SEARCH) {
            SearchScreen(
                navController = navController,
                onBackClick = { navController.popBackStack() })
        }
        composable(Routes.PRODUCT) {
            ProductScreen(
                onBackClick = { navController.popBackStack() }
            )
        }
        composable(Routes.FILTER) {
            FilterScreen(navController)
        }
    }
}