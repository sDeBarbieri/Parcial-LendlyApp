package com.example.parciallendlyapp.feature.onboarding.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.parciallendlyapp.R
import com.example.parciallendlyapp.components.LendlyButton
import com.example.parciallendlyapp.feature.onboarding.domain.model.OnboardingPageModel
import com.example.parciallendlyapp.ui.theme.*
import kotlinx.coroutines.launch

@Composable
fun OnboardingScreen(
    onLoginClick: () -> Unit,
    onSignUpClick: () -> Unit
) {
    val pages = listOf(
        OnboardingPageModel(
            title = "QUICK LOANS",
            description = "Trusted for easy,\nfast loan approvals.",
            imageRes = R.drawable.onboarding_1
        ),
        OnboardingPageModel(
            title = "LOAN PRODUCT\nIN-APP",
            description = "Many products to loan.",
            imageRes = R.drawable.onboarding_2
        ),
        OnboardingPageModel(
            title = "TRACK & PAY\nEASILY",
            description = "", // No se ve descripción en la imagen 3
            imageRes = R.drawable.onboarding_3
        )
    )

    val pagerState = rememberPagerState(pageCount = { pages.size })
    val scope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(ContentPrimary)
            .padding(vertical = 32.dp) // Padding de 32dp en top y bottom solicitado
    ) {
        // Logo Section
        Box(
            modifier = Modifier
                .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.onboarding_logo),
                contentDescription = "Lendly Logo",
                modifier = Modifier.size(width = 116.5.dp, height = 40.dp)
            )
        }

        Spacer(modifier = Modifier.height(32.dp))

        // Pager Section
        HorizontalPager(
            state = pagerState,
            modifier = Modifier.weight(1f),
            verticalAlignment = Alignment.Top
        ) { position ->
            OnboardingContent(page = pages[position])
        }

        // Indicators and Buttons Section
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Pager Indicators (Dots)
            Row(
                Modifier
                    .height(20.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                repeat(pages.size) { iteration ->
                    val color = if (pagerState.currentPage == iteration) InteractiveAccent else InteractivePrimary
                    Box(
                        modifier = Modifier
                            .padding(horizontal = 4.dp)
                            .background(color, CircleShape)
                            .size(10.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            if (pagerState.currentPage == pages.size - 1) {
                LendlyButton(
                    text = "Log In",
                    onClick = onLoginClick,
                    containerColor = Color.Transparent,
                    contentColor = Color.White,
                    border = BorderStroke(1.dp, Color.White)
                )

                Spacer(modifier = Modifier.height(8.dp))

                LendlyButton(
                    text = "Sign up for free",
                    onClick = onSignUpClick,
                    containerColor = InteractiveAccent,
                    contentColor = ContentPrimary
                )
            } else {
                LendlyButton(
                    text = "Get Started",
                    onClick = {
                        scope.launch {
                            pagerState.animateScrollToPage(pagerState.currentPage + 1)
                        }
                    },
                    containerColor = InteractiveAccent,
                    contentColor = ContentPrimary
                )
            }
        }
    }
}

@Composable
fun OnboardingContent(page: OnboardingPageModel) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Contenedor de la imagen - ajustado para que ocupe más espacio y llene el ancho
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1.5f),
            contentAlignment = Alignment.BottomCenter
        ) {
            Image(
                painter = painterResource(id = page.imageRes),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth()
                    .padding(start = 24.dp), // Agregado 24dp de padding izquierdo
                contentScale = ContentScale.FillWidth
            )
        }

        Spacer(modifier = Modifier.height(32.dp))

        // Sección de textos
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp)
                .weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Text(
                text = page.title,
                color = OnboardingTitle,
                fontFamily = Montserrat,
                fontWeight = FontWeight.ExtraBold,
                fontSize = 28.sp,
                lineHeight = 34.sp,
                textAlign = TextAlign.Center
            )

            if (page.description.isNotEmpty()) {
                Spacer(modifier = Modifier.height(12.dp))
                Text(
                    text = page.description,
                    color = OnboardingDescription,
                    fontFamily = Inter,
                    fontWeight = FontWeight.Normal,
                    fontSize = 16.sp,
                    lineHeight = 22.sp,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}
