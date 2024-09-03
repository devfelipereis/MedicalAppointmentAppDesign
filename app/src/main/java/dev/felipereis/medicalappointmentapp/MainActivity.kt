package dev.felipereis.medicalappointmentapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import dev.felipereis.medicalappointmentapp.ui.theme.MedicalAppointmentAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MedicalAppointmentAppTheme {
                // Tried to apply font globally. Not working
//                CompositionLocalProvider(
//                    LocalTextStyle provides TextStyle(
//                        fontFamily = FontFamily(Font(R.font.inter)),
//                    ).merge(
//                        LocalTextStyle.current.copy(
//                            fontFamily = null)
//                    )
//                ) {
                OnboardingScreen()
//                }
            }
        }
    }
}