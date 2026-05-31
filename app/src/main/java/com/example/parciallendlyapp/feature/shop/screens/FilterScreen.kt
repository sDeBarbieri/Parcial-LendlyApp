package com.example.parciallendlyapp.feature.shop.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.parciallendlyapp.R
import com.example.parciallendlyapp.components.FilterChipComponent
import com.example.parciallendlyapp.ui.theme.InteractiveAccent
import com.example.parciallendlyapp.ui.theme.Montserrat

@Composable
fun FilterScreen(
    navController: NavHostController
) {

    var selectedBrand by remember { mutableStateOf("All") }
    var selectedGender by remember { mutableStateOf("All") }
    var selectedSort by remember { mutableStateOf("Most Recent") }
    var selectedPrice by remember { mutableStateOf("All") }

    val brands = listOf(
        "All",
        "Nike",
        "Adidas",
        "Puma",
        "Jordan"
    )

    val genders = listOf(
        "All",
        "Men",
        "Women"
    )

    val sortOptions = listOf(
        "Most Recent",
        "Popular",
        "Low Interest"
    )

    val prices = listOf(
        "All",
        "$500 - $1000",
        "$1000 - $5000"
    )

    Scaffold { paddingValues ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(20.dp)
        ) {
            Icon(
                painter = painterResource(R.drawable.share_arrow_left),
                contentDescription = "Back",
                tint = Color.White,
                modifier = Modifier
                    .size(24.dp)
                    .clickable {
                        navController.popBackStack()
                    }
            )

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "Filter",
                fontFamily = Montserrat,
                fontWeight = FontWeight.SemiBold,
                fontSize = 24.sp
            )

            Spacer(modifier = Modifier.height(32.dp))

            FilterSection(
                title = "Brands",
                options = brands,
                selected = selectedBrand,
                onSelected = {
                    selectedBrand = it
                }
            )

            Spacer(modifier = Modifier.height(24.dp))

            FilterSection(
                title = "Gender",
                options = genders,
                selected = selectedGender,
                onSelected = {
                    selectedGender = it
                }
            )

            Spacer(modifier = Modifier.height(24.dp))

            FilterSection(
                title = "Sort by",
                options = sortOptions,
                selected = selectedSort,
                onSelected = {
                    selectedSort = it
                }
            )

            Spacer(modifier = Modifier.height(24.dp))

            FilterSection(
                title = "Price Range",
                options = prices,
                selected = selectedPrice,
                onSelected = {
                    selectedPrice = it
                }
            )

            Spacer(modifier = Modifier.weight(1f))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {

                OutlinedButton(
                    modifier = Modifier.weight(1f),
                    onClick = {

                        selectedBrand = "All"
                        selectedGender = "All"
                        selectedSort = "Most Recent"
                        selectedPrice = "All"
                    }
                ) {
                    Text("Reset Filter")
                }

                Button(
                    modifier = Modifier.weight(1f),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = InteractiveAccent
                    ),
                    onClick = {
                        navController.popBackStack()
                    }
                ) {
                    Text(
                        text = "Apply"
                    )
                }
            }
        }
    }
}
@Composable
private fun FilterSection(
    title: String,
    options: List<String>,
    selected: String,
    onSelected: (String) -> Unit
) {

    Text(
        text = title,
        fontWeight = FontWeight.SemiBold
    )

    Spacer(modifier = Modifier.height(12.dp))

    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {

        items(options) { option ->

            FilterChipComponent(
                text = option,
                isSelected = selected == option,
                onClick = {
                    onSelected(option)
                }
            )
        }
    }
}