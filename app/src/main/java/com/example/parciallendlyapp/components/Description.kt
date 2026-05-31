package com.example.parciallendlyapp.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.sp
import com.example.parciallendlyapp.ui.theme.Inter

@Composable
fun Description(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colorScheme.onBackground,
    fontWeight: FontWeight = FontWeight.Normal, // Añadido
    textDecoration: TextDecoration = TextDecoration.None // Añadido
) {
    Text(
        text = text,
        modifier = modifier,
        style = TextStyle(
            fontFamily = Inter,
            fontWeight = fontWeight,
            fontSize = 16.sp,
            lineHeight = 24.sp,
            letterSpacing = 0.5.sp,
            color = color,
            textDecoration = textDecoration
        )
    )
}