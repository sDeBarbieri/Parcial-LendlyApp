package com.example.parciallendlyapp.components


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.parciallendlyapp.ui.theme.ContainerGray
import com.example.parciallendlyapp.ui.theme.Inter

@Composable
fun BrandCard(
    name: String,
    imageResId: Int,
    logoResId: Int
) {

    Surface(
        modifier = Modifier
            .width(160.dp)
            .height(140.dp),
        color = ContainerGray,
        shape = RoundedCornerShape(20.dp)
    ) {

        Column {

            Image(
                painter = painterResource(imageResId),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp),
                contentScale = ContentScale.Crop
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp)
                    .weight(1f),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Text(
                    text = name,
                    fontFamily = Inter,
                    fontWeight = FontWeight.Medium,
                    fontSize = 16.sp
                )

                Spacer(modifier = Modifier.weight(1f))

                Image(
                    painter = painterResource(logoResId),
                    contentDescription = null,
                    modifier = Modifier.size(24.dp).clip(CircleShape),
                )
            }
        }
    }
}