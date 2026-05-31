package com.example.parciallendlyapp.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
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
import com.example.parciallendlyapp.ui.theme.ContentTertiary
import com.example.parciallendlyapp.ui.theme.Inter
import com.example.parciallendlyapp.ui.theme.SolidDark

@Composable
fun OTCCashInItem(
    title: String,
    subtitle: String,
    leadingIcon: Int,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(72.dp) // Altura suficiente para el icono de 40dp y los dos textos
            .clickable { onClick() }
            .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(12.dp) // Gap entre icono y textos
    ) {
        // --- ÍCONO (Igual a OnlineCashInItem: sin Surface y con Color.Unspecified) ---
        Icon(
            painter = painterResource(id = leadingIcon),
            contentDescription = null,
            modifier = Modifier.size(40.dp),
            tint = Color.Unspecified
        )

        // --- COLUMNA DE TEXTOS (Igual a CashInOptionItem) ---
        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.Center
        ) {
            // Título del Item
            Text(
                text = title,
                modifier = Modifier
                    .width(247.dp)
                    .height(20.dp),
                style = TextStyle(
                    fontFamily = Inter,
                    fontWeight = FontWeight.SemiBold, // 600
                    fontSize = 14.sp,
                    lineHeight = 20.sp,
                    letterSpacing = 0.1.sp
                ),
                color = SolidDark,
                maxLines = 1
            )

            Spacer(modifier = Modifier.height(4.dp))

            // Subtítulo del Item
            Text(
                text = subtitle,
                modifier = Modifier
                    .width(247.dp)
                    .height(16.dp),
                style = TextStyle(
                    fontFamily = Inter,
                    fontWeight = FontWeight.Medium, // 500
                    fontSize = 12.sp,
                    lineHeight = 16.sp,
                    letterSpacing = 0.5.sp
                ),
                color = ContentTertiary,
                maxLines = 1
            )
        }

        // --- ICONO DE LA FLECHA ---
        Icon(
            painter = painterResource(id = R.drawable.home_arrow_forward),
            contentDescription = null,
            modifier = Modifier.size(width = 14.dp, height = 10.dp),
            tint = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}