package dev.felipereis.medicalappointmentapp

import android.annotation.SuppressLint
import androidx.annotation.DrawableRes
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.felipereis.medicalappointmentapp.ui.theme.DEFAULT_FONT_FAMILY

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen() {
    val bottomBarHeight = 90.dp
    val contentPadding = remember {
        PaddingValues(bottom = bottomBarHeight + 16.dp)
    }
    Scaffold(
        containerColor = Color(0xFFF8F8F8),
        bottomBar = { BottomBar() }
    ) {
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(24.dp),
            contentPadding = contentPadding
        ) {
            item { Header() }
            item { Categories() }
            item { FavoriteDoctors() }
            item { TopDoctors() }
        }
    }
}

@Composable
fun BottomBar() {
    var selectedTab by remember { mutableIntStateOf(0) }

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .height(90.dp)
            .background(Color.White)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxSize()
        ) {
            intArrayOf(
                R.drawable.home_icon,
                R.drawable.calendar_icon,
                R.drawable.chat_icon,
                R.drawable.user_icon
            ).forEachIndexed { index, icon ->
                BottomBarItem(
                    icon = icon,
                    index = index,
                    isSelected = selectedTab == index,
                    onTap = { selectedTab = index }
                )
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun BottomBarItem(
    @DrawableRes icon: Int,
    index: Int,
    isSelected: Boolean = false,
    onTap: (index: Int) -> Unit
) {
    val animatedColor = animateColorAsState(
        targetValue = if (isSelected) Color(0xFF4C4DDC) else Color(0xFF939393),
        label = "bottomBarAnimatedColor"
    )

    Icon(
        painter = painterResource(icon),
        contentDescription = "",
        tint = animatedColor.value,
        modifier = Modifier
            .size(32.dp)
            .combinedClickable(
                onClick = { onTap(index) },
                interactionSource = remember { MutableInteractionSource() },
                indication = null
            )
    )
}

@Composable
fun Header() {
    Box(
        modifier = Modifier
            .height(220.dp)
            .fillMaxWidth()
            .background(Color(0xFF4C4DDC))
    ) {
        Image(
            painter = painterResource(R.drawable.home_header_texture),
            contentDescription = "",
            modifier = Modifier.fillMaxSize()
        )
        ProfileInfo()
    }
}

@Composable
fun ProfileInfo() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 24.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.user_photo),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(48.dp)
                    .clip(CircleShape)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column(
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Text(
                    text = "Hello, Welcome  \uD83C\uDF89",
                    style = TextStyle(
                        fontFamily = DEFAULT_FONT_FAMILY,
                        color = Color.White,
                        fontSize = 14.sp,
                        lineHeight = 14.sp * 1.2
                    )
                )
                Text(
                    text = "Savannah Nguyen",
                    style = TextStyle(
                        fontFamily = DEFAULT_FONT_FAMILY,
                        color = Color.White,
                        fontSize = 20.sp,
                        lineHeight = 20.sp * 1.5
                    )
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            Box(
                modifier = Modifier.size(24.dp)
            ) {
                Icon(
                    painter = painterResource(R.drawable.notification_icon),
                    contentDescription = "",
                    tint = Color.White
                )
                Box(
                    contentAlignment = Alignment.TopEnd,
                    modifier = Modifier.fillMaxSize()
                ) {
                    Box(
                        modifier = Modifier
                            .size(8.dp)
                            .offset((-3).dp)
                            .clip(CircleShape)
                            .background(Color(0xFFFF0000))
                    )
                }

            }

        }
        Spacer(modifier = Modifier.height(24.dp))
        SearchField()
    }
}

