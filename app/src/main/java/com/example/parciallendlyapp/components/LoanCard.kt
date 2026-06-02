package com.example.parciallendlyapp.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.parciallendlyapp.ui.theme.ContainerGray
import com.example.parciallendlyapp.ui.theme.Montserrat
import com.example.parciallendlyapp.ui.theme.Inter
import com.example.parciallendlyapp.ui.theme.LightGray

@Composable
fun LoanCard(
    loanName: String,
    amount: String,
    date: String,
    imageResId: Int,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier
            .width(361.dp)
            .height(76.dp),
        color = ContainerGray,
        shape = RoundedCornerShape(12.dp) // Corner/Medium aproximado
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(10.dp) // El gap solicitado
        ) {
            // 1. Imagen a la izquierda
            Image(
                painter = painterResource(id = imageResId),
                contentDescription = null,
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop
            )

            // 2. Nombre (al lado de la imagen)
            Text(
                text = loanName,
                modifier = Modifier.weight(1f), // Toma el espacio central
                style = TextStyle(
                    fontFamily = Inter,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 16.sp
                ),
                color = MaterialTheme.colorScheme.onSurface
            )

            // 3. Bloque a la derecha (Monto + Mes)
            Column(
                modifier = Modifier.width(110.dp), // Ancho especificado
                horizontalAlignment = Alignment.End,
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                // El número (Monto)
                Text(
                    text = amount,
                    modifier = Modifier.height(20.dp),
                    style = TextStyle(
                        fontFamily = Inter,
                        fontWeight = FontWeight.SemiBold, // 600
                        fontSize = 14.sp,
                        lineHeight = 20.sp,
                        letterSpacing = 0.1.sp,
                        textAlign = TextAlign.Right
                    ),
                    color = MaterialTheme.colorScheme.onSurface,
                    maxLines = 1, // Asegura que se mantenga en una línea
                    softWrap = false
                )
                // El texto inferior (Fecha/Mes)
                Text(
                    text = date,
                    modifier = Modifier.height(16.dp),
                    style = TextStyle(
                        fontFamily = Inter,
                        fontWeight = FontWeight.Medium, // 500
                        fontSize = 12.sp,
                        lineHeight = 16.sp,
                        letterSpacing = 0.5.sp,
                        textAlign = TextAlign.Right
                    ),
                    color = LightGray,
                    maxLines = 1, // Evita que salte de línea
                    softWrap = false // Evita que salte de línea
                )
            }
        }
    }
}