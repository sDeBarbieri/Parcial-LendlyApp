package com.example.parciallendlyapp.navigation

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.parciallendlyapp.R
import com.example.parciallendlyapp.ui.theme.ContentPrimary
import com.example.parciallendlyapp.ui.theme.ContentSecondary


@Composable
fun BottomNavBar(navController: NavHostController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    NavigationBar {
        listOf(
            Triple(Routes.HOME, "Home", R.drawable.share_home),
            Triple(Routes.LOANS, "Loans", R.drawable.share_credit_card),
            Triple(Routes.SHOP, "Shop", R.drawable.share_shopping_bag),
            Triple(Routes.HISTORY, "History", R.drawable.share_update),
            Triple(Routes.MANAGE, "Manage", R.drawable.share_grid_view),
        ).forEach { (route, label, iconResId) ->
            val isSelected = currentRoute == route

            NavigationBarItem(
                selected = isSelected,
                onClick = {
                    navController.navigate(route) {
                        popUpTo(navController.graph.startDestinationId) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                label = {
                    Text(
                        text = label,
                        color = if (isSelected) ContentPrimary else ContentSecondary
                    )
                },
                icon = {
                    Icon(
                        painter = painterResource(id = iconResId),
                        contentDescription = label,
                        // Ensancha el dibujo aumentando el tamaño del Icon
                        modifier = Modifier.size(if (isSelected) 26.dp else 24.dp)
                    )
                }
            )
        }
    }
}