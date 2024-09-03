package dev.felipereis.medicalappointmentapp

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.add
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ScaffoldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.felipereis.medicalappointmentapp.ui.theme.DEFAULT_FONT_FAMILY

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyAppointmentScreen() {
    val topBarLeftPadding = 24.dp

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        Color.White,
                        Color(0xFFF8F8F8),
                    ),
                )
            )
    ) {
        Scaffold(
            containerColor = Color.Transparent,
            contentWindowInsets = ScaffoldDefaults.contentWindowInsets.add(WindowInsets(left = 24.dp, right = 24.dp)),
            topBar = {
                CenterAlignedTopAppBar(
                    colors = TopAppBarDefaults.topAppBarColors().copy(
                        containerColor = Color.White
                    ),
                    windowInsets = TopAppBarDefaults.windowInsets.add(
                        WindowInsets(
                            left = topBarLeftPadding,
                            top = 24.dp
                        )
                    ),
                    title = {
                        Text(
                            text = "My Appointment",
                            style = TextStyle(
                                fontFamily = DEFAULT_FONT_FAMILY,
                                color = Color(0xFF101010),
                                fontSize = 16.sp,
                                lineHeight = 16.sp * 1.5,
                                fontWeight = FontWeight.SemiBold
                            ),
                            modifier = Modifier.offset(-topBarLeftPadding)
                        )
                    },
                    navigationIcon = {
                        Icon(
                            painter = painterResource(R.drawable.back_icon),
                            contentDescription = "",
                            tint = Color(0xFF101010),
                            modifier = Modifier.size(24.dp)
                        )
                    }
                )
            }
        ) { paddingValues ->
            Column(
                verticalArrangement = Arrangement.spacedBy(24.dp),
                modifier = Modifier
                    .padding(paddingValues)
                    .padding(top = 24.dp),
            ) {
                DoctorInfoCard(
                    name = "Dr. Esther",
                    photo = R.drawable.doctor_1,
                    specialty = "Dentist",
                    rating = 4.5f,
                    reviewsCount = 400
                )
                DoctorExperience()
                AboutDoctor()
                Spacer(modifier = Modifier.weight(1f))
                VoiceCallButton()
            }
        }
    }
}


@Composable
fun DoctorInfoCard(
    modifier: Modifier = Modifier,
    @DrawableRes photo: Int,
    name: String,
    specialty: String,
    rating: Float,
    reviewsCount: Int
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(12.dp))
            .background(Color.White)
            .height(IntrinsicSize.Min)
    ) {
        Column(
            modifier = Modifier.padding(bottom = 20.dp)
        ) {
            Image(
                painter = painterResource(photo),
                contentDescription = "",
            )
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 12.dp)
            ) {
                Column(
                    verticalArrangement = Arrangement.spacedBy(4.dp),
                ) {
                    Text(
                        text = name,
                        style = TextStyle(
                            fontFamily = DEFAULT_FONT_FAMILY,
                            color = Color(0xFF101010),
                            fontSize = 16.sp,
                            lineHeight = 16.sp * 1.5,
                            fontWeight = FontWeight.SemiBold
                        )
                    )
                    Text(
                        text = specialty,
                        style = TextStyle(
                            fontFamily = DEFAULT_FONT_FAMILY,
                            color = Color(0xFF939393),
                            fontSize = 12.sp,
                            lineHeight = 12.sp * 1.5,
                            fontWeight = FontWeight.Light
                        )
                    )
                }
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        Icons.Rounded.Star,
                        contentDescription = "",
                        tint = Color(0xFFFFD33C),
                        modifier = Modifier.size(18.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = rating.toString(),
                        style = TextStyle(
                            fontFamily = DEFAULT_FONT_FAMILY,
                            color = Color(0xFF101010),
                            fontSize = 12.sp,
                            lineHeight = 12.sp * 1.5,
                            fontWeight = FontWeight.Medium
                        )
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = "($reviewsCount reviews)",
                        style = TextStyle(
                            fontFamily = DEFAULT_FONT_FAMILY,
                            color = Color(0xFF939393),
                            fontSize = 10.sp,
                            lineHeight = 10.sp * 1.5,
                            fontWeight = FontWeight.Normal
                        )
                    )
                }
            }
        }
    }
}

@Composable
fun DoctorExperience() {
    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = Modifier.fillMaxWidth()
    ) {
        DoctorExperienceItem(
            icon = R.drawable.patients_icon,
            primaryInfo = "120+",
            secondaryInfo = "Patients"
        )
        DoctorExperienceItem(
            icon = R.drawable.years_experience_icon,
            primaryInfo = "7+",
            secondaryInfo = "Years Exp"
        )
        DoctorExperienceItem(
            icon = R.drawable.rating_icon,
            primaryInfo = "4.5",
            secondaryInfo = "Rating"
        )
        DoctorExperienceItem(
            icon = R.drawable.reviews_icon,
            primaryInfo = "100+",
            secondaryInfo = "Reviews"
        )
    }
}

@Composable
fun DoctorExperienceItem(
    @DrawableRes icon: Int,
    primaryInfo: String,
    secondaryInfo: String,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(icon),
            contentDescription = "",
            modifier = Modifier.size(40.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = primaryInfo,
            style = TextStyle(
                fontFamily = DEFAULT_FONT_FAMILY,
                color = Color(0xFF101010),
                fontSize = 16.sp,
                lineHeight = 16.sp * 1.5,
            )
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = secondaryInfo,
            style = TextStyle(
                fontFamily = DEFAULT_FONT_FAMILY,
                color = Color(0xFF939393),
                fontSize = 12.sp,
                lineHeight = 12.sp * 1.2,
            )
        )
    }
}

@Composable
fun AboutDoctor() {
    val doctorDescription = remember {
        buildAnnotatedString {
            append("Dr. Carly Angel is the top most immunologists specialist in Crist Hospital in London, UK. ")
            withStyle(style = SpanStyle(color = Color(0xFF4C4DDC))) {
                append("Read More. . .")
            }
        }
    }

    Column {
        Text(
            text = "About Me",
            style = TextStyle(
                fontFamily = DEFAULT_FONT_FAMILY,
                color = Color(0xFF101010),
                fontSize = 16.sp,
                lineHeight = 16.sp * 1.5,
                fontWeight = FontWeight.Medium
            )
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = doctorDescription,
            style = TextStyle(
                fontFamily = DEFAULT_FONT_FAMILY,
                color = Color(0xFF939393),
                fontSize = 12.sp,
                lineHeight = 12.sp * 1.5,
                fontWeight = FontWeight.Light
            )
        )
    }
}

@Composable
fun VoiceCallButton() {
    Button(
        onClick = {},
        shape = RoundedCornerShape(14.dp),
        colors = ButtonDefaults.buttonColors().copy(
            containerColor = Color(0xFF4C4DDC)
        ),
        modifier = Modifier
            .fillMaxWidth()
            .defaultMinSize(minHeight = 56.dp)
    ) {
        Row {
            Icon(
                painterResource(R.drawable.call_icon),
                contentDescription = "",
                modifier = Modifier.size(20.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "Voice Call (14.30 - 15.00 PM)",
                style = TextStyle(
                    fontFamily = DEFAULT_FONT_FAMILY,
                    color = Color.White,
                    fontSize = 16.sp,
                    lineHeight = 16.sp * 1.5,
                    fontWeight = FontWeight.SemiBold
                ),
            )
        }
    }
}

@Composable
@Preview
fun MyAppointmentScreenPreview() {
    MyAppointmentScreen()
}