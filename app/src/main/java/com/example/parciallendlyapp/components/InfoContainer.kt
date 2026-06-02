package com.example.parciallendlyapp.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.parciallendlyapp.ui.theme.*

@Composable
fun InfoContainer(
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier
            .width(361.dp)
            .height(297.dp),
        color = ContainerGray,
        shape = RoundedCornerShape(12.dp) // Corner/Medium
    ) {
        Column(
            modifier = Modifier
                .padding(24.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Description(
                text = "You can borrow up to",
                fontWeight = FontWeight.SemiBold,
                color = ContentPrimary
            )

            Text(
                text = "₱ 30,000.00",
                style = TextStyle(
                    fontFamily = Montserrat,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 40.sp,
                    color = ContentPrimary
                )
            )

            Text(
                text = "*Subject to evaluation",
                style = TextStyle(
                    fontFamily = Inter,
                    fontWeight = FontWeight.Medium,
                    fontSize = 14.sp,
                    color = LightGray
                )
            )

            Spacer(modifier = Modifier.height(2.dp))
            HorizontalDivider(color = BorderNeutral, thickness = 1.dp)

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Loan Details",
                    style = TextStyle(
                        fontFamily = Inter,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 16.sp,
                        color = ContentPrimary
                    )
                )
                Text(
                    text = "What is this?",
                    style = TextStyle(
                        fontFamily = Inter,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 16.sp,
                        color = GreenMain,
                        textDecoration = TextDecoration.Underline
                    )
                )
            }

            HorizontalDivider(color = BorderNeutral, thickness = 1.dp)
            Spacer(modifier = Modifier.height(2.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                InfoColumn(
                    label = "Payable in",
                    value = "6 - 12",
                    footer = "months",
                    modifier = Modifier.weight(1f)
                )
                
                VerticalDivider(
                    modifier = Modifier
                        .height(64.dp)
                        .padding(horizontal = 12.dp),
                    color = BorderNeutral,
                    thickness = 1.dp
                )

                InfoColumn(
                    label = "Interest Rate",
                    value = "1.99%",
                    footer = "ave per mo.",
                    modifier = Modifier.weight(1f)
                )

                VerticalDivider(
                    modifier = Modifier
                        .height(64.dp)
                        .padding(horizontal = 12.dp),
                    color = BorderNeutral,
                    thickness = 1.dp
                )

                InfoColumn(
                    label = "Process Fee",
                    value = "3%",
                    footer = "as low as",
                    modifier = Modifier.weight(1f)
                )
            }
        }
    }
}

@Composable
fun InfoColumn(
    label: String,
    value: String,
    footer: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Text(
            text = label,
            style = TextStyle(
                fontFamily = Inter,
                fontWeight = FontWeight.SemiBold,
                fontSize = 14.sp,
                color = ContentPrimary
            )
        )
        Title(
            text = value,
            color = ContentPrimary
        )
        Text(
            text = footer,
            style = TextStyle(
                fontFamily = Inter,
                fontWeight = FontWeight.Normal,
                fontSize = 14.sp,
                color = LightGray
            )
        )
    }
}
