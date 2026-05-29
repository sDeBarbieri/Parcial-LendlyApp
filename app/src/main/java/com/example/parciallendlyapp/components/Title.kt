package com.example.parciallendlyapp.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.parciallendlyapp.ui.theme.ContentPrimary
import com.example.parciallendlyapp.ui.theme.Montserrat

@Composable
fun Title(
    text: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = text,
        modifier = modifier,
        style = TextStyle(
            fontFamily = Montserrat,
            fontWeight = FontWeight.SemiBold,
            fontSize = 28.sp,       // 28px
            lineHeight = 36.sp,     // 36px
            color = MaterialTheme.colorScheme.onBackground
        )
    )
}