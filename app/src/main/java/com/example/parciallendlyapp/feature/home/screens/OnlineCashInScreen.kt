package com.example.parciallendlyapp.feature.home.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.parciallendlyapp.R
import com.example.parciallendlyapp.components.OnlineCashInItem
import com.example.parciallendlyapp.components.SearchInput
import com.example.parciallendlyapp.components.Title
import com.example.parciallendlyapp.components.SecondaryTopBar
import com.example.parciallendlyapp.feature.home.domain.model.onlineCashinBanksList
import com.example.parciallendlyapp.feature.home.domain.model.onlineCashinWalletsList
import com.example.parciallendlyapp.navigation.Routes
import com.example.parciallendlyapp.ui.theme.BackgroundScreen
import com.example.parciallendlyapp.ui.theme.ContainerGray
import com.example.parciallendlyapp.ui.theme.SolidDark

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OnlineCashInScreen(
    navController: NavHostController,
    onBackClick: () -> Unit
) {
    Scaffold(
        containerColor = ContainerGray,
        topBar = {
            SecondaryTopBar(
                title = "",
                onBackClick = onBackClick,
                showInfoButton = false,
                onInfoClick = { /* Lógica de info */ }
            )
        }
    ) { innerPadding ->
        OnlineCashInContent(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            navController = navController
        )
    }
}

@Composable
fun OnlineCashInContent(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    val banks = onlineCashinBanksList
    val wallets = onlineCashinWalletsList
    
    Column(
        modifier = modifier
            .padding(horizontal = 20.dp)
    ) {
        Spacer(modifier = Modifier.height(24.dp))

        Title(text = stringResource(id = R.string.online_cashin_title))

        Spacer(modifier = Modifier.height(16.dp))

        SearchInput(
            value = "",
            onValueChange = {},
            placeholder = stringResource(R.string.history_search_placeholder)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Surface(
            modifier = Modifier
                .width(361.dp)
                .wrapContentHeight(), // Permitimos que crezca con el contenido
            color = BackgroundScreen,
            shape = androidx.compose.foundation.shape.RoundedCornerShape(12.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp) // Padding interno base
            ) {
                InternalTitle(
                    text = stringResource(R.string.online_cashin_banks),
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
                )

                banks.forEachIndexed { index, bank ->
                    OnlineCashInItem(
                        title = bank.name,
                        leadingIcon = bank.logoRes,
                        onClick = { navController.navigate(Routes.CASH_IN_INPUT) }
                    )
                }

                HorizontalDivider(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    thickness = 0.5.dp,
                    color = Color(0xFFE5E2E1)
                )

                InternalTitle(
                    text = stringResource(R.string.online_cashin_wallets),
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
                )

                wallets.forEachIndexed { index, wallet ->
                    OnlineCashInItem(
                        title = wallet.name,
                        leadingIcon = wallet.logoRes,
                        onClick = { navController.navigate(Routes.CASH_IN_INPUT) }
                    )
                }
            }
        }
    }
}

@Composable
private fun InternalTitle(
    text: String,
    modifier: Modifier = Modifier
) {    Text(
    text = text,
    modifier = modifier
        .width(329.dp)
        .height(16.dp),
    style = androidx.compose.ui.text.TextStyle(
        fontFamily = com.example.parciallendlyapp.ui.theme.Inter,
        fontWeight = androidx.compose.ui.text.font.FontWeight.Medium, // 500
        fontSize = 12.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    ),
    color = SolidDark
)
}