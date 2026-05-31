package com.example.parciallendlyapp.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.parciallendlyapp.R
import com.example.parciallendlyapp.ui.theme.BackgroundNeutral
import com.example.parciallendlyapp.ui.theme.ContentLink
import com.example.parciallendlyapp.ui.theme.ContentTertiary
import com.example.parciallendlyapp.ui.theme.Inter
import com.example.parciallendlyapp.ui.theme.SolidDark

@Composable
fun CashInOptionItem(
    title: String,
    subtitle: String,
    leadingIcon: Int,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // --- ÍCONO CON CÍRCULO DETRÁS ---
        Surface(
            modifier = Modifier
                .size(40.dp), // width: 40, height: 40
            shape = androidx.compose.foundation.shape.CircleShape, // Corner/Full
            color = BackgroundNeutral // Fondo gris claro
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.padding(8.dp) // Padding: 8px
            ) {
                Icon(
                    painter = painterResource(id = leadingIcon),
                    contentDescription = null,
                    modifier = Modifier.size(24.dp),
                    tint = ContentLink
                )
            }
        }

        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.Center
        ) {
            // Título del Item
            Text(
                text = title,
                modifier = Modifier.width(247.dp).height(20.dp),
                style = TextStyle(
                    fontFamily = Inter,
                    fontWeight = FontWeight.SemiBold, // 600
                    fontSize = 14.sp,
                    lineHeight = 20.sp,
                    letterSpacing = 0.1.sp
                ),
                color = SolidDark
            )

            Spacer(modifier = Modifier.height(8.dp))
            // Subtítulo del Item
            Text(
                text = subtitle,
                modifier = Modifier.width(247.dp).height(16.dp),
                style = TextStyle(
                    fontFamily = Inter,
                    fontWeight = FontWeight.Medium, // 500
                    fontSize = 12.sp,
                    lineHeight = 16.sp,
                    letterSpacing = 0.5.sp
                ),
                color = ContentTertiary
            )
        }

        Icon(
            painter = painterResource(id = R.drawable.home_arrow_forward),
            contentDescription = null,
            modifier = Modifier
                .size(width = 14.dp, height = 10.dp),
            tint = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}