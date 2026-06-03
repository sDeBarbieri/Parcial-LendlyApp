package com.example.parciallendlyapp.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.parciallendlyapp.feature.home.domain.model.ProductModel

@Composable
fun ProductList(
    products: List<ProductModel>,
    modifier: Modifier = Modifier,
    onProductClick: (ProductModel) -> Unit
) {
    LazyRow(
        modifier = modifier
            .fillMaxWidth()
            .height(145.dp), // Altura exacta de la fila
        horizontalArrangement = Arrangement.spacedBy(8.dp), // Gap: 8px
        contentPadding = PaddingValues(horizontal = 0.dp) // Padding L/R: 16px
    ) {
        items(products) { product ->
            ProductCard(
                name = product.name,
                price = product.price,
                imageResId = product.imageRes,
                onClick = { onProductClick(product) }
            )
        }
    }
}