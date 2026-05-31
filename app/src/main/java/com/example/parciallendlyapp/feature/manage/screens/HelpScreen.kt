package com.example.parciallendlyapp.feature.manage.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
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
fun HelpScreen(
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
            text = stringResource(R.string.help_center),
            fontFamily = Montserrat,
            fontWeight = FontWeight.ExtraBold,
            fontSize = 30.sp
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Need assistance? Our support team is here to help you.",
            fontFamily = Inter,
            fontSize = 16.sp,
            color = Color.Gray
        )

        Spacer(modifier = Modifier.height(32.dp))

        SectionTitle(stringResource(R.string.help_center_contact))

        InfoItem(
            title = "Email",
            value = "support@lendly.com"
        )

        InfoItem(
            title = "Phone",
            value = "+1 (800) 555-1234"
        )

        InfoItem(
            title = "Business Hours",
            value = "Monday - Friday, 9:00 AM - 6:00 PM"
        )

        Spacer(modifier = Modifier.height(24.dp))

        HorizontalDivider()

        Spacer(modifier = Modifier.height(24.dp))

        SectionTitle(stringResource(R.string.help_center_Questions))

        FAQItem(
            question = "How do I apply for a loan?",
            answer = "Navigate to the Loans section, complete the required information, and submit your application."
        )

        FAQItem(
            question = "How is my credit score calculated?",
            answer = "Your score is based on payment history, account activity, and other financial indicators."
        )

        FAQItem(
            question = "Can I update my personal information?",
            answer = "Yes. Go to Manage > Account Details to update your profile information."
        )

        FAQItem(
            question = "How do I contact support?",
            answer = "You can contact us through email or phone during business hours."
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
        fontSize = 20.sp,
        color = Color.White
    )
}

@Composable
private fun InfoItem(
    title: String,
    value: String
) {

    Spacer(modifier = Modifier.height(16.dp))

    Text(
        text = title,
        fontFamily = Inter,
        fontWeight = FontWeight.SemiBold,
        fontSize = 14.sp
    )

    Spacer(modifier = Modifier.height(4.dp))

    Text(
        text = value,
        fontFamily = Inter,
        fontSize = 14.sp,
        color = Color.Gray
    )
}

@Composable
private fun FAQItem(
    question: String,
    answer: String
) {

    Spacer(modifier = Modifier.height(16.dp))

    Text(
        text = question,
        fontFamily = Inter,
        fontWeight = FontWeight.SemiBold,
        fontSize = 15.sp
    )

    Spacer(modifier = Modifier.height(6.dp))

    Text(
        text = answer,
        fontFamily = Inter,
        fontSize = 14.sp,
        color = Color.Gray,
        lineHeight = 20.sp
    )
}