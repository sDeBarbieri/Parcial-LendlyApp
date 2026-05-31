package com.example.parciallendlyapp.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.parciallendlyapp.ui.theme.BorderNeutral
import com.example.parciallendlyapp.ui.theme.ContentPrimary
import com.example.parciallendlyapp.ui.theme.ContentTertiary

@Composable
fun CardContent(
    imageResId: Int,
    title: String,
    description: String,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier.size(width = 178.5.dp, height = 260.dp),
        shape = RoundedCornerShape(8.dp),
        border = BorderStroke(1.dp, BorderNeutral),
        color = MaterialTheme.colorScheme.surface
    ) {
        Column(
            modifier = Modifier
                .padding(top = 32.dp, bottom = 32.dp, start = 16.dp, end = 16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            // Imagen: El espacio restante después de restar el bloque de texto y los paddings
            // Altura total (260) - Padding Vertical (64) - Altura Texto (104) - Gap (8) = 84dp
            Image(
                painter = painterResource(id = imageResId),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(84.dp)
            )

            // Bloque de Texto
            Column(
                modifier = Modifier
                    .width(146.5.dp)
                    .height(104.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                // El titulo usa Description.kt según las instrucciones
                Description(
                    text = title,
                    fontWeight = FontWeight.SemiBold,
                    color = ContentPrimary
                )
                // La descripción también usa el estilo base de Description
                Description(
                    text = description,
                    color = ContentTertiary
                )
            }
        }
    }
}
