package com.example.parciallendlyapp.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.parciallendlyapp.R
import com.example.parciallendlyapp.ui.theme.ContentTertiary
import com.example.parciallendlyapp.ui.theme.Inter

@Composable
fun SearchInput(
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String,
    modifier: Modifier = Modifier
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier
            .fillMaxWidth()
            .height(56.dp),
        placeholder = {
            Text(
                text = placeholder,
                style = TextStyle(
                    fontFamily = Inter,
                    fontSize = 16.sp,
                    color = ContentTertiary
                )
            )
        },
        leadingIcon = {
            Icon(
                painter = painterResource(id = R.drawable.share_search),
                contentDescription = null,
                tint = ContentTertiary
            )
        },
        shape = RoundedCornerShape(12.dp),
        colors = OutlinedTextFieldDefaults.colors(
            unfocusedBorderColor = Color(0x1F0E0F0C),
            focusedBorderColor = Color(0x1F0E0F0C),
            cursorColor = MaterialTheme.colorScheme.primary
        ),
        singleLine = true
    )
}