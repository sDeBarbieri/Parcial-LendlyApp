package com.example.parciallendlyapp.feature.manage.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.parciallendlyapp.R
import com.example.parciallendlyapp.navigation.Routes
import com.example.parciallendlyapp.ui.theme.Montserrat

@Composable
fun SuccessScreen(
    navController: NavHostController
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Box(
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .background(Color(0xFFEFEFEF))
                    .clickable {
                        navController.popBackStack()
                    },
                contentAlignment = Alignment.Center
            ) {

                Icon(
                    painter = painterResource(R.drawable.share_close),
                    contentDescription = "Close",
                    tint = Color.Unspecified
                )
            }

            Spacer(modifier = Modifier.weight(1f))

            Icon(
                painter = painterResource(id = R.drawable.onboarding_logo),
                contentDescription = null,
                tint = Color.Unspecified,
                modifier = Modifier.size(80.dp)
            )

            Spacer(modifier = Modifier.weight(1f))

            Box(
                modifier = Modifier.size(40.dp)
            )
        }

        Spacer(modifier = Modifier.height(80.dp))

        Icon(
            painter = painterResource(R.drawable.manage_check_mark_green),
            contentDescription = null,
            tint = Color.Unspecified,
            modifier = Modifier.size(220.dp)
        )

        Spacer(modifier = Modifier.height(32.dp))

        Text(
            text = "ALL DONE!",
            fontSize = 30.sp,
            fontFamily = Montserrat,
            fontWeight = FontWeight.SemiBold
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = "Your changes were saved"
        )

        Spacer(modifier = Modifier.weight(1f))

        Button(
            onClick = {
                navController.navigate(Routes.MANAGE) {
                    popUpTo(Routes.MANAGE) {
                        inclusive = false
                    }
                }
            },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF71E56B)
            )
        ) {
            Text(
                text = "Done",
                color = Color.Black
            )
        }

        Spacer(modifier = Modifier.height(24.dp))
    }
}