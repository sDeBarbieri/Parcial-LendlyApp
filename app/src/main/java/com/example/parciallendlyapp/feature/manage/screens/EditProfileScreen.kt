package com.example.parciallendlyapp.feature.manage.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.parciallendlyapp.R
import com.example.parciallendlyapp.navigation.Routes
import com.example.parciallendlyapp.ui.theme.Inter
import com.example.parciallendlyapp.ui.theme.Montserrat

@Composable
fun EditProfileScreen(
    navController: NavHostController
) {

    var firstName by remember { mutableStateOf("John D.") }
    var lastName by remember { mutableStateOf("Doe") }

    var day by remember { mutableStateOf("08") }
    var month by remember { mutableStateOf("12") }
    var year by remember { mutableStateOf("1997") }

    var address by remember { mutableStateOf("Somewhere IN BLOCK 12") }
    var city by remember { mutableStateOf("Davao City") }

    var postalCode by remember { mutableStateOf("8000") }

    var countryCode by remember { mutableStateOf("+65") }
    var phone by remember { mutableStateOf("991251255") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(20.dp)
    ) {

        IconButton(
            onClick = {
                navController.popBackStack()
            }
        ) {

            Icon(
                painter = painterResource(R.drawable.share_arrow_left),
                contentDescription = "Back",
                tint = Color.White
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = stringResource(R.string.profile_detail_title),
            fontSize = 26.sp,
            fontFamily = Montserrat,
            fontWeight = FontWeight.SemiBold
        )

        Spacer(modifier = Modifier.height(32.dp))

        Text(stringResource(
            R.string.profile_detail_first_name_label),
            fontFamily = Inter,
            fontWeight = FontWeight.Normal
        )

        Spacer(modifier = Modifier.height(6.dp))

        OutlinedTextField(
            value = firstName,
            onValueChange = { firstName = it },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(stringResource(
            R.string.profile_detail_last_name_label),
            fontFamily = Inter,
            fontWeight = FontWeight.Normal
        )

        Spacer(modifier = Modifier.height(6.dp))

        OutlinedTextField(
            value = lastName,
            onValueChange = { lastName = it },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(stringResource(
            R.string.profile_detail_dob_label),
            fontFamily = Inter,
            fontWeight = FontWeight.Normal
        )


        Spacer(modifier = Modifier.height(6.dp))

        Row {

            OutlinedTextField(
                value = day,
                onValueChange = { day = it },
                modifier = Modifier.weight(1f)
            )

            Spacer(modifier = Modifier.width(8.dp))

            OutlinedTextField(
                value = month,
                onValueChange = { month = it },
                modifier = Modifier.weight(1f)
            )

            Spacer(modifier = Modifier.width(8.dp))

            OutlinedTextField(
                value = year,
                onValueChange = { year = it },
                modifier = Modifier.weight(2f)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(stringResource(R.string.profile_detail_address_label),
            fontFamily = Inter,
            fontWeight = FontWeight.Normal
        )

        Spacer(modifier = Modifier.height(6.dp))

        OutlinedTextField(
            value = address,
            onValueChange = { address = it },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(stringResource(R.string.profile_detail_city_label),
            fontFamily = Inter,
            fontWeight = FontWeight.Normal
        )

        Spacer(modifier = Modifier.height(6.dp))

        OutlinedTextField(
            value = city,
            onValueChange = { city = it },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(stringResource(R.string.profile_detail_postal_code_label),
            fontFamily = Inter,
            fontWeight = FontWeight.Normal
        )

        Spacer(modifier = Modifier.height(6.dp))

        OutlinedTextField(
            value = postalCode,
            onValueChange = { postalCode = it },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(stringResource(R.string.profile_detail_phone_number_label),
            fontFamily = Inter,
            fontWeight = FontWeight.Normal
        )

        Spacer(modifier = Modifier.height(6.dp))

        Row {

            OutlinedTextField(
                value = countryCode,
                onValueChange = { countryCode = it },
                modifier = Modifier.width(90.dp)
            )

            Spacer(modifier = Modifier.width(8.dp))

            OutlinedTextField(
                value = phone,
                onValueChange = { phone = it },
                modifier = Modifier.weight(1f)
            )
        }

        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick = {
                navController.navigate(Routes.SUCCESS)
            },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF71E56B)
            )
        ) {

            Text(
                text = "Save",
                color = Color.Black
            )
        }

        Spacer(modifier = Modifier.height(24.dp))
    }
}