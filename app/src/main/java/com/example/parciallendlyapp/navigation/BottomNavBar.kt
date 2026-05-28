package com.example.parciallendlyapp.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBalance
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun BottomNavBar(navController: NavHostController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    
    NavigationBar {
        listOf(
            Triple(Routes.HOME, "Home", Icons.Default.Home),
            Triple(Routes.LOANS, "Loans", Icons.Default.AccountBalance),
            Triple(Routes.SHOP, "Shop", Icons.Default.ShoppingCart),
            Triple(Routes.HISTORY, "History", Icons.Default.History),
            Triple(Routes.MANAGE, "Manage", Icons.Default.Settings),
        ).forEach { (route, label, icon) -> 
            NavigationBarItem(
                selected = currentRoute == route,
                onClick = { 
                    navController.navigate(route) {
                        // Evita acumular múltiples copias del mismo destino en la pila
                        popUpTo(navController.graph.startDestinationId) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    } 
                },
                label = { Text(label) },
                icon = { Icon(icon, contentDescription = label) }
            )
        }
    }
}
