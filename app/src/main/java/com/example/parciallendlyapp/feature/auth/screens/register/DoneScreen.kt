package com.example.parciallendlyapp.feature.auth.screens.register

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.parciallendlyapp.R
import com.example.parciallendlyapp.components.LendlyButton
import com.example.parciallendlyapp.ui.theme.ContentPrimary
import com.example.parciallendlyapp.ui.theme.Inter
import com.example.parciallendlyapp.ui.theme.InteractiveAccent
import com.example.parciallendlyapp.ui.theme.Montserrat
import com.example.parciallendlyapp.ui.theme.OnboardingDescription
import com.example.parciallendlyapp.ui.theme.OnboardingTitle

@Composable
fun DoneScreen(
    onDoneClick: () -> Unit = {},
    onCloseClick: () -> Unit = {}
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(ContentPrimary)
            .padding(horizontal = 24.dp)
            .padding(top = 32.dp, bottom = 32.dp)
            .navigationBarsPadding()
    ) {
        // Logo Section (similar to OnboardingScreen but with a Close button)
        Box(
            modifier = Modifier
                .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            // Close Button
            IconButton(
                onClick = onCloseClick,
                modifier = Modifier
                    .align(Alignment.CenterStart)
                    .size(40.dp)
                    .background(Color.White.copy(alpha = 0.1f), CircleShape)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.share_close),
                    contentDescription = "Close",
                    tint = InteractiveAccent,
                    modifier = Modifier.size(24.dp)
                )
            }

            // Logo
            Image(
                painter = painterResource(id = R.drawable.onboarding_logo),
                contentDescription = "Lendly Logo",
                modifier = Modifier.size(width = 117.dp, height = 40.dp)
            )
        }

        Spacer(modifier = Modifier.height(104.dp))

        // Main Content
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.login_check_mark),
                contentDescription = null,
                modifier = Modifier.size(width = 183.dp, height = 330.dp)
            )

            Spacer(modifier = Modifier.height(62.dp))

            Text(
                text = "ALL DONE!",
                color = OnboardingTitle,
                fontFamily = Montserrat,
                fontWeight = FontWeight.ExtraBold,
                fontSize = 28.sp,
                lineHeight = 34.sp,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = "You’re ready to start a loan.",
                color = OnboardingDescription,
                fontFamily = Inter,
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp,
                lineHeight = 22.sp,
                textAlign = TextAlign.Center
            )
        }

        // Bottom Button
        LendlyButton(
            text = "Done",
            onClick = onDoneClick,
            containerColor = InteractiveAccent,
            contentColor = ContentPrimary,
            height = 48.dp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DoneScreenPreview() {
    DoneScreen()
}
