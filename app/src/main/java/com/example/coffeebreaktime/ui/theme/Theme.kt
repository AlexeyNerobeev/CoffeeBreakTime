package com.example.coffeebreaktime.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = Purple80,
    secondary = PurpleGrey80,
    tertiary = Pink80
)

private val LightColorScheme = lightColorScheme(
    primary = Purple40,
    secondary = PurpleGrey40,
    tertiary = Pink40

    /* Other default colors to override
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
    */
)

data class ThemeColors(
    val mainBackground: Color = Color.White,
    val oppositeColor: Color = Color.Black,
    val circleShape: Color = Color(0xFF324A5933).copy(alpha = 0.2f),
    val signInText: Color = Color(0xFF14AC46),
    val welcomeText: Color = Color(0xFF324A59),
    val tfIconColor: Color = Color(0xFF147F37),
    val eyeColor: Color = Color.Black,
    val forgotPassword: Color = Color(0xFF147F37),
    val bottomSignUp: Color = Color(0xFF147F37),
    val backIcon: Color = Color.Black,
    val verificationTf: Color = Color(0xFFB7BBC9),
    val retry: Color = Color(0xFF324A59),
    val chooseCoffeeShop: Color = Color.White
)

private val LocalTheme = staticCompositionLocalOf {
    ThemeColors()
}

@Composable
fun AppTheme(
    isDarkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
){
    val themeColors = if(isDarkTheme){
        ThemeColors(
            mainBackground = Color.Black,
            oppositeColor = Color.White,
            circleShape = Color(0xFFFFFF33).copy(alpha = 0.2f),
            signInText = Color(0xFF4F7993),
            welcomeText = Color(0xFFA1A1A1),
            tfIconColor = Color(0xFF4F7993),
            eyeColor = Color(0xFFA8A8A8),
            forgotPassword = Color(0xFF324A59),
            bottomSignUp = Color(0xFF4F7993),
            backIcon = Color(0xFF4F7993),
            verificationTf = Color(0xFF585A62),
            retry = Color(0xAAAAAA80).copy(alpha = 0.5f),
            chooseCoffeeShop = Color(0xFF272D31)
        )
    }else{
        ThemeColors(
            mainBackground = Color.White,
            oppositeColor = Color.Black,
            circleShape = Color(0x324A5933).copy(alpha = 0.2f),
            signInText = Color(0xFF14AC46),
            welcomeText = Color(0xFF324A59),
            tfIconColor = Color(0xFF147F37),
            eyeColor = Color.Black,
            forgotPassword = Color(0xFF147F37),
            bottomSignUp = Color(0xFF147F37),
            backIcon = Color.Black,
            verificationTf = Color(0xFFB7BBC9),
            retry = Color(0xFF324A59),
            chooseCoffeeShop = Color.White
        )
    }

    CompositionLocalProvider(
        LocalTheme provides themeColors,
        content = content
    )
}

object Theme{
    val colors: ThemeColors
        @Composable get() = LocalTheme.current
}

@Composable
fun CoffeeBreakTimeTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}