package com.example.parciallendlyapp.feature.shop.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
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
import com.example.parciallendlyapp.components.DropdownSelector
import com.example.parciallendlyapp.components.GreenDivider
import com.example.parciallendlyapp.components.SecondaryTopBar
import com.example.parciallendlyapp.ui.theme.BackgroundNeutral
import com.example.parciallendlyapp.ui.theme.BackgroundScreen
import com.example.parciallendlyapp.ui.theme.Inter
import com.example.parciallendlyapp.ui.theme.InteractiveContrast
import com.example.parciallendlyapp.ui.theme.SolidDark

@Composable
fun ProductScreen(
    onBackClick: () -> Unit
) {
    Scaffold(
        containerColor = BackgroundScreen,
        topBar = {
            SecondaryTopBar(
                title = stringResource(id= R.string.shop_brand_apple) + " " + stringResource(id= R.string.shop_product_iphone), // Puedes usar stringResource
                onBackClick = onBackClick
            )
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
                    .width(393.dp)
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
                ProductInfoItem(
                    title = "Lendly Express",
                    badgeText = "Verificado",
                    row1 = "Fast Delivery",
                    row2 = "Available in stock",
                    leadingIcon = R.drawable.shop_logo_the_loop,
                    showArrow = true,
                    onClick = { /* Lógica */ }
                )
            }

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
    productName: String
) {
    Column(
        modifier = Modifier
            .width(393.dp)
            .height(92.dp)
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
    title: String,
    row1: String,
    modifier: Modifier = Modifier,
    row2: String? = null,
    row3: String? = null,
    row4: String? = null,
    badgeText: String? = null,
    leadingIcon: Int? = null,
    showArrow: Boolean = false,
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
        if (leadingIcon != null) {
            Icon(
                painter = painterResource(id = leadingIcon),
                contentDescription = null,
                modifier = Modifier.size(24.dp),
                tint = Color.Unspecified
            )
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
                text = title,
                modifier = Modifier.fillMaxWidth(),
                style = TextStyle(
                    fontFamily = Inter,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 14.sp,
                    lineHeight = 20.sp
                ),
                color = SolidDark
            )

            // --- BADGE OPCIONAL ---
            if (badgeText != null) {
                Surface(
                    modifier = Modifier
                        .wrapContentWidth() // El badge se ajusta al texto (ej: "Verificado" vs "Vendedor destacado")
                        .height(24.dp),
                    color = BackgroundNeutral,
                    shape = androidx.compose.foundation.shape.RoundedCornerShape(4.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .padding(horizontal = 8.dp)
                            .fillMaxHeight(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = badgeText,
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
                text = row1,
                style = TextStyle(
                    fontFamily = Inter,
                    fontWeight = FontWeight.Medium,
                    fontSize = 12.sp,
                    lineHeight = 16.sp
                ),
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            // Mapeo dinámico de filas de texto
            val allRows = listOfNotNull(row1, row2, row3, row4)
            allRows.forEach { rowText ->
                Text(
                    text = rowText,
                    modifier = Modifier.fillMaxWidth(),
                    style = TextStyle(
                        fontFamily = Inter,
                        fontWeight = FontWeight.Normal,
                        fontSize = 12.sp,
                        lineHeight = 16.sp
                    ),
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }

        // Icono Flecha Derecha opcional
        if (showArrow) {
            Icon(
                imageVector = Icons.Default.KeyboardArrowDown, // O KeyboardArrowDown según prefieras
                contentDescription = null,
                modifier = Modifier.size(24.dp),
                tint = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}