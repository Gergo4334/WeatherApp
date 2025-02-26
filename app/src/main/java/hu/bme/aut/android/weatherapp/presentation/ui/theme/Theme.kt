package hu.bme.aut.android.weatherapp.presentation.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = DarkBlue,
    secondary = DeepBlue,
    tertiary = IceBlue,
    onBackground = CloudWhite,
    onPrimary = BrightWhite
)

private val LightColorScheme = lightColorScheme(
    primary = SunYellow,
    secondary = SkyBlue,
    tertiary = GrassGreen,
    background = MistyGreen,
    surface = PureWhite,
    onBackground = CharcoalBlack,
    onPrimary = SnowWhite

)

@Composable
fun WeatherAppTheme(
    isDarkTheme: Boolean,
    content: @Composable () -> Unit
) {
    val colorScheme = if (isDarkTheme) DarkColorScheme else LightColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}