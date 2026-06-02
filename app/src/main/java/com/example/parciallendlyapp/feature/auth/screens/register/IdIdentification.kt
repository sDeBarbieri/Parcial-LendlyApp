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
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.parciallendlyapp.R
import com.example.parciallendlyapp.components.BackButton
import com.example.parciallendlyapp.components.Description
import com.example.parciallendlyapp.components.InfoButton
import com.example.parciallendlyapp.components.LendlyButton
import com.example.parciallendlyapp.components.Title
import com.example.parciallendlyapp.ui.theme.BorderNeutral
import com.example.parciallendlyapp.ui.theme.ContainerGray
import com.example.parciallendlyapp.ui.theme.ContentPrimary
import com.example.parciallendlyapp.ui.theme.InteractiveAccent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun IdIdentificationScreen(
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
                        text = stringResource(id = R.string.id_identification_next_button),
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
        ) {
            Column(
                modifier = Modifier
                    .padding(horizontal = 24.dp)
            ) {
                Spacer(modifier = Modifier.height(24.dp))

                Title(text = stringResource(id = R.string.id_identification_title))

                Spacer(modifier = Modifier.height(12.dp))

                Description(text = stringResource(id = R.string.id_identification_subtitle))

                Spacer(modifier = Modifier.height(32.dp))
            }

            Image(
                painter = painterResource(id = R.drawable.login_dni),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(357.dp),
                contentScale = ContentScale.Crop
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun IdIdentificationScreenPreview() {
    IdIdentificationScreen()
}
