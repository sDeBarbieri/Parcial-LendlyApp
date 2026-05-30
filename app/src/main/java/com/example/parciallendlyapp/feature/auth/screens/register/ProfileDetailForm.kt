package com.example.parciallendlyapp.feature.auth.screens.register

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.parciallendlyapp.R
import com.example.parciallendlyapp.components.LendlyButton
import com.example.parciallendlyapp.ui.theme.BorderNeutral
import com.example.parciallendlyapp.ui.theme.ContainerGray
import com.example.parciallendlyapp.ui.theme.ContentPrimary
import com.example.parciallendlyapp.ui.theme.ContentSecondary
import com.example.parciallendlyapp.ui.theme.Inter
import com.example.parciallendlyapp.ui.theme.InteractiveAccent
import com.example.parciallendlyapp.ui.theme.Montserrat

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileDetailForm(
    onBackClick: () -> Unit = {},
    onInfoClick: () -> Unit = {},
    onNextClick: () -> Unit = {}
) {
    var firstName by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var dobDay by remember { mutableStateOf("") }
    var dobMonth by remember { mutableStateOf("") }
    var dobYear by remember { mutableStateOf("") }
    var address by remember { mutableStateOf("") }
    var city by remember { mutableStateOf("") }
    var postalCode by remember { mutableStateOf("") }
    var countryCode by remember { mutableStateOf("+65") }
    var phoneNumber by remember { mutableStateOf("") }

    val scrollState = rememberScrollState()

    Scaffold(
        containerColor = ContainerGray,
        topBar = {
            CenterAlignedTopAppBar(
                title = { },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(
                            painter = painterResource(id = R.drawable.share_arrow_left),
                            contentDescription = stringResource(id = R.string.profile_detail_back_desc),
                            tint = ContentPrimary
                        )
                    }
                },
                actions = {
                    IconButton(onClick = onInfoClick) {
                        Icon(
                            painter = painterResource(id = R.drawable.share_info),
                            contentDescription = stringResource(id = R.string.profile_detail_info_desc),
                            tint = ContentPrimary
                        )
                    }
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = ContainerGray
                )
            )
        },
        bottomBar = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
            ) {
                HorizontalDivider(
                    thickness = 1.dp,
                    color = BorderNeutral
                )
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 24.dp, vertical = 16.dp)
                        .navigationBarsPadding()
                ) {
                    LendlyButton(
                        text = stringResource(id = R.string.profile_detail_next_button),
                        onClick = onNextClick,
                        containerColor = InteractiveAccent,
                        contentColor = ContentPrimary,
                        height = 48.dp
                    )
                }
            }
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .verticalScroll(scrollState)
                .padding(horizontal = 24.dp)
        ) {
            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = stringResource(id = R.string.profile_detail_title),
                style = TextStyle(
                    fontFamily = Montserrat,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 28.sp,
                    lineHeight = 36.sp,
                    letterSpacing = 0.sp,
                    platformStyle = PlatformTextStyle(includeFontPadding = false)
                ),
                color = ContentPrimary
            )

            Spacer(modifier = Modifier.height(32.dp))

            // First Name
            ProfileFormField(
                label = stringResource(id = R.string.profile_detail_first_name_label),
                value = firstName,
                onValueChange = { firstName = it },
                placeholder = "John D."
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Last Name
            ProfileFormField(
                label = stringResource(id = R.string.profile_detail_last_name_label),
                value = lastName,
                onValueChange = { lastName = it },
                placeholder = "Doe"
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Date of Birth
            Text(
                text = stringResource(id = R.string.profile_detail_dob_label),
                style = TextStyle(
                    fontFamily = Inter,
                    fontWeight = FontWeight.Normal,
                    fontSize = 14.sp,
                    color = ContentSecondary
                )
            )
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = stringResource(id = R.string.profile_detail_dob_day_label),
                        style = TextStyle(fontFamily = Inter, fontSize = 12.sp, color = ContentSecondary)
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    ProfileTextField(
                        value = dobDay,
                        onValueChange = { if (it.length <= 2) dobDay = it },
                        placeholder = "08",
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                    )
                }
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = stringResource(id = R.string.profile_detail_dob_month_label),
                        style = TextStyle(fontFamily = Inter, fontSize = 12.sp, color = ContentSecondary)
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    ProfileTextField(
                        value = dobMonth,
                        onValueChange = { if (it.length <= 2) dobMonth = it },
                        placeholder = "12",
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                    )
                }
                Column(modifier = Modifier.weight(1.5f)) {
                    Text(
                        text = stringResource(id = R.string.profile_detail_dob_year_label),
                        style = TextStyle(fontFamily = Inter, fontSize = 12.sp, color = ContentSecondary)
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    ProfileTextField(
                        value = dobYear,
                        onValueChange = { if (it.length <= 4) dobYear = it },
                        placeholder = "1997",
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Address
            ProfileFormField(
                label = stringResource(id = R.string.profile_detail_address_label),
                value = address,
                onValueChange = { address = it },
                placeholder = "Somewhere IN BLOCK 12"
            )

            Spacer(modifier = Modifier.height(16.dp))

            // City
            ProfileFormField(
                label = stringResource(id = R.string.profile_detail_city_label),
                value = city,
                onValueChange = { city = it },
                placeholder = "Davao City"
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Postal Code
            ProfileFormField(
                label = stringResource(id = R.string.profile_detail_postal_code_label),
                value = postalCode,
                onValueChange = { postalCode = it },
                placeholder = "8000",
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Phone Number
            Text(
                text = stringResource(id = R.string.profile_detail_phone_number_label),
                style = TextStyle(
                    fontFamily = Inter,
                    fontWeight = FontWeight.Normal,
                    fontSize = 14.sp,
                    color = ContentSecondary
                )
            )
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                ProfileTextField(
                    value = countryCode,
                    onValueChange = { countryCode = it },
                    modifier = Modifier.width(84.dp),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone)
                )
                ProfileTextField(
                    value = phoneNumber,
                    onValueChange = { phoneNumber = it },
                    modifier = Modifier.weight(1f),
                    placeholder = "991251255",
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone)
                )
            }

            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}

@Composable
fun ProfileFormField(
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = label,
            style = TextStyle(
                fontFamily = Inter,
                fontWeight = FontWeight.Normal,
                fontSize = 14.sp,
                color = ContentSecondary
            )
        )
        Spacer(modifier = Modifier.height(8.dp))
        ProfileTextField(
            value = value,
            onValueChange = onValueChange,
            placeholder = placeholder,
            keyboardOptions = keyboardOptions
        )
    }
}

@Composable
fun ProfileTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    placeholder: String? = null,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier.fillMaxWidth(),
        placeholder = placeholder?.let {
            {
                Text(
                    text = it,
                    style = TextStyle(
                        fontFamily = Inter,
                        fontSize = 16.sp,
                        color = ContentSecondary.copy(alpha = 0.5f)
                    )
                )
            }
        },
        shape = RoundedCornerShape(12.dp),
        textStyle = TextStyle(
            fontFamily = Inter,
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp,
            lineHeight = 24.sp,
            letterSpacing = 0.5.sp,
            platformStyle = PlatformTextStyle(includeFontPadding = false)
        ),
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = BorderNeutral,
            unfocusedBorderColor = BorderNeutral,
            focusedContainerColor = Color.Transparent,
            unfocusedContainerColor = Color.Transparent
        ),
        keyboardOptions = keyboardOptions,
        singleLine = true
    )
}

@Preview(showBackground = true)
@Composable
fun ProfileDetailFormPreview() {
    ProfileDetailForm()
}
