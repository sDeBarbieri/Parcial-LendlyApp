package com.example.parciallendlyapp.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
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
import com.example.parciallendlyapp.ui.theme.BackgroundNeutral
import com.example.parciallendlyapp.ui.theme.ContentLink
import com.example.parciallendlyapp.ui.theme.Inter
import com.example.parciallendlyapp.ui.theme.SolidDark

@Composable
fun CashInItem(
    title: String,
    leadingIcon: Int,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(56.dp)
            .clickable { onClick() }
            .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        // --- ÍCONO CON CÍRCULO DETRÁS (Mismo estilo que el anterior) ---

        Icon(
            painter = painterResource(id = leadingIcon),
            contentDescription = null,
            modifier = Modifier.size(40.dp),
            tint = Color.Unspecified
        )


        // Título del Item (Sin Subtitle, centrado verticalmente por el Row)
        Text(
            text = title,
            modifier = Modifier
                .weight(1f)
                .height(20.dp),
            style = TextStyle(
                fontFamily = Inter,
                fontWeight = FontWeight.SemiBold, // 600
                fontSize = 14.sp,
                lineHeight = 20.sp,
                letterSpacing = 0.1.sp
            ),
            color = SolidDark
        )

        // Icono de la flecha
        Icon(
            painter = painterResource(id = R.drawable.home_arrow_forward),
            contentDescription = null,
            modifier = Modifier.size(width = 14.dp, height = 10.dp),
            tint = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}