package com.example.parciallendlyapp.feature.home.screens

import androidx.compose.ui.Alignment
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import com.example.parciallendlyapp.ui.theme.Inter
import com.example.parciallendlyapp.ui.theme.Montserrat
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.parciallendlyapp.R
import com.example.parciallendlyapp.components.*
import com.example.parciallendlyapp.feature.home.domain.model.LoanModel
import com.example.parciallendlyapp.feature.home.domain.model.ProductModel
import com.example.parciallendlyapp.navigation.Routes
import com.example.parciallendlyapp.ui.theme.ContainerGray

@Composable
fun HomeScreen(navController: NavHostController) {
    // Datos de ejemplo
    val loansFromApi = listOf(
        LoanModel("Nike Inc.", "₱400.00", "Fees of February", R.drawable.share_avatar),
        LoanModel("Apple Inc.", "₱1500.00", "Fees of March", R.drawable.shop_logo_apple),
        LoanModel("Adidas", "₱600.00", "Fees of April", R.drawable.share_avatar),
    )
    val productsFromApi = listOf(
        ProductModel("iPhone 12 Pro", "₱1,200 x 24 mo", R.drawable.shop_phone),
        ProductModel("Watch Series 7", "₱800 x 12 mo", R.drawable.shop_ps4),
        ProductModel("MacBook Air", "₱2,500 x 36 mo", R.drawable.shop_shirt)
    )

    Scaffold(
        topBar = {
            TopBar(
                onNotificationClick = { /* Acción */ },
                onProfileClick = { /* Acción */ }
            )
        }
    ) { innerPadding ->
        // Ahora HomeContent es una función independiente
        HomeContent(
            modifier = Modifier.padding(innerPadding),
            loans = loansFromApi,
            products = productsFromApi,
            navController = navController
        )
    }
}

@Composable
fun HomeContent(
    modifier: Modifier = Modifier,
    loans: List<LoanModel>,
    products: List<ProductModel>,
    navController: NavHostController
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp)
    ) {
        Spacer(modifier = Modifier.height(24.dp))

        Title(text = stringResource(id = R.string.home_screen_title))

        Spacer(modifier = Modifier.height(16.dp))

        // Balance Card
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .height(136.dp),
            color = ContainerGray,
            shape = RoundedCornerShape(16.dp)
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = stringResource(id = R.string.home_balance),
                        style = TextStyle(
                            fontFamily = Inter,
                            fontWeight = FontWeight.Medium,
                            fontSize = 12.sp,
                            lineHeight = 16.sp,
                            letterSpacing = 0.5.sp
                        ),
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )

                    CashInButton(
                        text = stringResource(id = R.string.home_cashin_button),
                        iconResId = R.drawable.home_icon_add,
                        onClick = { navController.navigate(Routes.CASH_IN) }
                    )
                }

                Text(
                    text = stringResource(id = R.string.home_balance_number),
                    style = TextStyle(
                        fontFamily = Montserrat,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 32.sp,
                        lineHeight = 40.sp
                    ),
                    color = MaterialTheme.colorScheme.onSurface
                )
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Sección Préstamos
        HeaderRow(
            title = stringResource(id = R.string.home_sutitle_1),
            onSeeAllClick = { navController.navigate(Routes.LOAN_ACTIVE) }
        )

        Spacer(modifier = Modifier.height(16.dp))

        Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
            loans.take(2).forEach { loan ->
                LoanCard(
                    loanName = loan.name,
                    amount = loan.amount,
                    date = loan.date,
                    imageResId = loan.imageRes
                )
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Sección Productos
        HeaderRow(
            title = stringResource(id = R.string.home_sutitle_2),
            onSeeAllClick = { /* Ver todos */ }
        )

        Spacer(modifier = Modifier.height(24.dp))

        ProductList(products = products)
    }
}
