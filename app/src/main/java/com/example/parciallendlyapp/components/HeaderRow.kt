package com.example.parciallendlyapp.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun HeaderRow(
    title: String,
    onSeeAllClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(32.dp) // height: 32
            .padding(horizontal = 16.dp), // padding-right/left: 16px
        horizontalArrangement = Arrangement.SpaceBetween, // justify-content: space-between
        verticalAlignment = Alignment.CenterVertically
    ) {
        Subtitle(title = title)
        Box(
            modifier = Modifier
                .width(94.dp)
                .height(32.dp),
            contentAlignment = Alignment.CenterEnd
        ) {
            SeeAllButton(onClick = onSeeAllClick)
        }
    }
}