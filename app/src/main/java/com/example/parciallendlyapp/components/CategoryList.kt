package com.example.parciallendlyapp.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.parciallendlyapp.feature.shop.screens.models.CategoryModel

@Composable
fun CategoryList(
    categories: List<CategoryModel>
) {

    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        contentPadding = PaddingValues(end = 16.dp)
    ) {

        items(categories) { category ->

            CategoryCard(
                name = category.name,
                imageResId = category.imageRes
            )
        }
    }
}