@Composable
fun SearchField() {
    var search by remember { mutableStateOf("") }

    OutlinedTextField(
        singleLine = true,
        value = search,
        onValueChange = { search = it },
        shape = RoundedCornerShape(14.dp),
        placeholder = {
            Text(
                "Search Doctor...",
                color = Color(0xFFEDEDFC).copy(alpha = 0.4f),
                modifier = Modifier.offset((-8).dp)
            )
        },
        leadingIcon = {
            Icon(
                painterResource(R.drawable.search_normal),
                contentDescription = "",
                tint = Color(0xFFEDEDFC).copy(alpha = 0.4f),

                )
        },
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = Color(0xFFEDEDFC).copy(alpha = 0.2f),
            unfocusedBorderColor = Color(0xFFEDEDFC).copy(alpha = 0.2f),
        ),
        modifier = Modifier
            .defaultMinSize(minHeight = 53.dp)
            .fillMaxWidth(),
    )
}

@Composable
fun Categories() {
    var selectedCategoryIndex by remember { mutableIntStateOf(0) }

    Row(
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        modifier = Modifier.horizontalScroll(rememberScrollState())
    ) {
        Spacer(modifier = Modifier.width(24.dp))
        arrayListOf(
            "\uD83D\uDD25 All",
            "\uD83E\uDD12 Fever",
            "\uD83E\uDD27 Cough",
            "\uD83E\uDD22 Nauseated"
        ).forEachIndexed { index, text ->
            CategoryItem(
                text = text,
                index = index,
                isSelected = selectedCategoryIndex == index,
                onTap = { selectedCategoryIndex = index }
            )
        }
        Spacer(modifier = Modifier.width(24.dp))
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CategoryItem(
    index: Int,
    text: String,
    isSelected: Boolean = false,
    onTap: (index: Int) -> Unit
) {
    val backgroundColor = animateColorAsState(
        targetValue = if (isSelected) Color(0xFF4C4DDC) else Color(0xFFEDEDFC).copy(alpha = 0.4f),
        label = "categoryItemBackgroundColor"
    )
    val textColor = animateColorAsState(
        targetValue = if (isSelected) Color.White else Color(0xFF939393),
        label = "categoryItemTextColor"
    )

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .clip(RoundedCornerShape(8.dp))
            .background(backgroundColor.value)
            .padding(horizontal = 12.dp, vertical = 8.dp)
            .combinedClickable(
                onClick = { onTap(index) },
                interactionSource = remember { MutableInteractionSource() },
                indication = null
            )
    ) {
        Text(
            text = text,
            style = TextStyle(
                fontFamily = DEFAULT_FONT_FAMILY,
                color = textColor.value,
                fontWeight = FontWeight.Medium,
                fontSize = 14.sp,
                lineHeight = 14.sp * 1.5
            ),
        )
    }
}

@Composable
fun FavoriteDoctors() {
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier.padding(horizontal = 24.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth(),
        ) {
            Text(
                text = "Favourite Doctor",
                style = TextStyle(
                    fontFamily = DEFAULT_FONT_FAMILY,
                    color = Color(0xFF101010),
                    fontWeight = FontWeight.Medium,
                    fontSize = 16.sp,
                    lineHeight = 16.sp * 1.5
                )
            )
            Text(
                text = "See all",
                style = TextStyle(
                    fontFamily = DEFAULT_FONT_FAMILY,
                    color = Color(0xFF4C4DDC),
                    fontSize = 12.sp,
                    lineHeight = 20.sp,
                )
            )
        }
        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            FavoriteDoctorCard(
                modifier = Modifier.weight(1f),
                name = "Dr. Esther",
                photo = R.drawable.doctor_1,
                specialty = "Dentist",
                rating = 4.5f
            )
            FavoriteDoctorCard(
                modifier = Modifier.weight(1f),
                name = "Dr. Warren",
                photo = R.drawable.doctor_2,
                specialty = "Physician",
                rating = 4.8f
            )
        }
    }
}

