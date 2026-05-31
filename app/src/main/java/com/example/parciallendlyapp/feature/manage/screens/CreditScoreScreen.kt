package com.example.parciallendlyapp.feature.manage.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.parciallendlyapp.R
import com.example.parciallendlyapp.navigation.Routes
import com.example.parciallendlyapp.ui.theme.Inter
import com.example.parciallendlyapp.ui.theme.Montserrat

@Composable
fun CreditScoreScreen(
    navController: NavHostController
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(20.dp)
    ) {

        Icon(
            painter = painterResource(R.drawable.share_arrow_left),
            contentDescription = "Back",
            tint = Color.Unspecified,
            modifier = Modifier
                .size(24.dp)
                .clickable {
                    navController.popBackStack()
                }
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = stringResource(R.string.credit_score),
            fontSize = 30.sp,
            fontFamily = Montserrat,
            fontWeight = FontWeight.SemiBold
        )

        Spacer(modifier = Modifier.height(24.dp))

        CreditScoreCard()

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = stringResource(R.string.manage_general),
            color = Color.Gray,
            fontSize = 12.sp
        )

        Spacer(modifier = Modifier.height(12.dp))

        CreditItem(
            stringResource(R.string.manage_account_details),
            R.drawable.manage_icon_accounts,
            onClick = {
                navController.navigate(Routes.EDIT_PROFILE)
            }
        )

        CreditItem(
            stringResource(R.string.manage_receiving),
            R.drawable.manage_icon_unread,
            onClick = {}
        )

        CreditItem(
            stringResource(R.string.manage_scheduled_pay),
            R.drawable.manage_icon_event,
            onClick = {}
        )

        CreditItem(
            stringResource(R.string.manage_settings),
            R.drawable.manage_icon_settings,
            onClick = {
                navController.navigate(Routes.SETTINGS)
            }
        )
    }
}

@Composable
private fun CreditScoreCard() {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(androidx.compose.foundation.shape.RoundedCornerShape(16.dp))
            .background(Color(0xFFF8F5F5))
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Box(
            contentAlignment = Alignment.Center
        ) {

            Image(
                painter = painterResource(
                    R.drawable.manage_elipse_credit_score
                ),
                contentDescription = null,
                modifier = Modifier.fillMaxWidth()
            )

            Column(
                modifier = Modifier
                    .offset(y = 120.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    text = "720",
                    fontSize = 42.sp,
                    color = Color.Black,
                    fontFamily = Montserrat,
                    fontWeight = FontWeight.SemiBold
                )
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .offset(y = (-30).dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Text(
                text = "300",
                color = Color.Gray,
                fontSize = 18.sp,
                fontFamily = Inter,
                fontWeight = FontWeight.Normal
            )

            Text(
                text = "850",
                color = Color.Gray,
                fontSize = 18.sp,
                fontFamily = Inter,
                fontWeight = FontWeight.Normal
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        Row(
            horizontalArrangement = Arrangement.Center
        ) {

            Text(
                text = stringResource(R.string.credit_score_your_score_is),
                color = Color.Gray,
                fontFamily = Inter,
                fontWeight = FontWeight.Normal
            )

            Text(
                text = stringResource(R.string.credit_score_good),
                color = Color.Black,
                fontFamily = Montserrat,
                fontWeight = FontWeight.SemiBold
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        HorizontalDivider()

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = stringResource(R.string.credit_score_what_is),
            color = Color.Black,
            modifier = Modifier.fillMaxWidth(),
            fontFamily = Inter,
            fontWeight = FontWeight.SemiBold
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "This is your trust score, used as a basis to determine the various activities you do on Credit Score.",
            color = Color.Gray,
            fontSize = 12.sp
        )
    }
}

@Composable
private fun CreditItem(
    title: String,
    iconRes: Int,
    onClick: () -> Unit = {}
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(androidx.compose.foundation.shape.RoundedCornerShape(12.dp))
            .clickable {
                onClick()
            }
            .padding(vertical = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Box(
            modifier = Modifier
                .size(36.dp)
                .clip(CircleShape)
                .background(Color(0xFFF5F5F5)),
            contentAlignment = Alignment.Center
        ) {

            Icon(
                painter = painterResource(iconRes),
                contentDescription = null,
                tint = Color.Unspecified
            )
        }

        Spacer(modifier = Modifier.width(16.dp))

        Text(
            text = title,
            modifier = Modifier.weight(1f),
            fontFamily = Inter,
            fontWeight = FontWeight.Normal
        )

        Icon(
            painter = painterResource(
                R.drawable.share_arrow_right
            ),
            contentDescription = null,
            tint = Color.Unspecified
        )
    }
}