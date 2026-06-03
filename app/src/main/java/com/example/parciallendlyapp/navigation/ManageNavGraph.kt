package com.example.parciallendlyapp.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.parciallendlyapp.feature.manage.screens.*
import com.example.parciallendlyapp.feature.manage.screens.SuccessScreen

fun NavGraphBuilder.manageNavGraph(
    navController: NavHostController
) {

    navigation(
        route = Routes.MANAGE_GRAPH,
        startDestination = Routes.MANAGE
    ) {

        composable(Routes.MANAGE) {
            ManageScreen(navController)
        }

        composable(Routes.EDIT_PROFILE) {
            EditProfileScreen(navController)
        }

        composable(Routes.CREDIT_SCORE) {
            CreditScoreScreen(navController)
        }

        composable(Routes.SETTINGS) {
            SettingsScreen(navController)
        }

        composable(Routes.HELP) {
            HelpScreen(navController)
        }

        composable(Routes.TERMS) {
            TermsScreen(navController)
        }

        composable(Routes.SUCCESS) {
            SuccessScreen(navController)
        }
    }
}