package dev.felipereis.medicalappointmentapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.felipereis.medicalappointmentapp.ui.theme.DEFAULT_FONT_FAMILY

@Composable
fun OnboardingScreen() {
    Box(modifier = Modifier.fillMaxSize()) {
        Background()
        Column(
            verticalArrangement = Arrangement.Bottom,
            modifier = Modifier.align(Alignment.BottomCenter)
        ) {
            DoctorImage()
            Headline()
        }
    }
}

@Composable
fun Background() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF4C4DDC))
    ) {
        Image(
            painter = painterResource(R.drawable.onboarding_texture),
            contentDescription = "",
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.7f)
                .align(Alignment.TopCenter)
        )
    }
}

@Composable
fun DoctorImage() {
    Image(
        painter = painterResource(R.drawable.doctor_onboarding),
        contentDescription = "",
        contentScale = ContentScale.Crop,
        modifier = Modifier.fillMaxWidth(),
    )
}

@Composable
fun Headline(modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .clip(shape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp))
            .background(Color.White)
            .padding(top = 32.dp, bottom = 56.dp)
            .padding(horizontal = 24.dp),
    ) {
        Text(
            text = "More Comfortable Chat With the Doctor",
            style = TextStyle(
                fontFamily = DEFAULT_FONT_FAMILY,
                fontSize = 24.sp,
                fontWeight = FontWeight.SemiBold,
                lineHeight = 32.sp,
                textAlign = TextAlign.Center,
            ),
            modifier = Modifier.padding(horizontal = 8.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Book an appointment with doctor. Chat with doctor via appointment letter and get consultation.",
            style = TextStyle(
                fontFamily = DEFAULT_FONT_FAMILY,
                color = Color(0xFF939393),
                fontSize = 14.sp,
                fontWeight = FontWeight.Light,
                lineHeight = 20.sp,
                textAlign = TextAlign.Center
            )
        )
        Spacer(modifier = Modifier.height(24.dp))
        Row(
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Box(
                modifier = Modifier
                    .size(8.dp)
                    .clip(CircleShape)
                    .background(Color(0xFFE0E0E3))
            )
            Box(
                modifier = Modifier
                    .size(8.dp)
                    .clip(CircleShape)
                    .background(Color(0xFFEDEDFC))
            )
            Box(
                modifier = Modifier
                    .width(24.dp)
                    .height(8.dp)
                    .clip(RoundedCornerShape(4.dp))
                    .background(Color(0xFF4C4DDC))
            )
        }
        Spacer(modifier = Modifier.height(24.dp))
        Button(
            shape = RoundedCornerShape(14.dp),
            colors = ButtonDefaults.buttonColors().copy(
                containerColor = Color(0xFF4C4DDC)
            ),
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            onClick = {}) {
            Text(
                text = "Get Started",
                style = TextStyle(
                    fontFamily = DEFAULT_FONT_FAMILY,
                    color = Color.White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    lineHeight = 16.sp * 1.5
                )
            )
        }
    }
}

@Composable
@Preview
fun OnboardingScreenPreview() {
    OnboardingScreen()
}