@Composable
fun TopDoctors() {
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier.padding(horizontal = 24.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth(),
        ) {
            Text(
                text = "Top Doctor",
                style = TextStyle(
                    fontFamily = DEFAULT_FONT_FAMILY,
                    color = Color(0xFF101010),
                    fontWeight = FontWeight.Medium,
                    fontSize = 16.sp,
                    lineHeight = 16.sp * 1.5
                )
            )
            Text(
                text = "See all",
                style = TextStyle(
                    fontFamily = DEFAULT_FONT_FAMILY,
                    color = Color(0xFF4C4DDC),
                    fontSize = 12.sp,
                    lineHeight = 20.sp,
                )
            )
        }
        Column(
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            TopDoctorCard(
                name = "Dr. Patrick Wilson",
                photo = R.drawable.doctor_3,
                specialty = "Neurologist",
                rating = 5f,
                reviewsCount = 332
            )
            TopDoctorCard(
                name = "Dr. Dany Johnson",
                photo = R.drawable.doctor_5,
                specialty = "General Surgery",
                rating = 5f,
                reviewsCount = 400
            )
            TopDoctorCard(
                name = "Dr. Lisa Smith",
                photo = R.drawable.doctor_4,
                specialty = "General Surgery",
                rating = 5f,
                reviewsCount = 484
            )
        }
    }
}

@Composable
fun FavoriteDoctorCard(
    modifier: Modifier = Modifier,
    @DrawableRes photo: Int,
    name: String,
    specialty: String,
    rating: Float,
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(12.dp))
            .background(Color.White)
    ) {
        Column(
            modifier = Modifier.padding(bottom = 12.dp)
        ) {
            Image(
                painter = painterResource(photo),
                contentDescription = "",
            )
            Spacer(modifier = Modifier.height(8.dp))
            Column(
                verticalArrangement = Arrangement.spacedBy(4.dp),
                modifier = Modifier.padding(horizontal = 8.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = name,
                        style = TextStyle(
                            fontFamily = DEFAULT_FONT_FAMILY,
                            color = Color(0xFF101010),
                            fontSize = 14.sp,
                            lineHeight = 14.sp * 1.5,
                            fontWeight = FontWeight.Medium
                        )
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    Icon(
                        Icons.Rounded.Star,
                        contentDescription = "",
                        tint = Color(0xFFFFD33C),
                        modifier = Modifier.size(16.dp)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = rating.toString(),
                        style = TextStyle(
                            fontFamily = DEFAULT_FONT_FAMILY,
                            fontSize = 10.sp,
                            lineHeight = 10.sp * 1.5,
                            fontWeight = FontWeight.Medium,
                            color = Color(0xFF101010)
                        )
                    )
                }
                Text(
                    text = specialty,
                    style = TextStyle(
                        fontFamily = DEFAULT_FONT_FAMILY,
                        color = Color(0xFF939393),
                        fontSize = 12.sp,
                        lineHeight = 12.sp * 1.2,
                        fontWeight = FontWeight.Light
                    )
                )
            }
        }
    }
}

@Composable
fun TopDoctorCard(
    @DrawableRes photo: Int,
    name: String,
    specialty: String,
    rating: Float,
    reviewsCount: Int
) {
    Box(
        modifier = Modifier
            .padding(start = 8.dp)
            .height(IntrinsicSize.Min)
            .clip(RoundedCornerShape(8.dp))
            .background(Color.White)
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.padding(end = 16.dp)
        ) {
            Image(
                painter = painterResource(id = photo),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .clip(RoundedCornerShape(8.dp))
                    .weight(1f)
                    .height(92.dp),
            )
            Column(
                modifier = Modifier
                    .weight(2f)
                    .padding(vertical = 6.dp)
            ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
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
                    Icon(
                        painter = painterResource(R.drawable.more_icon),
                        contentDescription = "",
                        modifier = Modifier.size(24.dp),
                        tint = Color(0xFF939393)
                    )
                }
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
                Spacer(modifier = Modifier.weight(1f))
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
                            fontWeight = FontWeight.Light
                        )
                    )
                }
            }
        }
    }
}

@Composable
@Preview
fun HomeScreenPreview() {
    HomeScreen()
}
