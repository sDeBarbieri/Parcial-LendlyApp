package com.example.parciallendlyapp.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
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
import com.example.parciallendlyapp.ui.theme.*

@Composable
fun DropdownSelector(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    leadingIcon: Int? = null, // Puede ser null si no hay icono
    borderColor: Color = BorderNeutral
) {
    Surface(
        modifier = modifier
            .fillMaxWidth()
            .height(56.dp) // Altura estándar para inputs/selectors
            .clickable { onClick() },
        color = Color.Transparent,
        shape = RoundedCornerShape(8.dp),
        border = BorderStroke(1.dp, borderColor)
    ) {
        Row(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Contenedor de Texto + Icono opcional
            Row(
                modifier = Modifier.width(234.dp).height(24.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp) // Gap: 8px
            ) {
                if (leadingIcon != null) {
                    // Box de 24x24 para el icono
                    Box(
                        modifier = Modifier.size(24.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            painter = painterResource(id = leadingIcon),
                            contentDescription = null,
                            // Medidas exactas del dibujo interno
                            modifier = Modifier.size(width = 15.1.dp, height = 19.dp),
                            tint = ContentSecondary
                        )
                    }
                }

                Text(
                    text = text,
                    style = TextStyle(
                        fontFamily = Inter,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 16.sp,
                        color = SolidDark
                    )
                )
            }

            // Icono de flecha (Trailing)
            Icon(
                imageVector = Icons.Default.KeyboardArrowDown,
                contentDescription = null,
                tint = ContentSecondary,
                modifier = Modifier.size(24.dp)
            )
        }
    }
}