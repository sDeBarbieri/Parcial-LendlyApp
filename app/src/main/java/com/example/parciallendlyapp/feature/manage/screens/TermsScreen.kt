package com.example.parciallendlyapp.feature.manage.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.parciallendlyapp.R
import com.example.parciallendlyapp.ui.theme.Inter
import com.example.parciallendlyapp.ui.theme.Montserrat

@Composable
fun TermsScreen(
    navController: NavHostController
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
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
            text = stringResource(R.string.terms),
            fontFamily = Montserrat,
            fontWeight = FontWeight.ExtraBold,
            fontSize = 28.sp
        )

        Spacer(modifier = Modifier.height(24.dp))

        SectionTitle(stringResource(R.string.terms_Acceptance))

        SectionBody(
            "By using Lendly and its financial services, you agree to comply with and be bound by these Terms and Conditions. If you do not agree with any part of these terms, you should discontinue use of the application."
        )

        SectionTitle(stringResource(R.string.terms_Eligibility))

        SectionBody(
            "Users must be at least 18 years old and legally capable of entering into binding agreements. By registering an account, you confirm that all information provided is accurate and up to date."
        )

        SectionTitle(stringResource(R.string.terms_loan_services))

        SectionBody(
            "Lendly may offer loan and financial services subject to eligibility requirements, verification processes, and approval criteria. Approval is not guaranteed and may vary based on creditworthiness and other factors."
        )

        SectionTitle(stringResource(R.string.terms_privacy))

        SectionBody(
            "We collect and process personal information in accordance with our Privacy Policy. User data may be used to improve services, verify identity, prevent fraud, and comply with applicable laws."
        )

        SectionTitle(stringResource(R.string.terms_user_responsibilities))

        SectionBody(
            "Users are responsible for maintaining the confidentiality of their account credentials and for all activities conducted through their account."
        )

        SectionTitle(stringResource(R.string.terms_limitation_liability))

        SectionBody(
            "Lendly shall not be liable for any indirect, incidental, or consequential damages resulting from the use or inability to use the application or its services."
        )

        SectionTitle(stringResource(R.string.terms_changes_terms))

        SectionBody(
            "We reserve the right to modify these Terms and Conditions at any time. Continued use of the application after modifications constitutes acceptance of the updated terms."
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Last updated: May 2026",
            color = Color.Gray,
            fontFamily = Inter,
            fontSize = 12.sp
        )

        Spacer(modifier = Modifier.height(32.dp))
    }
}

@Composable
private fun SectionTitle(
    text: String
) {

    Text(
        text = text,
        fontFamily = Inter,
        fontWeight = FontWeight.SemiBold,
        fontSize = 18.sp,
        color = Color.White
    )

    Spacer(modifier = Modifier.height(8.dp))
}

@Composable
private fun SectionBody(
    text: String
) {

    Text(
        text = text,
        fontFamily = Inter,
        fontSize = 14.sp,
        color = Color.Gray,
        lineHeight = 22.sp
    )

    Spacer(modifier = Modifier.height(20.dp))
}