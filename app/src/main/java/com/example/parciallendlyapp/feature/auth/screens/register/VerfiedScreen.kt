package com.example.parciallendlyapp.feature.auth.screens.register

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.parciallendlyapp.R
import com.example.parciallendlyapp.components.BackButton
import com.example.parciallendlyapp.components.Description
import com.example.parciallendlyapp.components.InfoButton
import com.example.parciallendlyapp.components.LendlyButton
import com.example.parciallendlyapp.components.Title
import com.example.parciallendlyapp.ui.theme.BorderNeutral
import com.example.parciallendlyapp.ui.theme.ContainerGray
import com.example.parciallendlyapp.ui.theme.ContentPrimary
import com.example.parciallendlyapp.ui.theme.ContentSecondary
import com.example.parciallendlyapp.ui.theme.Inter
import com.example.parciallendlyapp.ui.theme.InteractiveAccent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VerifiedScreen(
    onBackClick: () -> Unit = {},
    onInfoClick: () -> Unit = {},
    onNextClick: () -> Unit = {}
) {
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
                        text = stringResource(id = R.string.verified_next_button),
                        onClick = onNextClick,
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
                .padding(horizontal = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(62.dp))

            Image(
                painter = painterResource(id = R.drawable.login_shield),
                contentDescription = null,
                modifier = Modifier.size(width = 108.33.dp, height = 130.dp)
            )

            Spacer(modifier = Modifier.height(62.dp))

            Title(
                text = stringResource(id = R.string.verified_title),
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(12.dp))

            Description(
                text = stringResource(id = R.string.verified_subtitle),
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(32.dp))

            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(12.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                )
            ) {
                Column(
                    modifier = Modifier.padding(24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = stringResource(id = R.string.verified_card_title),
                        style = TextStyle(
                            fontFamily = Inter,
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 16.sp,
                            lineHeight = 24.sp,
                            letterSpacing = 0.15.sp,
                            color = ContentPrimary
                        )
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = stringResource(id = R.string.verified_card_desc),
                        style = TextStyle(
                            fontFamily = Inter,
                            fontWeight = FontWeight.Normal,
                            fontSize = 16.sp,
                            color = ContentSecondary,
                            textAlign = TextAlign.Center,
                            letterSpacing = 0.5.sp,
                            lineHeight = 24.sp
                        )
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun VerifiedScreenPreview() {
    VerifiedScreen()
}
