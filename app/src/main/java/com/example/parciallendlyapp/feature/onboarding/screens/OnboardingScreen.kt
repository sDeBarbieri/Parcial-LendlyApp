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
import androidx.compose.ui.res.stringResource
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
            title = stringResource(id = R.string.onboarding_title_1),
            description = stringResource(id = R.string.onboarding_desc_1),
            imageRes = R.drawable.onboarding_1
        ),
        OnboardingPageModel(
            title = stringResource(id = R.string.onboarding_title_2),
            description = stringResource(id = R.string.onboarding_desc_2),
            imageRes = R.drawable.onboarding_2
        ),
        OnboardingPageModel(
            title = stringResource(id = R.string.onboarding_title_3),
            description = "", 
            imageRes = R.drawable.onboarding_3
        )
    )

    val pagerState = rememberPagerState(pageCount = { pages.size })
    val scope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(ContentPrimary)
    ) {
        // Logo Section
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 65.dp, bottom = 24.dp),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.onboarding_logo),
                contentDescription = stringResource(id = R.string.onboarding_logo_desc),
                modifier = Modifier.size(width = 116.5.dp, height = 40.dp),
                contentScale = androidx . compose . ui . layout . ContentScale.Fit
            )
        }

        //Spacer(modifier = Modifier.height(44.dp))

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
                .padding(start = 24.dp, end = 24.dp, bottom = 16.dp), // horizontal padding for ~361dp width
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
                    text = stringResource(id = R.string.onboarding_login),
                    onClick = onLoginClick,
                    containerColor = Color.Transparent,
                    contentColor = Color.White,
                    border = BorderStroke(1.dp, Color.White),
                    height = 48.dp
                )

                Spacer(modifier = Modifier.height(8.dp)) // Gap: 8px

                LendlyButton(
                    text = stringResource(id = R.string.onboarding_signup),
                    onClick = onSignUpClick,
                    containerColor = InteractiveAccent,
                    contentColor = ContentPrimary,
                    height = 48.dp
                )
            } else {
                LendlyButton(
                    text = stringResource(id = R.string.onboarding_get_started),
                    onClick = {
                        scope.launch {
                            pagerState.animateScrollToPage(pagerState.currentPage + 1)
                        }
                    },
                    containerColor = InteractiveAccent,
                    contentColor = ContentPrimary,
                    height = 48.dp
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
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(333.dp) // 1. ALTURA EXACTA SEGÚN TU INFO
                .padding(start = 24.dp), // 2. LEFT / PADDING-LEFT DE 24px
            contentAlignment = Alignment.CenterStart // 3. ALINEADO A LA IZQUIERDA
        ) {
            Image(
                painter = painterResource(id = page.imageRes),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    // No ponemos ancho fijo de 674 para evitar que rompa el layout,
                    // dejamos que escale proporcionalmente pero respetando el alto.
                    .fillMaxHeight(),
                contentScale = ContentScale.Crop // 4. MANTIENE PROPORCIÓN BASADO EN EL ALTO
            )
        }

        Spacer(modifier = Modifier.height(32.dp))

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp) // Adjusted for consistency
                .weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Text(
                text = page.title.uppercase(),
                color = OnboardingTitle,
                fontFamily = Montserrat,
                fontWeight = FontWeight.ExtraBold,
                fontSize = 32.sp,                  // FONT-SIZE: 32px
                lineHeight = 40.sp,                // LINE-HEIGHT: 40px
                letterSpacing = 0.sp,              // LETTER-SPACING: 0px
                textAlign = TextAlign.Center,      // TEXT-ALIGN: CENTER
                modifier = Modifier.fillMaxWidth()
            )

            if (page.description.isNotEmpty()) {
                Spacer(modifier = Modifier.height(12.dp))
                Text(
                    text = page.description,
                    color = OnboardingDescription,
                    fontFamily = Inter,
                    fontWeight = FontWeight.Normal, // FONT-WEIGHT: 400
                    fontSize = 22.sp,               // FONT-SIZE: 22px
                    lineHeight = 28.sp,             // LINE-HEIGHT: 28px
                    letterSpacing = 0.sp,           // LETTER-SPACING: 0px
                    textAlign = TextAlign.Center,   // TEXT-ALIGN: CENTER
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}
