package com.example.parciallendlyapp.feature.auth.screens.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.parciallendlyapp.R
import com.example.parciallendlyapp.components.LendlyButton
import com.example.parciallendlyapp.ui.theme.*

@Composable
fun LoginScreen(onLoginSuccess: () -> Unit) {
    var password by remember { mutableStateOf("123123123") }
    var passwordVisible by remember { mutableStateOf(false) }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = BackgroundScreen
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp, vertical = 32.dp)
        ) {
            Spacer(modifier = Modifier.height(80.dp))

            // Logo Section
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.onboarding_logo),
                    contentDescription = "Lendly Logo",
                    modifier = Modifier.size(width = 117.dp, height = 40.dp)
                )
            }

            Spacer(modifier = Modifier.height(80.dp))

            // User Info Section
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(48.dp)
                        .background(BackgroundNeutral, CircleShape),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "JD",
                        fontFamily = Inter,
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp,
                        color = ContentPrimary
                    )
                }

                Spacer(modifier = Modifier.width(16.dp))

                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = "John Doe",
                        fontFamily = Inter,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 16.sp,
                        color = ContentPrimary
                    )
                    Text(
                        text = "+63-923456790",
                        fontFamily = Inter,
                        fontWeight = FontWeight.Normal,
                        fontSize = 14.sp,
                        color = ContentTertiary
                    )
                }

                Text(
                    text = "Change",
                    fontFamily = Inter,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 14.sp,
                    color = ContentLink,
                    textDecoration = TextDecoration.Underline
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Password Field Section
            Text(
                text = "Password",
                fontFamily = Inter,
                fontWeight = FontWeight.Medium,
                fontSize = 14.sp,
                color = ContentSecondary,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(12.dp),
                visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                trailingIcon = {
                    val image = if (passwordVisible)
                        Icons.Filled.Visibility
                    else Icons.Filled.VisibilityOff

                    IconButton(onClick = { passwordVisible = !passwordVisible }) {
                        Icon(
                            imageVector = image,
                            contentDescription = if (passwordVisible) "Hide password" else "Show password",
                            tint = ContentSecondary
                        )
                    }
                },
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = BorderNeutral,
                    unfocusedBorderColor = BorderNeutral,
                    cursorColor = ContentPrimary,
                    focusedTextColor = ContentPrimary,
                    unfocusedTextColor = ContentPrimary
                ),
                singleLine = true
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = "Forgot your password?",
                fontFamily = Inter,
                fontWeight = FontWeight.SemiBold,
                fontSize = 14.sp,
                color = ContentLink,
                textDecoration = TextDecoration.Underline
            )

            Spacer(modifier = Modifier.weight(1f))

            // Login Button
            LendlyButton(
                text = "Log In",
                onClick = onLoginSuccess,
                containerColor = InteractiveAccent,
                contentColor = ContentPrimary
            )
        }
    }
}
