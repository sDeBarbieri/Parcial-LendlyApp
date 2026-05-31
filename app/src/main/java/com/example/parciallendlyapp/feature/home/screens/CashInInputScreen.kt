package com.example.parciallendlyapp.feature.home.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.parciallendlyapp.R
import com.example.parciallendlyapp.components.BackButton
import com.example.parciallendlyapp.components.Title
import com.example.parciallendlyapp.ui.theme.ContainerGray
import com.example.parciallendlyapp.ui.theme.Inter
import com.example.parciallendlyapp.ui.theme.LightGray
import com.example.parciallendlyapp.ui.theme.Montserrat
import com.example.parciallendlyapp.ui.theme.SolidDark

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CashInInputScreen(
    onBackClick: () -> Unit
) {
    Scaffold(
        containerColor = ContainerGray,
        topBar = {
            CenterAlignedTopAppBar(
                windowInsets = WindowInsets(0, 0, 0, 0),
                title = {},
                navigationIcon = {
                    BackButton(onClick = onBackClick)
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = ContainerGray
                )
            )
        }
    ) { innerPadding ->
        CashInInputContent(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        )
    }
}

@Composable
fun CashInInputContent(
    modifier: Modifier = Modifier
) {
    var amount by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .padding(horizontal = 20.dp)
    ) {
        Spacer(modifier = Modifier.height(24.dp))

        // Reutilizamos tu componente Title
        Title(text = stringResource(id = R.string.online_cashin_input_screen_title))

        Spacer(modifier = Modifier.height(32.dp))

        // Texto 1: Label del input
        Text(
            text = stringResource(R.string.online_cashin_input_screen_1) + stringResource(R.string.home_balance_number), // O stringResource(R.string.cashin_enter_amount)
            modifier = Modifier
                .fillMaxWidth()
                .height(20.dp),
            style = TextStyle(
                fontFamily = Inter,
                fontWeight = FontWeight.SemiBold, // 600
                fontSize = 14.sp,
                lineHeight = 20.sp,
                letterSpacing = 0.1.sp
            ),
            color = LightGray
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Input Transparente con borde inferior
        BasicTextField(
            value = amount,
            onValueChange = { newValue ->
                // Lógica: Permitir dígitos y UN solo punto decimal
                if (newValue.all { it.isDigit() || it == '.' } &&
                    newValue.count { it == '.' } <= 1 &&
                    newValue.length <= 12) {
                    amount = newValue
                }
            },
            modifier = Modifier
                .fillMaxWidth() // Cambiado a fillMaxWidth para consistencia con el Surface
                .height(48.dp)
                .drawBehind {
                    val strokeWidth = 1.dp.toPx()
                    val y = size.height - strokeWidth / 2
                    drawLine(
                        color = SolidDark.copy(alpha = 0.2f),
                        start = Offset(0f, y),
                        end = Offset(size.width, y),
                        strokeWidth = strokeWidth
                    )
                },
            textStyle = TextStyle(
                fontFamily = Montserrat, // Usamos Montserrat también para el número ingresado
                fontWeight = FontWeight.SemiBold,
                fontSize = 24.sp,
                lineHeight = 32.sp,
                color = SolidDark,
                textAlign = androidx.compose.ui.text.style.TextAlign.Center
            ),
            cursorBrush = SolidColor(MaterialTheme.colorScheme.primary),
            singleLine = true,
            decorationBox = { innerTextField ->
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    // Lógica del Placeholder personalizado
                    if (amount.isEmpty()) {
                        Text(
                            text = stringResource(R.string.online_cashin_input_screen_placeholer),
                            modifier = Modifier
                                .width(125.dp)
                                .height(32.dp),
                            style = TextStyle(
                                fontFamily = Montserrat,
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 24.sp,
                                lineHeight = 32.sp,
                                letterSpacing = 0.sp,
                                textAlign = androidx.compose.ui.text.style.TextAlign.Center
                            ),
                            color = SolidDark.copy(alpha = 0.3f) // Color más tenue para el placeholder
                        )
                    }
                    innerTextField() //  donde se dibuja el texto que el usuario escribe
                }
            }
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Texto 2: Debajo del input
        Text(
            text = stringResource(R.string.online_cashin_input_screen_2), // Ejemplo
            modifier = Modifier
                .width(253.dp)
                .height(20.dp),
            style = TextStyle(
                fontFamily = Inter,
                fontWeight = FontWeight.SemiBold,
                fontSize = 12.sp,
                lineHeight = 20.sp
            ),
            color = LightGray
        )
    }
}