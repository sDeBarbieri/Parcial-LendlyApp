package com.example.parciallendlyapp.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.parciallendlyapp.ui.theme.ContainerGray
import com.example.parciallendlyapp.ui.theme.Inter

@Composable
fun CategoryCard(
    name: String,
    imageResId: Int,
    modifier: Modifier = Modifier
) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {

        Surface(
            modifier = modifier
                .width(100.dp)
                .height(100.dp),
            color = ContainerGray,
            shape = RoundedCornerShape(12.dp)
        ) {

            Image(
                painter = painterResource(imageResId),
                contentDescription = null,
                contentScale = ContentScale.Fit,
                modifier = Modifier.padding(10.dp)
            )
        }

        Text(
            text = name,
            style = TextStyle(
                fontFamily = Inter,
                fontSize = 12.sp
            )
        )
    }
}