package com.example.parciallendlyapp.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.parciallendlyapp.R
import com.example.parciallendlyapp.ui.theme.ContentPrimary
import com.example.parciallendlyapp.ui.theme.Inter
import com.example.parciallendlyapp.ui.theme.InteractiveAccent

@Composable
fun CashInButton(
    text: String,
    iconResId: Int,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        modifier = modifier
            .width(120.dp)  // Ancho exacto
            .height(48.dp), // Alto exacto
        shape = RoundedCornerShape(24.dp), // Bordes más redondeados (píldora)
        colors = ButtonDefaults.buttonColors(
            containerColor = InteractiveAccent // Verde temporal, cámbialo luego
        ),
        contentPadding = androidx.compose.foundation.layout.PaddingValues(
            top = 10.dp,
            end = 24.dp,
            bottom = 10.dp,
            start = 16.dp
        )
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp) // Gap de 8px
        ) {
            Icon(
                painter = painterResource(id = iconResId),
                contentDescription = null,
                modifier = Modifier.size(10.5.dp), // Ajuste de tamaño para el icono
                tint = ContentPrimary
            )
            Text(
                text = text,
                style = TextStyle(
                    fontFamily = Inter,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 14.sp
                ),
                color = ContentPrimary
            )
        }
    }
}