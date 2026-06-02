package com.example.parciallendlyapp.feature.shop.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration.Companion.Underline
import androidx.compose.ui.text.style.TextOverflow.Companion.Ellipsis
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.parciallendlyapp.R
import com.example.parciallendlyapp.components.SearchInput
import com.example.parciallendlyapp.components.SecondaryTopBar
import com.example.parciallendlyapp.ui.theme.BorderNeutral
import com.example.parciallendlyapp.ui.theme.ContainerGray
import com.example.parciallendlyapp.ui.theme.ContentSecondary
import com.example.parciallendlyapp.ui.theme.ContentTertiary
import com.example.parciallendlyapp.ui.theme.Inter
import com.example.parciallendlyapp.ui.theme.InteractiveControl

@Composable
fun SearchScreen(
    navController: NavHostController,
    onBackClick: () -> Unit
) {
    var searchText by remember {
        mutableStateOf("")
    }
    // Lista de búsquedas recientes
    val recentSearches = listOf(
        "Blue shirt",
        "Red shirt",
        "Yellow shirt",
        "Blue shoes",
        "Red shoes",
        "Yellow shoes",
        "Blue jeans"
    )

    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        recentSearches.forEach { search ->
            RecentSearchItem(
                text = search,
                onItemClick = { searchText = search },
                onDeleteClick = { /* Lógica para borrar este item */ }
            )
        }
    }
    Scaffold(
        containerColor = ContainerGray,
        topBar = {
            SecondaryTopBar(
                title = stringResource(id = R.string.shop_search_title),
                onBackClick = onBackClick,
                showInfoButton = false
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 24.dp) // padding para separar de los bordes
        ) {
            Spacer(modifier = Modifier.height(16.dp)) // Espacio respecto a la TopBar

            SearchInput(
                value = searchText,
                onValueChange = {
                    searchText = it
                },
                placeholder = stringResource(R.string.shop_search_placeholder),
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp)) // Espacio después del SearchInput

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = androidx.compose.ui.Alignment.CenterVertically
            ) {
                Text(
                    text = stringResource(R.string.search_recent), // Puedes usar stringResource(R.string.search_recent)
                    modifier = Modifier
                        .width(85.dp)
                        .height(24.dp),
                    style = TextStyle(
                        fontFamily = Inter,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 16.sp,
                        lineHeight = 24.sp,
                        letterSpacing = 0.15.sp
                    ),
                    color = com.example.parciallendlyapp.ui.theme.SolidDark
                )

                Text(
                    text = stringResource(R.string.search_clear_all), // Puedes usar stringResource(R.string.search_clear_all)
                    modifier = Modifier
                        .width(67.dp)
                        .height(24.dp)
                        .clickable { /* Lógica para limpiar */ },
                    style = TextStyle(
                        fontFamily = Inter,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 16.sp,
                        lineHeight = 24.sp,
                        letterSpacing = 0.15.sp,
                        textDecoration = Underline
                    ),
                    color = InteractiveControl
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            HorizontalDivider(color = BorderNeutral, thickness = 1.dp)

            Spacer(modifier = Modifier.height(16.dp))

            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                recentSearches.forEach { search ->
                    RecentSearchItem(
                        text = search,
                        onItemClick = { searchText = search },
                        onDeleteClick = { /* Lógica para borrar este item */ }
                    )
                }
            }
        }
    }
}

@Composable
fun RecentSearchItem(
    text: String,
    onItemClick: () -> Unit,
    onDeleteClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .heightIn(min = 40.dp)
            .height(40.dp)
            .clickable { onItemClick() },
        verticalAlignment = androidx.compose.ui.Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        // Texto de la búsqueda
        Text(
            text = text,
            modifier = Modifier
                .weight(1f)
                .height(24.dp),
            style = TextStyle(
                fontFamily = Inter,
                fontWeight = FontWeight.Normal, // Regular (400)
                fontSize = 16.sp,
                lineHeight = 24.sp,
                letterSpacing = 0.5.sp
            ),
            color = ContentTertiary,
            maxLines = 1,
            overflow = Ellipsis
        )

        IconButton(
            onClick = onDeleteClick,
            modifier = Modifier.size(24.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.share_close),
                contentDescription = "Delete search",
                modifier = Modifier.size(24.dp),
                tint = ContentSecondary
            )
        }

    }
}