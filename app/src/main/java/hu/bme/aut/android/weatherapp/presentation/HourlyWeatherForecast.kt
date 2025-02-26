package hu.bme.aut.android.weatherapp.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import hu.bme.aut.android.weatherapp.presentation.ui.theme.DarkBlue
import hu.bme.aut.android.weatherapp.presentation.ui.theme.DeepBlue
import java.time.LocalDateTime
import hu.bme.aut.android.weatherapp.R.string as StringResources

@Composable
fun HourlyWeatherForecast(
    state: WeatherState,
    modifier: Modifier = Modifier
) {
    state.weatherInfo?.weatherDataPerDay?.get(0)?.let { hourlyData ->
        val initialIndex = hourlyData.indexOfFirst { it.time.hour >= LocalDateTime.now().hour }.coerceAtLeast(0)
        val listState = rememberLazyListState()

        LaunchedEffect(key1 = initialIndex) {
            listState.animateScrollToItem(initialIndex)
        }

        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .background(color = MaterialTheme.colorScheme.background, shape = RoundedCornerShape(10.dp)),
            verticalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            Text(
                text = stringResource(id = StringResources.hourly_forecast),
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onBackground,
                modifier = Modifier.padding(top = 10.dp, start = 16.dp)
            )
            LazyRow(
                state = listState,
                content = {
                    items(hourlyData) { weatherData ->
                        HourlyWeatherDisplay(
                            weatherData = weatherData,
                            modifier = Modifier
                                .height(100.dp)
                                .padding(horizontal = 16.dp)
                        )
                    }
                },
                modifier = Modifier.padding(vertical = 10.dp)
            )
        }
    }
}