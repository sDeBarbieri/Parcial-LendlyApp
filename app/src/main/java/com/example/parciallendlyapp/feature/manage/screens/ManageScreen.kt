package com.example.parciallendlyapp.feature.manage.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.parciallendlyapp.R
import androidx.navigation.NavHostController
import com.example.parciallendlyapp.navigation.Routes
@Composable
fun ManageScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 20.dp)
    ) {

        Spacer(modifier = Modifier.height(16.dp))

        HeaderSection()

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Manage",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Currently using as",
            color = Color.Gray,
            fontSize = 12.sp
        )
        Spacer(modifier = Modifier.height(12.dp))

        HorizontalDivider()

        Spacer(modifier = Modifier.height(12.dp))

        Account(navController)

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "General",
            color = Color.Gray,
            fontSize = 12.sp
        )
        Spacer(modifier = Modifier.height(12.dp))

        HorizontalDivider()

        Spacer(modifier = Modifier.height(12.dp))

        ManageItem(
            title = "Account details",
            iconRes = R.drawable.manage_icon_accounts,
            onClick = {
                navController.navigate(Routes.EDIT_PROFILE)
            }
        )

        ManageItem(
            title = "Receiving by email or phone",
            iconRes = R.drawable.manage_icon_unread
        )

        ManageItem(
            title = "Scheduled pay",
            iconRes = R.drawable.manage_icon_event
        )

        ManageItem(
            title = "Credit score",
            iconRes = R.drawable.manage_icon_readiness_score,
            onClick = {
                navController.navigate(Routes.CREDIT_SCORE)
            }
        )

        ManageItem(
            title = "Settings",
            iconRes = R.drawable.manage_icon_settings,
            onClick = {
                navController.navigate(Routes.SETTINGS)
            }
        )

        ManageItem(
            title = "Terms and Conditions",
            iconRes = R.drawable.manage_icon_description,
            onClick = {
                navController.navigate(Routes.TERMS)
            }
        )

        ManageItem(
            title = "Help",
            iconRes = R.drawable.manage_icon_question_mark,
            onClick = {
                navController.navigate(Routes.HELP)
            }
        )

        Spacer(modifier = Modifier.height(12.dp))

        HorizontalDivider()

        Spacer(modifier = Modifier.height(12.dp))

        ManageItem(
            title = "Log Out",
            iconRes = R.drawable.manage_icon_move_item,
            onClick = {}
        )

        Spacer(modifier = Modifier.height(80.dp))
    }
}

@Composable
private fun HeaderSection() {

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Icon(
            painter = painterResource(id = R.drawable.share_avatar),
            contentDescription = null,
            tint = Color.White
        )

        Icon(
            painter = painterResource(id = R.drawable.onboarding_logo),
            contentDescription = null,
            tint = Color.Unspecified,
            modifier = Modifier.size(48.dp)
        )

        Icon(
            painter = painterResource(id = R.drawable.share_notifications),
            contentDescription = null,
            tint = Color.White
        )
    }
}

@Composable
private fun Account(navController: NavHostController){
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Box(
            modifier = Modifier
                .size(36.dp)
                .clip(CircleShape)
                .background(Color(0xFFF2F2F2)),
            contentAlignment = Alignment.Center
        ) {

            Text(
                text = "GG",
                color = Color.Black,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier.width(12.dp))

        Column(
            modifier = Modifier.weight(1f)
        ) {

            Text(
                text = "Account details",
                fontWeight = FontWeight.Medium
            )

            Text(
                text = "Your personal Account",
                color = Color.Gray,
                fontSize = 12.sp
            )
        }

        Button(
            onClick = {
                navController.navigate(Routes.EDIT_PROFILE)
                      },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF71E56B)
            )
        ) {

            Text(
                text = "Edit",
                color = Color.Black
            )
        }
    }
}

@Composable
private fun ManageItem(
    title: String,
    iconRes: Int,
    onClick: () -> Unit = {}
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp, vertical = 16.dp)
            .clickable {
                onClick()
            },
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
                painter = painterResource(id = iconRes),
                contentDescription = null,
                tint = Color.Unspecified
            )
        }

        Spacer(modifier = Modifier.width(16.dp))

        Text(
            text = title,
            modifier = Modifier.weight(1f)
        )

        Icon(
            painter = painterResource(id = R.drawable.share_arrow_right),
            contentDescription = null,
            tint = Color.White
        )
    }
}