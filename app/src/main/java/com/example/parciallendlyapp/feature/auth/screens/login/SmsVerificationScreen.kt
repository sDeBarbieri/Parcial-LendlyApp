package com.example.parciallendlyapp.feature.auth.screens.login

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.parciallendlyapp.R
import com.example.parciallendlyapp.components.LendlyButton
import com.example.parciallendlyapp.ui.theme.BorderNeutral
import com.example.parciallendlyapp.ui.theme.ContainerGray
import com.example.parciallendlyapp.ui.theme.ContentPrimary
import com.example.parciallendlyapp.ui.theme.ContentSecondary
import com.example.parciallendlyapp.ui.theme.Inter
import com.example.parciallendlyapp.ui.theme.InteractiveAccent
import com.example.parciallendlyapp.ui.theme.Montserrat

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SmsVerificationScreen(
    phoneNumber: String = "******731",
    onBackClick: () -> Unit = {},
    onInfoClick: () -> Unit = {},
    onNextClick: (String) -> Unit = {},
    onResendClick: () -> Unit = {}
) {
    val otpValues = remember { mutableStateListOf("", "", "", "", "", "") }

    Scaffold(
        containerColor = ContainerGray,
        topBar = {
            CenterAlignedTopAppBar(
                title = { },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(
                            painter = painterResource(id = R.drawable.share_arrow_left),
                            contentDescription = stringResource(id = R.string.sms_verification_back_desc),
                            tint = ContentPrimary
                        )
                    }
                },
                actions = {
                    IconButton(onClick = onInfoClick) {
                        Icon(
                            painter = painterResource(id = R.drawable.share_info),
                            contentDescription = stringResource(id = R.string.sms_verification_info_desc),
                            tint = ContentPrimary
                        )
                    }
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
                        .padding(16.dp)
                        .navigationBarsPadding()
                ) {
                    LendlyButton(
                        text = stringResource(id = R.string.sms_verification_next_button),
                        onClick = { onNextClick(otpValues.joinToString("")) },
                        containerColor = InteractiveAccent,
                        contentColor = ContentPrimary,
                        height = 56.dp
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

            Text(
                text = stringResource(id = R.string.sms_verification_title),
                style = TextStyle(
                    fontFamily = Montserrat,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 28.sp,
                    lineHeight = 36.sp,
                    letterSpacing = 0.sp,
                    platformStyle = PlatformTextStyle(includeFontPadding = false)
                ),
                color = ContentPrimary
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = stringResource(id = R.string.sms_verification_subtitle, phoneNumber),
                style = TextStyle(
                    fontFamily = Inter,
                    fontWeight = FontWeight.Normal,
                    fontSize = 16.sp,
                    lineHeight = 24.sp,
                    letterSpacing = 0.5.sp,
                    platformStyle = PlatformTextStyle(includeFontPadding = false)
                ),
                color = ContentSecondary
            )

            Spacer(modifier = Modifier.height(32.dp))

            Text(
                text = stringResource(id = R.string.sms_verification_phone_label),
                style = TextStyle(
                    fontFamily = Inter,
                    fontWeight = FontWeight.Normal,
                    fontSize = 14.sp
                ),
                color = ContentSecondary
            )

            Spacer(modifier = Modifier.height(8.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                otpValues.forEachIndexed { index, value ->
                    OtpTextField(
                        value = value,
                        onValueChange = { newValue ->
                            if (newValue.length <= 1) {
                                otpValues[index] = newValue
                            }
                        },
                        modifier = Modifier.weight(1f)
                    )
                }
            }

            Spacer(modifier = Modifier.height(32.dp))

            Text(
                text = stringResource(id = R.string.sms_verification_resend_link),
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { onResendClick() },
                style = TextStyle(
                    fontFamily = Inter,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 16.sp,
                    color = Color(0xFF2D5C52), // A darker green for the link
                    textAlign = TextAlign.Center,
                    textDecoration = TextDecoration.Underline
                )
            )
        }
    }
}

@Composable
fun OtpTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier.height(56.dp),
        shape = RoundedCornerShape(12.dp),
        textStyle = TextStyle(
            fontFamily = Inter,
            fontSize = 18.sp,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Medium
        ),
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = BorderNeutral,
            unfocusedBorderColor = BorderNeutral,
            focusedContainerColor = Color.Transparent,
            unfocusedContainerColor = Color.Transparent
        ),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        singleLine = true
    )
}

@Preview(showBackground = true)
@Composable
fun SmsVerificationScreenPreview() {
    SmsVerificationScreen()
}
