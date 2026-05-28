package com.example.parciallendlyapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.parciallendlyapp.feature.auth.pages.login.LoginScreen
import com.example.parciallendlyapp.feature.onboarding.pages.OnboardingScreen
import com.example.parciallendlyapp.feature.splash.pages.SplashScreen

@Composable
fun AppNavGraph(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Routes.SPLASH){
        composable(Routes.SPLASH){
            SplashScreen(onNavigate = {navController.navigate(Routes.ONBOARDING)})
        }
        composable(Routes.ONBOARDING){
            OnboardingScreen(onFinish = {navController.navigate(Routes.LOGIN)})
        }
        composable(Routes.LOGIN){
            LoginScreen(onLoginSuccess = {navController.navigate(Routes.MAIN){
                popUpTo(Routes.SPLASH){
                    inclusive = true
                }
            } })
        }
        composable(Routes.MAIN){
            MainNavGraph()
        }

    }
}