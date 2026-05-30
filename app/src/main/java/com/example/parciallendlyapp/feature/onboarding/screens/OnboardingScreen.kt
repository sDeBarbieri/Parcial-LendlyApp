package com.example.parciallendlyapp.feature.onboarding.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
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
import com.example.parciallendlyapp.feature.onboarding.domain.model.OnboardingPageModel
import com.example.parciallendlyapp.ui.theme.*
import kotlinx.coroutines.launch

@Composable
fun OnboardingScreen(onFinish: () -> Unit) {
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
        modifier = Modifier.fillMaxSize()
            .background(ContentPrimary)
    ) {
        // Logo Section
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 32.dp), // Solo padding arriba para el logo
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.onboarding_logo),
                contentDescription = "Lendly Logo",
                modifier = Modifier.size(width = 116.5.dp, height = 40.dp)
            )
        }

        // EL GAP DE 32PX (DP) CON EL LOGO
        Spacer(modifier = Modifier.height(32.dp))

        // Pager Section
        HorizontalPager(
            state = pagerState,
            modifier = Modifier.weight(1f),
            verticalAlignment = Alignment.Top // Alinea el contenido del pager al tope
        ) { position ->
            OnboardingContent(page = pages[position])
        }

        // Indicators and Buttons Section
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 32.dp, start = 32.dp, end = 32.dp),
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
                // Last Page: Log In and Sign up for free
                OutlinedButton(
                    onClick = { /* Handle Log In */ },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp), // Ajustado a 48px
                    shape = RoundedCornerShape(100.dp), // Ajustado a 100px
                    border = BorderStroke(1.dp, Color.White),
                    colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.White)
                ) {
                    Text(
                        text = "Log In",
                        fontFamily = Montserrat,
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp
                    )
                }

                Spacer(modifier = Modifier.height(8.dp)) // Gap ajustado a 8px

                Button(
                    onClick = { onFinish() },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = InteractiveAccent,
                        contentColor = ContentPrimary
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp), // Ajustado a 48px
                    shape = RoundedCornerShape(100.dp) // Ajustado a 100px
                ) {
                    Text(
                        text = "Sign up for free",
                        fontFamily = Montserrat,
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp
                    )
                }
            } else {
                // Other Pages: Get Started
                Button(
                    onClick = {
                        scope.launch {
                            pagerState.animateScrollToPage(pagerState.currentPage + 1)
                        }
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = InteractiveAccent,
                        contentColor = ContentPrimary // Cambiado a ContentPrimary para contraste
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp), // Ajustado a 48px
                    shape = RoundedCornerShape(100.dp) // Ajustado a 100px
                ) {
                    Text(
                        text = "Get Started",
                        fontFamily = Montserrat,
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp
                    )
                }
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
        // Contenedor de la imagen
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1.3f), // Reducimos un poco el peso para dar aire abajo
            contentAlignment = Alignment.BottomEnd // Alineamos al fondo y a la derecha
        ) {
            Image(
                painter = painterResource(id = page.imageRes),
                contentDescription = null,
                modifier = Modifier
                    .padding(start = 24.dp) // Margen izquierdo de Figma
                    .fillMaxWidth()
                    // Mantiene la forma 674x333 sin importar el dispositivo
                    .aspectRatio(674f / 333f),
                alignment = Alignment.CenterEnd,
                // FIT asegura que la imagen se vea COMPLETA sin recortes
                contentScale = ContentScale.Fit
            )
        }

        // Gap de 32dp exactos entre la imagen y el título
        Spacer(modifier = Modifier.height(32.dp))

        // Sección de textos
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(horizontal = 32.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top // Los textos empiezan arriba del espacio sobrante
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

