package com.example.parciallendlyapp.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.parciallendlyapp.R
import com.example.parciallendlyapp.ui.theme.Inter


@Composable
fun BottomNavBar(navController: NavHostController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    NavigationBar(
        containerColor = MaterialTheme.colorScheme.background,
        modifier = Modifier.drawBehind {
            // La línea gris fina en la parte superior
            drawLine(
                color = androidx.compose.ui.graphics.Color.LightGray.copy(alpha = 0.5f),
                start = androidx.compose.ui.geometry.Offset(0f, 0f),
                end = androidx.compose.ui.geometry.Offset(size.width, 0f),
                strokeWidth = 3f
            )
        }
    ) {
        val items = listOf(
            Data(Routes.HOME, "Home", R.drawable.share_home , R.drawable.nav_icon_home_bold),
            Data(Routes.LOANS, "Loan", R.drawable.share_credit_card, R.drawable.nav_icon_credit_card_bold),
            Data(Routes.SHOP, "Shop", R.drawable.share_shopping_bag, R.drawable.nav_icon_shopping_bag_bold),
            Data(Routes.HISTORY, "History", R.drawable.share_update, R.drawable.nav_icon_update_bold),
            Data(Routes.MANAGE, "Manage", R.drawable.share_grid_view, R.drawable.nav_icon_grid_view_bold),
        )
            items.forEach { item ->
            val isSelected = currentRoute == item.route

            NavigationBarItem(
                selected = isSelected,
                onClick = {
                    navController.navigate(item.route) {
                        popUpTo(navController.graph.startDestinationId) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                label = {
                    Text(
                        text = item.label,
                        style = TextStyle(
                            fontFamily = Inter,
                            fontWeight = FontWeight.Medium, // 500
                            fontSize = 12.sp,
                            lineHeight = 16.sp,
                            letterSpacing = 0.5.sp,
                            textAlign = TextAlign.Center
                        ),
                        color = if(isSelected) MaterialTheme.colorScheme.onSurface else MaterialTheme.colorScheme.onSecondaryContainer
                    )
                },
                icon = {
                    Icon(
                        painter = painterResource(
                            id = if (isSelected) item.iconBold else item.iconNormal
                        ),
                        contentDescription = item.label,
                        modifier = Modifier
                            // Mantenemos el tamaño en 24.dp para que el texto no se mueva
                            .size(24.dp)
                            //  padding para achicar el dibujo interno del icono Bold
                            .padding(if (isSelected) 3.dp else 0.dp),
                        tint = if(isSelected) MaterialTheme.colorScheme.onSurface else MaterialTheme.colorScheme.onSecondaryContainer
                    )
                }
            )
        }
    }
}

data class Data(val route: String, val label: String, val iconNormal: Int, val iconBold: Int)