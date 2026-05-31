package com.example.parciallendlyapp.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.parciallendlyapp.R
import com.example.parciallendlyapp.ui.theme.ContentPrimary
import com.example.parciallendlyapp.ui.theme.Inter
import com.example.parciallendlyapp.ui.theme.InteractiveContrast
import com.example.parciallendlyapp.ui.theme.OnboardingDescription
import com.example.parciallendlyapp.ui.theme.ParcialLendlyAppTheme

@Composable
fun InfoContainerProminent(
    title: String,
    description: String,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .size(width = 361.dp, height = 196.dp)
            .clip(MaterialTheme.shapes.large)
            .background(InteractiveContrast)
    ) {
        // La imagen de la chica se posiciona a la derecha
        Image(
            painter = painterResource(id = R.drawable.loan_basketball_sport_logo),
            contentDescription = null,
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .height(196.dp),
            contentScale = ContentScale.FillHeight
        )

        Column(
            modifier = Modifier
                .padding(20.dp)
                .fillMaxHeight()
                .width(220.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Chip "Limited Time Offer"
            Row(
                modifier = Modifier
                    .width(166.dp)
                    .height(32.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(OnboardingDescription)
                    .padding(start = 8.dp, top = 6.dp, end = 16.dp, bottom = 6.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.loan_alarm),
                    contentDescription = null,
                    tint = ContentPrimary,
                    modifier = Modifier.size(18.dp)
                )
                Text(
                    text = "Limited Time Offer",
                    style = TextStyle(
                        fontFamily = Inter,
                        fontWeight = FontWeight.Medium,
                        fontSize = 12.sp,
                        lineHeight = 16.sp,
                        letterSpacing = 0.5.sp,
                        color = ContentPrimary,
                        textAlign = TextAlign.Center
                    )
                )
            }

            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                Title(
                    text = title,
                    modifier = Modifier.fillMaxWidth()
                )

                Text(
                    text = description,
                    style = TextStyle(
                        fontFamily = Inter,
                        fontWeight = FontWeight.W400,
                        fontSize = 14.sp,
                        lineHeight = 20.sp,
                        letterSpacing = 0.25.sp,
                        color = ContentPrimary
                    )
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun InfoContainerProminentPreview() {
    ParcialLendlyAppTheme {
        Box(modifier = Modifier.padding(16.dp)) {
            InfoContainerProminent(
                title = "Safe and secure loans",
                description = "All here in Rayland"
            )
        }
    }
}
