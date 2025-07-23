package com.slicentoapp.deleveryapp.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect

private val DarkColorScheme = darkColorScheme(
    primary = Orange40,
    secondary = Gray80,
    tertiary = SkyBlue40,
    background = white,
    onPrimary = white
)


@Composable
fun SlicentoDeliveryAppTheme(
    content: @Composable () -> Unit
) {


    SideEffect {

    }

    MaterialTheme(
        colorScheme = DarkColorScheme,
        typography = Typography,
        content = content
    )
}