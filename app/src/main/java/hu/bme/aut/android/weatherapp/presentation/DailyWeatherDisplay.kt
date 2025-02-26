package hu.bme.aut.android.weatherapp.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import hu.bme.aut.android.weatherapp.domain.weather.WeatherData
import java.time.format.DateTimeFormatter
import java.time.format.TextStyle
import java.util.Locale

@Composable
fun DailyWeatherDisplay(
    weatherData: WeatherData,
    modifier: Modifier = Modifier,
) {
    val formattedDate = remember(weatherData) {
        weatherData.time.format(DateTimeFormatter.ofPattern("MM.dd"))
    }

    val dayOfWeek = remember(weatherData) {
        weatherData.time.dayOfWeek.getDisplayName(TextStyle.FULL, Locale.getDefault())
    }

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = dayOfWeek,
            color = MaterialTheme.colorScheme.onBackground,
        )
        Text(
            text = formattedDate,
            color = MaterialTheme.colorScheme.onBackground
        )
        Image(
            painter = painterResource(id = weatherData.weatherType.iconRes),
            contentDescription = null,
            modifier = Modifier.width(40.dp)
        )
        Text(
            text = weatherData.weatherType.weatherDesc,
            color = MaterialTheme.colorScheme.onBackground,
            fontWeight = FontWeight.Bold
        )
    }
}