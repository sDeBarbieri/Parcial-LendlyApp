package com.example.parciallendlyapp.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = InteractiveAccent,        // En modo oscuro suele usarse el color más brillante
    onPrimary = BaseDark,
    secondary = ContentSecondary,
    tertiary = InteractivePrimary,
    background = BaseDark,              // Fondo oscuro
    onBackground = BaseLight,           // Texto claro
    surface = BaseDark,
    onSurface = BaseLight,
    error = SentimentNegative,
    onTertiary = BaseLight
)

private val LightColorScheme = lightColorScheme(
    primary = InteractivePrimary,        // Tu verde oscuro principal
    onPrimary = BaseContrast,           // Texto blanco sobre primario
    secondary = ContentSecondary,       // Gris oscuro
    onSecondary = BaseContrast,
    tertiary = InteractiveAccent,       // Verde brillante para acentos
    background = BackgroundScreen,      // Blanco puro
    onBackground = ContentPrimary,      // Texto casi negro
    surface = BackgroundElevated,       // Blanco para tarjetas/superficies
    onSurface = ContentPrimary,
    error = SentimentNegative,          // Rojo de error
    onError = BaseContrast,
    outline = BorderNeutral,            // Color para bordes
    secondaryContainer = BackgroundNeutral, // Fondo suave para botones secundarios
    onTertiary = BaseDark,
    onSecondaryContainer = LightGray
)

@Composable
fun ParcialLendlyAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}