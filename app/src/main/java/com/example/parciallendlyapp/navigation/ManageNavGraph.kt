package com.example.parciallendlyapp.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.parciallendlyapp.feature.manage.screens.*

fun NavGraphBuilder.manageNavGraph(
    navController: NavHostController
) {

    navigation(
        route = "manage_graph",
        startDestination = Routes.MANAGE
    ) {

        composable(Routes.MANAGE) {
            ManageScreen(navController)
        }

        composable(Routes.EDIT_PROFILE) {
            EditProfileScreen()
        }

        composable(Routes.CREDIT_SCORE) {
            CreditScoreScreen()
        }

        composable(Routes.SETTINGS) {
            SettingsScreen()
        }

        composable(Routes.HELP) {
            HelpScreen()
        }

        composable(Routes.TERMS) {
            TermsScreen()
        }
    }
}