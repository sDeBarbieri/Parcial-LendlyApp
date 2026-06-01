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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.parciallendlyapp.R
import com.example.parciallendlyapp.ui.theme.Montserrat
import androidx.compose.runtime.getValue
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.ui.res.stringResource
import com.example.parciallendlyapp.components.BrandList
import com.example.parciallendlyapp.components.CategoryList
import com.example.parciallendlyapp.components.HeaderRow
import com.example.parciallendlyapp.components.ProductList
import com.example.parciallendlyapp.feature.home.domain.model.ProductModel
import com.example.parciallendlyapp.feature.shop.screens.models.BrandModel
import com.example.parciallendlyapp.feature.shop.screens.models.CategoryModel

@Composable
fun ShopScreen(
    navController: NavHostController
) {

    var searchText by remember {
        mutableStateOf("")
    }

    Scaffold(
        topBar = {
            TopBar(
                onProfileClick = {
                    navController.navigate(Routes.EDIT_PROFILE)
                },
                onNotificationClick = {
                    navController.navigate(Routes.NOTIFICATIONS)
                }
            )
        }
    ) { paddingValues ->

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

                SearchInput(
                    value = searchText,
                    onValueChange = {
                        searchText = it
                    },
                    placeholder = "Search for product",
                    modifier = Modifier.weight(1f)
                )

                IconButton(
                    onClick = {
                        navController.navigate(Routes.FILTER)
                    },
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
                categories = listOf(
                    CategoryModel(
                        stringResource(R.string.shop_category_phone),
                        R.drawable.shop_phone
                    ),
                    CategoryModel(
                        stringResource(R.string.shop_category_headphones),
                        R.drawable.shop_headphones
                    ),
                    CategoryModel(
                        stringResource(R.string.shop_category_laptop),
                        R.drawable.shop_laptop
                    ),
                    CategoryModel(
                        stringResource(R.string.shop_category_phone),
                        R.drawable.shop_phone
                    )
                )
            )

            Spacer(modifier = Modifier.height(25.dp))

            HeaderRow(
                title = stringResource(R.string.shop_popular_brands),
                onSeeAllClick = {}
            )

            Spacer(modifier = Modifier.height(16.dp))

            BrandList(
                brands = listOf(
                    BrandModel(
                        name = "Apple",
                        imageRes = R.drawable.shop_brand_apple_banner,
                        logoRes = R.drawable.shop_brand_jordan_logo
                    ),
                    BrandModel(
                        name = "Jordan",
                        imageRes = R.drawable.shop_brand_jordan_banner,
                        logoRes = R.drawable.shop_brand_jordan_logo
                    ),
                    BrandModel(
                        name = "Adidas",
                        imageRes = R.drawable.shop_brand_adidas_banner,
                        logoRes = R.drawable.shop_brand_jordan_logo
                    )
                )
            )

            Spacer(modifier = Modifier.height(25.dp))

            HeaderRow(
                title = stringResource(R.string.shop_recommended),
                onSeeAllClick = {}
            )

            Spacer(modifier = Modifier.height(16.dp))

            ProductList(
                products = listOf(
                    ProductModel(
                        name = "iPhone 12 Pro Max",
                        price = "₱1,200 × 24 mo",
                        imageRes = R.drawable.shop_phone
                    ),
                    ProductModel(
                        name = "Sony Headphones",
                        price = "₱1,200 × 24 mo",
                        imageRes = R.drawable.shop_headphones
                    ),
                    ProductModel(
                        name = "Nike Air Zoom",
                        price = "₱1,200 × 24 mo",
                        imageRes = R.drawable.shop_shoes
                    )
                )
            )

            Spacer(modifier = Modifier.height(25.dp))

            HeaderRow(
                title = stringResource(R.string.shop_best_sellers),
                onSeeAllClick = {}
            )

            Spacer(modifier = Modifier.height(16.dp))

            ProductList(
                products = listOf(
                    ProductModel(
                        name = "Surface Laptop",
                        price = "₱1,200 × 24 mo",
                        imageRes = R.drawable.shop_laptop2
                    ),
                    ProductModel(
                        name = "Iphone 12 Pro Max",
                        price = "₱1,200 × 24 mo",
                        imageRes = R.drawable.shop_shirt
                    ),
                    ProductModel(
                        name = "PS4 Play Station",
                        price = "₱1,200 × 24 mo",
                        imageRes = R.drawable.shop_ps4
                    )
                )
            )

        }
    }
}

@Composable
fun ShopBanner(
    currentPage: Int
) {

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
                    text = "Shop this season's Top Silhouette",
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
                        text = "Shop Now",
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
                                color =
                                    if (currentPage == index)
                                        Color.White
                                    else
                                        Color.White.copy(alpha = 0.3f),
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

    val pagerState = rememberPagerState(
        pageCount = { 3 }
    )

    Column {
        HorizontalPager(
            state = pagerState
        ) { page ->

            ShopBanner(
                currentPage = pagerState.currentPage
            )
        }
    }
}