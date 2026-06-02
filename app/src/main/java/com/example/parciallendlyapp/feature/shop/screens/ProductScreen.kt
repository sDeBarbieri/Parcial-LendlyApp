package com.example.parciallendlyapp.feature.shop.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.parciallendlyapp.R
import com.example.parciallendlyapp.components.CashInButton
import com.example.parciallendlyapp.components.DropdownSelector
import com.example.parciallendlyapp.components.GreenDivider
import com.example.parciallendlyapp.components.LendlyButton
import com.example.parciallendlyapp.components.SecondaryTopBar
import com.example.parciallendlyapp.feature.shop.screens.models.ProductInfoData
import com.example.parciallendlyapp.feature.shop.screens.models.getFeatureList
import com.example.parciallendlyapp.feature.shop.screens.models.getMerchantList
import com.example.parciallendlyapp.feature.shop.screens.models.getSpecsList
import com.example.parciallendlyapp.ui.theme.BackgroundNeutral
import com.example.parciallendlyapp.ui.theme.BackgroundOverlay
import com.example.parciallendlyapp.ui.theme.BackgroundScreen
import com.example.parciallendlyapp.ui.theme.ContentTertiary
import com.example.parciallendlyapp.ui.theme.Inter
import com.example.parciallendlyapp.ui.theme.InteractiveContrast
import com.example.parciallendlyapp.ui.theme.SolidDark

