package com.example.parciallendlyapp.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.parciallendlyapp.ui.theme.ContainerGray
import com.example.parciallendlyapp.ui.theme.ContentTertiary
import com.example.parciallendlyapp.ui.theme.Inter
import com.example.parciallendlyapp.ui.theme.InteractiveControl
import kotlin.text.append

@Composable
fun ProductCard(
    name: String,
    price: String,
    imageResId: Int,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    // Lógica para separar el color
    val annotatedPrice = buildAnnotatedString {
        val parts = price.split(" ", limit = 2)
        if (parts.size == 2) {
            // "₱1,200" en el color principal (onSurface)
            withStyle(style = SpanStyle(color = InteractiveControl)) {
                append(parts[0])
            }
            append(" ")
            // "x 24 mo" en color variante (grisáceo)
            withStyle(style = SpanStyle(color = ContentTertiary)) {
                append(parts[1])
            }
        } else {
            append(price)
        }
    }

    Surface(
        modifier = modifier
            .width(132.dp)  // Medida exacta
            .height(145.dp) // Medida exacta
            .clickable { onClick() },
        color = ContainerGray,
        shape = RoundedCornerShape(12.dp) // Corner/Medium
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp), // Padding solicitado de 16px
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            // Imagen centrada
            Image(
                painter = painterResource(id = imageResId),
                contentDescription = null,
                modifier = Modifier
                    .width(85.4.dp)
                    .height(65.dp),
                contentScale = ContentScale.Fit
            )
            Spacer(modifier = Modifier.height(8.dp)) // !!! PUEDE NO IR
            // Nombre del producto
            Column(
                modifier = Modifier
                    .width(100.dp)
                    .height(40.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp), // Gap interno solicitado
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Texto 1 (Nombre): 100x16
                Text(
                    text = name,
                    modifier = Modifier.width(100.dp).height(16.dp),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    style = TextStyle(
                        fontFamily = Inter,
                        fontWeight = FontWeight.Medium,
                        fontSize = 12.sp,
                        lineHeight = 16.sp,
                        textAlign = TextAlign.Center
                    ),
                    color = MaterialTheme.colorScheme.onSurface
                )

                // Texto 2 (Precio): 90x16
                Text(
                    text = annotatedPrice,
                    modifier = Modifier.width(90.dp).height(16.dp),
                    maxLines = 1,
                    style = TextStyle(
                        fontFamily = Inter,
                        fontWeight = FontWeight.Medium, // 500
                        fontSize = 11.sp,
                        lineHeight = 16.sp,
                        letterSpacing = 0.5.sp,
                        textAlign = TextAlign.Center
                    )
                )
            }
        }
    }
}