package com.example.parciallendlyapp.feature.auth.screens.register

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.parciallendlyapp.R
import com.example.parciallendlyapp.components.BackButton
import com.example.parciallendlyapp.components.InfoButton
import com.example.parciallendlyapp.components.LendlyButton
import com.example.parciallendlyapp.components.Title
import com.example.parciallendlyapp.ui.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreatePassword(
    onBackClick: () -> Unit = {},
    onInfoClick: () -> Unit = {},
    onNextClick: (String) -> Unit = {}
) {
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }

    Scaffold(
        containerColor = ContainerGray,
        topBar = {
            CenterAlignedTopAppBar(
                title = { },
                navigationIcon = {
                    BackButton(onClick = onBackClick)
                },
                actions = {
                    InfoButton(onClick = onInfoClick)
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = ContainerGray
                )
            )
        },
        bottomBar = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
            ) {
                HorizontalDivider(
                    thickness = 1.dp,
                    color = BorderNeutral
                )
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 24.dp, vertical = 16.dp)
                        .navigationBarsPadding()
                ) {
                    LendlyButton(
                        text = stringResource(id = R.string.create_password_next_button),
                        onClick = { onNextClick(password) },
                        containerColor = InteractiveAccent,
                        contentColor = ContentPrimary,
                        height = 48.dp
                    )
                }
            }
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(horizontal = 24.dp)
        ) {
            Spacer(modifier = Modifier.height(24.dp))

            Title(text = stringResource(id = R.string.create_password_title))

            Spacer(modifier = Modifier.height(32.dp))

            Text(
                text = stringResource(id = R.string.create_password_label),
                style = TextStyle(
                    fontFamily = Inter,
                    fontWeight = FontWeight.Normal,
                    fontSize = 14.sp,
                    color = ContentSecondary
                )
            )

            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                modifier = Modifier.fillMaxWidth(),
                placeholder = {
                    Text(
                        text = "********",
                        style = TextStyle(
                            fontFamily = Inter,
                            fontSize = 16.sp,
                            color = ContentSecondary.copy(alpha = 0.5f)
                        )
                    )
                },
                shape = RoundedCornerShape(12.dp),
                visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                trailingIcon = {
                    val image = if (passwordVisible)
                        Icons.Filled.Visibility
                    else Icons.Filled.VisibilityOff

                    IconButton(onClick = { passwordVisible = !passwordVisible }) {
                        Icon(
                            imageVector = image,
                            contentDescription = if (passwordVisible) {
                                stringResource(id = R.string.login_hide_password)
                            } else {
                                stringResource(id = R.string.login_show_password)
                            },
                            tint = ContentSecondary
                        )
                    }
                },
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = BorderNeutral,
                    unfocusedBorderColor = BorderNeutral,
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent,
                    cursorColor = ContentPrimary,
                    focusedTextColor = ContentPrimary,
                    unfocusedTextColor = ContentPrimary
                ),
                textStyle = TextStyle(
                    fontFamily = Inter,
                    fontWeight = FontWeight.Normal,
                    fontSize = 16.sp,
                    lineHeight = 24.sp,
                    letterSpacing = 0.5.sp,
                    platformStyle = PlatformTextStyle(includeFontPadding = false)
                ),
                singleLine = true
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = buildAnnotatedString {
                    append("At least ")
                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                        append("9 characters")
                    }
                    append(", containing a ")
                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                        append("letter")
                    }
                    append(" and a ")
                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                        append("number")
                    }
                },
                style = TextStyle(
                    fontFamily = Inter,
                    fontWeight = FontWeight.Normal,
                    fontSize = 14.sp,
                    lineHeight = 20.sp,
                    color = ContentSecondary
                )
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CreatePasswordPreview() {
    CreatePassword()
}
