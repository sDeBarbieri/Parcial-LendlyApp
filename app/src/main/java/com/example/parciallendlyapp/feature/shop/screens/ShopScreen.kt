package com.example.parciallendlyapp.feature.shop.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.navigation.NavHostController
import com.example.parciallendlyapp.components.SearchInput
import com.example.parciallendlyapp.components.TopBar
import com.example.parciallendlyapp.navigation.Routes
import com.example.parciallendlyapp.ui.theme.InteractiveAccent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.parciallendlyapp.R
import com.example.parciallendlyapp.ui.theme.Montserrat
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.parciallendlyapp.components.BrandList
import com.example.parciallendlyapp.components.CategoryList
import com.example.parciallendlyapp.components.HeaderRow
import com.example.parciallendlyapp.components.ProductList
import com.example.parciallendlyapp.domain.Resource
import com.example.parciallendlyapp.feature.home.domain.model.ProductModel
import com.example.parciallendlyapp.feature.shop.ShopViewModel
import com.example.parciallendlyapp.feature.shop.screens.models.BrandModel
import com.example.parciallendlyapp.feature.shop.screens.models.CategoryModel

@Composable
fun ShopScreen(
    navController: NavHostController,
    viewModel: ShopViewModel = hiltViewModel()
) {
    val state = viewModel.uiState
    var searchText by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopBar(navController = navController)
        }
    ) { paddingValues ->
        when (state) {
            is Resource.Loading -> {
                Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    CircularProgressIndicator(color = InteractiveAccent)
                }
            }

            is Resource.Error -> {
                // Pantalla de Error con opción a reintentar
                ErrorState(
                    message = state.message,
                    onRetry = { viewModel.fetchShopData() }
                )
            }

            is Resource.Success -> {
                val shopData = state.data

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues)
                        .padding(horizontal = 20.dp)
                        .verticalScroll(rememberScrollState())
                ) {
                    Spacer(modifier = Modifier.height(16.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(12.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .clickable { navController.navigate(Routes.SEARCH) }
                        ) {
                            SearchInput(
                                value = searchText,
                                onValueChange = { searchText = it },
                                placeholder = stringResource(R.string.shop_search_placeholder),
                                modifier = Modifier.fillMaxWidth(1f)
                            )
                            Box(
                                modifier = Modifier
                                    .matchParentSize()
                                    .clickable { navController.navigate(Routes.SEARCH) }
                            )
                        }
                        IconButton(
                            onClick = { navController.navigate(Routes.FILTER) },
                            modifier = Modifier
                                .size(48.dp)
                                .background(
                                    color = InteractiveAccent,
                                    shape = RoundedCornerShape(12.dp)
                                )
                        ) {
                            Icon(
                                painter = painterResource(R.drawable.share_filter),
                                contentDescription = "Filter"
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(20.dp))

                    ShopBannerSlider()

                    Spacer(modifier = Modifier.height(25.dp))

                    HeaderRow(
                        title = stringResource(R.string.shop_by_category),
                        onSeeAllClick = {}
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    CategoryList(
                        categories = shopData.categories.mapIndexed { index, dto ->
                            CategoryModel(
                                name = dto.name,
                                // Asignamos una imagen distinta según la posición para variar (no llegamos a implementar coil)
                                imageRes = when (index % 3) {
                                    0 -> R.drawable.shop_phone
                                    1 -> R.drawable.shop_headphones
                                    else -> R.drawable.shop_laptop
                                }
                            )
                        }
                    )

                    Spacer(modifier = Modifier.height(25.dp))

                    HeaderRow(
                        title = stringResource(R.string.shop_popular_brands),
                        onSeeAllClick = {}
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    BrandList(
                        brands = shopData.brands.mapIndexed { index, dto ->
                            BrandModel(
                                name = dto.name,
                                // Asignamos una imagen distinta según la posición para variar (no llegamos a implementar coil)
                                imageRes = if (index % 2 == 0) R.drawable.shop_brand_apple_banner else R.drawable.shop_brand_jordan_banner,
                                logoRes = R.drawable.product_icon_apple
                            )
                        }
                    )

                    Spacer(modifier = Modifier.height(25.dp))

                    HeaderRow(
                        title = stringResource(R.string.shop_recommended),
                        onSeeAllClick = {}
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    ProductList(
                        products = shopData.products.mapIndexed { index, dto ->
                            ProductModel(
                                name = dto.name,
                                price = "₱${dto.monthlyInstallment.toInt()} x ${dto.installmentMonths} mo",
                                // Asignamos una imagen distinta según la posición para variar (no llegamos a implementar coil)
                                imageRes = when (index % 3) { // Ajustado a rotación de 3
                                    0 -> R.drawable.shop_phone
                                    1 -> R.drawable.shop_laptop
                                    else -> R.drawable.shop_sneakers
                                }
                            )
                        },
                        onProductClick = { navController.navigate(Routes.PRODUCT) }
                    )

                    Spacer(modifier = Modifier.height(25.dp))

                    HeaderRow(
                        title = stringResource(R.string.shop_best_sellers),
                        onSeeAllClick = {}
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    ProductList(
                        products = shopData.featured.mapIndexed { index, dto ->
                            ProductModel(
                                name = dto.name,
                                price = "₱${dto.monthlyInstallment.toInt()} x ${dto.installmentMonths} mo",
                                // Asignamos una imagen distinta según la posición para variar (no llegamos a implementar coil)
                                imageRes = if (index % 2 == 0) R.drawable.shop_phone else R.drawable.shop_laptop
                            )
                        },
                        onProductClick = { navController.navigate(Routes.PRODUCT) }
                    )
                    Spacer(modifier = Modifier.height(25.dp))
                }
            }
        }
    }
}

@Composable
fun ShopBanner(currentPage: Int) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(190.dp),
        shape = RoundedCornerShape(20.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFF0B2200))
        ) {
            Column(
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .padding(20.dp)
            ) {
                Text(
                    text = stringResource(R.string.shop_banner_title),
                    color = Color.White,
                    fontSize = 30.sp,
                    fontFamily = Montserrat,
                    fontWeight = FontWeight.SemiBold
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = stringResource(R.string.shop_banner_subtitle),
                    color = Color.White.copy(alpha = 0.85f),
                    fontSize = 14.sp
                )
                Spacer(modifier = Modifier.height(16.dp))
                Button(
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(
                        containerColor = InteractiveAccent
                    )
                ) {
                    Text(
                        text = stringResource(R.string.shop_banner_button),
                        color = Color.Black
                    )
                }
            }
            Image(
                painter = painterResource(R.drawable.shop_shoes),
                contentDescription = null,
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .offset(y = 22.dp)
                    .size(160.dp)
            )
            Row(
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(start = 20.dp, bottom = 16.dp)
            ) {
                repeat(3) { index ->
                    Box(
                        modifier = Modifier
                            .padding(end = 6.dp)
                            .size(6.dp)
                            .background(
                                color = if (currentPage == index) Color.White else Color.White.copy(
                                    alpha = 0.3f
                                ),
                                shape = CircleShape
                            )
                    )
                }
            }
        }
    }
}

@Composable
fun ShopBannerSlider() {
    val pagerState = rememberPagerState(pageCount = { 3 })
    Column {
        HorizontalPager(state = pagerState) { page ->
            ShopBanner(currentPage = pagerState.currentPage)
        }
    }
}

@Composable
fun ErrorState(message: String, onRetry: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = message,
            textAlign = TextAlign.Center,
            fontFamily = Montserrat,
            color = Color.Gray
        )
        Spacer(modifier = Modifier.height(24.dp))
        Button(
            onClick = onRetry,
            colors = ButtonDefaults.buttonColors(containerColor = InteractiveAccent)
        ) {
            Text("Reintentar", color = Color.Black)
        }
    }
}