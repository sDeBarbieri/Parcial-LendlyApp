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
            .width(120.dp)
            .height(160.dp)
            .clickable { onClick() },
        color = ContainerGray,
        shape = RoundedCornerShape(12.dp) // Corner/Medium
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp) // Gap solicitado
        ) {
            // Imagen centrada
            Image(
                painter = painterResource(id = imageResId),
                contentDescription = null,
                modifier = Modifier
                    .width(80.dp) // Reducido de 85.4dp
                    .height(60.dp) // Reducido de 65dp
                    .padding(4.dp), // Padding interno para achicar el dibujo
                contentScale = ContentScale.Fit
            )

            // Nombre del producto
            Text(
                text = name,
                modifier = Modifier.fillMaxWidth(), // Ocupa todo el ancho de la card
                maxLines = 1, // Evita que empuje el diseño hacia abajo
                overflow = TextOverflow.Ellipsis,
                style = TextStyle(
                    fontFamily = Inter,
                    fontWeight = FontWeight.Medium,
                    fontSize = 12.sp,
                    lineHeight = 16.sp,
                    letterSpacing = 0.5.sp,
                    textAlign = TextAlign.Center // Centrado horizontal
                ),
                color = MaterialTheme.colorScheme.onSurface
            )

            // Segundo campo de texto (Precio o descripción)
            Text(
                text = annotatedPrice,
                modifier = Modifier.fillMaxWidth(), // Usamos todo el ancho disponible
                maxLines = 1,
                style = TextStyle(
                    fontFamily = Inter,
                    fontWeight = FontWeight.Medium,
                    fontSize = 11.sp,
                    lineHeight = 16.sp,
                    letterSpacing = 0.5.sp,
                    textAlign = TextAlign.Center
                )
            )
        }
    }
}