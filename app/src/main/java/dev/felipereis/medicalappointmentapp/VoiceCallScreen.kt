package dev.felipereis.medicalappointmentapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.BlurEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.felipereis.medicalappointmentapp.ui.theme.DEFAULT_FONT_FAMILY

@Composable
fun VoiceCallScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painterResource(R.drawable.doctor_1),
            contentDescription = "",
            contentScale = ContentScale.FillHeight,
            modifier = Modifier
                .fillMaxSize()
                .graphicsLayer {
                    renderEffect = BlurEffect(
                        radiusX = 50f,
                        radiusY = 50f,
                    )
                },
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black.copy(alpha = 0.4f)),
        )

        Box(
            modifier = Modifier
                .align(Alignment.TopEnd)
                .offset((-24).dp, (76).dp)
                .clip(RoundedCornerShape(56.dp))
                .background(Color(0xFFEDEDFC).copy(alpha = 0.4f))
                .padding(horizontal = 12.dp, vertical = 4.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(8.dp)
                        .clip(CircleShape)
                        .background(Color.Red)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "19 : 00 Minute",
                    style = TextStyle(
                        fontFamily = DEFAULT_FONT_FAMILY,
                        color = Color.White,
                        fontSize = 12.sp,
                        lineHeight = 12.sp * 1.5,
                        fontWeight = FontWeight.Medium
                    )
                )
            }
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painterResource(R.drawable.doctor_1),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(100.dp)
                    .clip(CircleShape)
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "Dr. Esther",
                style = TextStyle(
                    fontFamily = DEFAULT_FONT_FAMILY,
                    color = Color.White,
                    fontSize = 20.sp,
                    lineHeight = 20.sp * 1.5,
                    fontWeight = FontWeight.SemiBold
                ),
            )
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.align(Alignment.BottomCenter)
        ) {
            Text(
                text = "Audio Recording is Active",
                style = TextStyle(
                    fontFamily = DEFAULT_FONT_FAMILY,
                    color = Color.White,
                    fontSize = 12.sp,
                    lineHeight = 12.sp * 1.5,
                    fontWeight = FontWeight.Medium
                ),
            )
            Spacer(modifier = Modifier.height(40.dp))
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 50.dp)
            ) {
                Image(painterResource(R.drawable.sound_icon), contentDescription = "", modifier = Modifier.size(40.dp))
                Spacer(modifier = Modifier.size(24.dp))
                Image(
                    painterResource(R.drawable.call_end_icon),
                    contentDescription = "",
                    modifier = Modifier.size(56.dp)
                )
                Spacer(modifier = Modifier.size(24.dp))
                Image(painterResource(R.drawable.mic_icon), contentDescription = "", modifier = Modifier.size(40.dp))
            }
        }
    }
}

@Composable
@Preview
fun VoiceCallScreenPreview() {
    VoiceCallScreen()
}