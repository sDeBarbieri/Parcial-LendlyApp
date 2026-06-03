package com.example.parciallendlyapp.feature.notifications

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.parciallendlyapp.components.TopBar
import com.example.parciallendlyapp.ui.theme.Montserrat
import androidx.compose.material3.Scaffold
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import com.example.parciallendlyapp.R
import com.example.parciallendlyapp.ui.theme.Inter

@Composable
fun NotificationScreen(
    navController: NavHostController
) {

    Scaffold(
        topBar = {
            TopBar(navController = navController)
        }
    ) { paddingValues ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Icon(
                painter = painterResource(
                    R.drawable.share_notifications
                ),
                contentDescription = null,
                modifier = Modifier.size(72.dp),
                tint = Color.LightGray
            )

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "No notifications yet",
                fontFamily = Montserrat,
                fontSize = 24.sp,
                fontWeight = FontWeight.SemiBold
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = "Your loan activity, payment reminders, and account updates will appear here.",
                fontFamily = Inter,
                fontSize = 14.sp,
                color = Color.Gray,
                textAlign = TextAlign.Center
            )
        }
    }
}