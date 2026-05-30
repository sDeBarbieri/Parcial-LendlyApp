package com.example.parciallendlyapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.parciallendlyapp.feature.auth.screens.login.LoginScreen
import com.example.parciallendlyapp.feature.auth.screens.login.SmsVerificationScreen
import com.example.parciallendlyapp.feature.auth.screens.login.VerifyPhoneNumberScreen
import com.example.parciallendlyapp.feature.auth.screens.register.CreatePassword
import com.example.parciallendlyapp.feature.auth.screens.register.ProfileDetailForm
import com.example.parciallendlyapp.feature.onboarding.screens.OnboardingScreen
import com.example.parciallendlyapp.feature.splash.screens.SplashScreen

@Composable
fun AppNavGraph(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Routes.SPLASH){
        composable(Routes.SPLASH){
            SplashScreen(onNavigate = {navController.navigate(Routes.ONBOARDING)})
        }
        composable(Routes.ONBOARDING){
            OnboardingScreen(
                onLoginClick = { navController.navigate(Routes.LOGIN) },
                onSignUpClick = { navController.navigate(Routes.VERIFY_PHONE) }
            )
        }
        composable(Routes.LOGIN){
            LoginScreen(onLoginSuccess = {
                navController.navigate(Routes.MAIN) {
                    popUpTo(Routes.ONBOARDING) { inclusive = true }
                }
            })
        }
        composable(Routes.VERIFY_PHONE) {
            VerifyPhoneNumberScreen(
                onBackClick = { navController.popBackStack() },
                onSendCodeClick = { countryCode, phoneNumber ->
                    navController.navigate(Routes.SMS_VERIFICATION)
                }
            )
        }
        composable(Routes.SMS_VERIFICATION) {
            SmsVerificationScreen(
                onBackClick = { navController.popBackStack() },
                onNextClick = { otp ->
                    navController.navigate(Routes.PROFILE_DETAIL)
                }
            )
        }
        composable(Routes.PROFILE_DETAIL) {
            ProfileDetailForm(
                onBackClick = { navController.popBackStack() },
                onNextClick = {
                    navController.navigate(Routes.CREATE_PASSWORD)
                }
            )
        }
        composable(Routes.CREATE_PASSWORD) {
            CreatePassword(
                onBackClick = { navController.popBackStack() },
                onNextClick = { password ->
                    navController.navigate(Routes.MAIN) {
                        popUpTo(Routes.ONBOARDING) { inclusive = true }
                    }
                }
            )
        }
        composable(Routes.MAIN){
            MainNavGraph()
        }

    }
}
