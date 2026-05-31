package com.example.parciallendlyapp.components

import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.example.parciallendlyapp.R
import com.example.parciallendlyapp.ui.theme.ContentPrimary

@Composable
fun BackButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    contentDescription: String? = null
) {
    IconButton(
        onClick = onClick,
        modifier = modifier
    ) {
        Icon(
            painter = painterResource(id = R.drawable.share_arrow_left),
            contentDescription = "Back",
            tint = ContentPrimary
        )
    }
}