@Composable
fun ProductScreen(
    onBackClick: () -> Unit
) {
    val merchantList = getMerchantList();
    val featureList = getFeatureList();
    val specsList = getSpecsList();
    Scaffold(
        containerColor = BackgroundScreen,
        topBar = {
            SecondaryTopBar(
                title = stringResource(id= R.string.shop_brand_apple) + " " + stringResource(id= R.string.shop_product_iphone), // Puedes usar stringResource
                onBackClick = onBackClick
            )
        },
        bottomBar = {
            BottomComponent()
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
        ) {
            // Barra horizontal de características
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp),
                color = InteractiveContrast
            ) {
                Row(
                    modifier = Modifier.fillMaxSize(),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    ProductGreenTopBanner(
                        iconRes = R.drawable.shop_mood,
                        text = stringResource(id = R.string.shop_interest)
                    )
                    ProductGreenTopBanner(
                        iconRes = R.drawable.shop_tag,
                        text = stringResource(id = R.string.shop_installment)
                    )
                    ProductGreenTopBanner(
                        iconRes = R.drawable.shop_package,
                        text = stringResource(id = R.string.shop_pickup)
                    )
                }
            }
            Spacer(modifier = Modifier.height(16.dp))

            // Marco contenedor de la imagen del producto
            Box(
                modifier = Modifier
                    .fillMaxWidth() // CAMBIO: De 393.dp a fillMaxWidth
                    .height(219.dp),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.shop_product_iphone),
                    contentDescription = null,
                    modifier = Modifier
                        .width(178.dp)
                        .height(225.dp)
                        .offset(x = (0).dp, y = (-1).dp), // Ajuste top: -1px
                    contentScale = ContentScale.Fit
                )
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(bottom = 16.dp, end = 16.dp), // Margen interno respecto al borde
                    contentAlignment = Alignment.BottomEnd // Lo posiciona abajo a la derecha
                ) {
                    ChipComponent()
                }
            }

            ProductHeader(
                text = stringResource(id = R.string.product_low),
                price = stringResource(id = R.string.product_price),
                installment = stringResource(id = R.string.product_month),
                productName = stringResource(id = R.string.product_full_name)
            )

            Spacer(modifier = Modifier.height(16.dp))

            GreenDivider()

            Spacer(modifier = Modifier.height(24.dp))

            ProductSection(
                label = stringResource(id = R.string.product_location_text)
            ) {
                DropdownSelector(
                    text = stringResource(id = R.string.product_location),
                    leadingIcon = R.drawable.home_location_on,
                    onClick = { /* Lógica */ }
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            GreenDivider()

            Spacer(modifier = Modifier.height(24.dp))

            ProductSection(
                label = stringResource(id = R.string.product_marketplace_text)
            ) {
                merchantList.forEach { merchant ->
                    ProductInfoItem(data = merchant)
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            GreenDivider()

            Spacer(modifier = Modifier.height(24.dp))

            ProductSection(
                label = stringResource(id = R.string.product_features_title)
            ) {
                featureList.forEach { feature ->
                    ProductInfoItem(data = feature)
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            GreenDivider()

            Spacer(modifier = Modifier.height(24.dp))

            ProductSection(
                label = stringResource(id = R.string.product_specs_title)
            ) {
                specsList.forEach { feature ->
                    ProductInfoItem(data = feature)
                }
            }

            Spacer(modifier = Modifier.height(32.dp))


        }
    }
}



// Componentes internos



@Composable
fun ChipComponent(modifier: Modifier = Modifier) { // Agregamos el parámetro
    Surface(
        modifier = modifier // IMPORTANTE: Se aplica aquí
            .width(42.dp)
            .height(28.dp),
        shape = CircleShape,
        border = BorderStroke(1.dp, SolidDark.copy(alpha = 0.1f)),
        color = Color.White.copy(alpha = 0.8f)
    ) {
        Box(
            modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "1/4",
                modifier = Modifier
                    .width(18.dp)
                    .height(16.dp),
                style = TextStyle(
                    fontFamily = Inter,
                    fontWeight = FontWeight.Medium,
                    fontSize = 11.sp,
                    lineHeight = 16.sp,
                    letterSpacing = 0.5.sp,
                    textAlign = TextAlign.Center
                ),
                color = SolidDark
            )
        }
    }
}
@Composable
private fun ProductGreenTopBanner(
    iconRes: Int,
    text: String
) {
    Row(
        modifier = Modifier
            .width(110.dp)
            .height(28.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Contenedor del icono: 18x18
        Box(
            modifier = Modifier.size(18.dp),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = painterResource(id = iconRes),
                contentDescription = null,
                modifier = Modifier.size(14.25.dp),
                tint = SolidDark
            )
        }
        Text(
            text = text,
            modifier = Modifier
                .width(84.dp)
                .height(16.dp),
            style = TextStyle(
                fontFamily = Inter,
                fontWeight = FontWeight.Medium,
                fontSize = 11.sp,
                lineHeight = 16.sp,
                letterSpacing = 0.5.sp,
                textAlign = TextAlign.Center
            ),
            color = SolidDark,
            maxLines = 1
        )
    }
}

@Composable
private fun ProductHeader(
    text: String,
    price: String,
    installment: String,
    productName: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = Modifier
          //  .width(393.dp)
          //  .height(92.dp)
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp) // Gap: 8px
    ) {
        // Contenedor 1:
        Text(
            text = text,
            modifier = Modifier
                .width(361.dp)
                .height(16.dp),
            style = TextStyle(
                fontFamily = Inter,
                fontWeight = FontWeight.Medium,
                fontSize = 12.sp,
                lineHeight = 16.sp,
                letterSpacing = 0.5.sp
            ),
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )

        // Contenedor 2 y 3: Precio y cuotas
        Row(
            modifier = Modifier
                .width(361.dp)
                .height(36.dp),
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.spacedBy(8.dp) // Gap: 8px
        ) {
            // Precio (Montserrat SemiBold 28px)
            Text(
                text = price,
                style = TextStyle(
                    fontFamily = com.example.parciallendlyapp.ui.theme.Montserrat,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 28.sp,
                    lineHeight = 36.sp,
                    letterSpacing = 0.sp
                ),
                color = SolidDark
            )

            // Cuotas (Inter Medium 11px)
            Text(
                text = installment,
                modifier = Modifier
                    .width(59.dp)
                    .height(16.dp)
                    .padding(bottom = 4.dp), // Ajuste para alinear con la base del precio
                style = TextStyle(
                    fontFamily = Inter,
                    fontWeight = FontWeight.Medium,
                    fontSize = 11.sp,
                    lineHeight = 16.sp,
                    letterSpacing = 0.5.sp
                ),
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }

        // Último texto: Nombre del producto
        Text(
            text = productName,
            modifier = Modifier
                .width(361.dp)
                .height(24.dp),
            style = TextStyle(
                fontFamily = Inter,
                fontWeight = FontWeight.SemiBold,
                fontSize = 16.sp,
                lineHeight = 24.sp,
                letterSpacing = 0.15.sp
            ),
            color = SolidDark
        )
    }
}

@Composable
private fun ProductSection(
    label: String,
    content: @Composable () -> Unit
) {
    Column(
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .width(361.dp)
            .wrapContentHeight(),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Box(
            modifier = Modifier
                .width(361.dp)
                .height(24.dp)
                .padding(top = 4.dp, bottom = 4.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            Text(
                text = label,
                modifier = Modifier
                    .width(241.dp)
                    .height(16.dp),
                style = TextStyle(
                    fontFamily = Inter,
                    fontWeight = FontWeight.Medium,
                    fontSize = 12.sp,
                    lineHeight = 16.sp,
                    letterSpacing = 0.5.sp
                ),
                color = SolidDark
            )
        }

        content() // Aquí se inyectará el componente que desees (Dropdown, etc.)
    }
}

@Composable
private fun ProductInfoItem(
    data: ProductInfoData,
    modifier: Modifier = Modifier,
    onClick: (() -> Unit)? = null
) {
    val clickableModifier = if (onClick != null) Modifier.clickable { onClick() } else Modifier

    Row(
        modifier = modifier
            .fillMaxWidth()
            .then(clickableModifier)
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        // Icono Izquierda opcional
        data.logoRes?.let { logo ->
            Box(
                modifier = Modifier.size(40.dp),
                contentAlignment = Alignment.Center // Centra el icono de 24 dentro de los 40
            ) {
                Icon(
                    painter = painterResource(id = logo),
                    contentDescription = null,
                    // Si es icono aplicamos 24.dp, si es imagen/logo 40.dp
                    modifier = Modifier.size(if (data.isIcon) 24.dp else 40.dp),
                    // Si es icono aplicamos tinte, si es imagen (logo merchant) no
                    tint = if (data.isIcon) ContentTertiary else Color.Unspecified
                )
            }
        }

        // Columna de Textos
        Column(
            modifier = Modifier
                .weight(1f) // Ocupa todo el ancho restante
                .wrapContentHeight(), // Crece verticalmente según la cantidad de rows
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            // Título
            Text(
                text = data.title,
                modifier = Modifier
                    .width(145.dp)
                    .height(24.dp),
                style = TextStyle(
                    fontFamily = Inter,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 16.sp,
                    lineHeight = 24.sp,
                    letterSpacing = 0.15.sp
                ),
                color = SolidDark,
               // maxLines = 1
            )

            // --- BADGE OPCIONAL ---
            if (data.badgeText != null) {
                Surface(
                    modifier = Modifier
                        .width(124.dp)
                        .height(24.dp),
                    color = BackgroundNeutral,
                    shape = androidx.compose.foundation.shape.RoundedCornerShape(4.dp) // Extra-small
                ) {
                    Box(contentAlignment = Alignment.Center) {
                        Text(
                            text = data.badgeText!!,
                            modifier = Modifier
                                .width(108.dp)
                                .height(16.dp),
                            style = TextStyle(
                                fontFamily = Inter,
                                fontWeight = FontWeight.Medium,
                                fontSize = 11.sp,
                                lineHeight = 16.sp,
                                letterSpacing = 0.5.sp
                            ),
                            color = SolidDark
                        )
                    }
                }
            }
            // Fila 1 (Obligatoria)
            Text(
                text = data.row1,
                modifier = Modifier
                    .fillMaxWidth(),
                style = TextStyle(
                    fontFamily = Inter,
                    fontWeight = FontWeight.Medium,
                    fontSize = 12.sp,
                    lineHeight = 16.sp,
                    letterSpacing = 0.5.sp
                ),
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            // Mapeo dinámico de filas de texto
            val rows = listOfNotNull( data.row2, data.row3, data.row4)
            rows.forEach { rowText ->
                Text(
                    text = rowText,
                    modifier = Modifier
                        .fillMaxWidth(),
                    style = TextStyle(
                        fontFamily = Inter,
                        fontWeight = FontWeight.Medium,
                        fontSize = 11.sp,
                        lineHeight = 16.sp,
                        letterSpacing = 0.5.sp
                    ),
                    color = ContentTertiary
                )
            }
        }

        // Icono Flecha Derecha opcional
        if (data.showArrow) {
            Icon(
                imageVector = Icons.Default.KeyboardArrowDown, // O KeyboardArrowDown según prefieras
                contentDescription = null,
                modifier = Modifier.size(24.dp),
                tint = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}

@Composable
fun BottomComponent() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .navigationBarsPadding()
    ) {
        HorizontalDivider(color = BackgroundOverlay, thickness = 1.dp)
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Box(modifier = Modifier
                .width(200.dp)
                .height(56.dp),
                contentAlignment = Alignment.CenterStart
            ) {
                ProductHeader(
                    modifier = Modifier.fillMaxWidth(),
                    text = stringResource(id = R.string.product_low),
                    price = stringResource(id = R.string.product_price),
                    installment = stringResource(id = R.string.product_month),
                    productName = ""
                )
            }
            LendlyButton(
                text = stringResource(id = R.string.product_bottom_button_text),
                onClick = { /* Lógica */ },
                modifier = Modifier
                    .width(111.dp)
                    .height(48.dp),
                fontSize = 14.sp,
                shape = RoundedCornerShape(100.dp)
            )
        }
    }
}