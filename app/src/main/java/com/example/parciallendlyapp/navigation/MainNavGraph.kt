package com.example.parciallendlyapp.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.parciallendlyapp.feature.notifications.NotificationScreen

@Composable
fun MainNavGraph() {
    val navController = rememberNavController()

    // Obtenemos la entrada actual de la pila de navegación
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    // Definimos las rutas donde SÍ queremos ver el BottomBar
    val showBottomBarRoutes = listOf(
        Routes.HOME,
        Routes.LOANS,
        Routes.SHOP,
        Routes.HISTORY,
        Routes.MANAGE
    )

    Scaffold(
        // Solo mostramos el BottomNavBar si la ruta actual está en nuestra lista
        bottomBar = {
            if (currentRoute in showBottomBarRoutes) {
                BottomNavBar(navController)
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Routes.HOME_GRAPH,
            modifier = Modifier.padding(innerPadding)
        ) {

            homeNavGraph(navController)
            loanNavGraph(navController)
            shopNavGraph(navController)
            historyNavGraph(navController)
            manageNavGraph(navController)

            composable(Routes.NOTIFICATIONS) { NotificationScreen(navController) }

        }
    }
}
