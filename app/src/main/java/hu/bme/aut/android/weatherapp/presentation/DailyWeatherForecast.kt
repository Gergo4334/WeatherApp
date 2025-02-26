package hu.bme.aut.android.weatherapp.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import hu.bme.aut.android.weatherapp.R

@Composable
fun DailyWeatherForecast(
    state: WeatherState,
    modifier: Modifier = Modifier
) {
    state.weatherInfo?.weatherDataPerDay?.let { dailyData ->
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .background(color = MaterialTheme.colorScheme.background, shape = RoundedCornerShape(10.dp)),
            verticalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            Text(
                text = stringResource(id = R.string.daily_forecast),
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onBackground,
                modifier = Modifier.padding(top = 10.dp, start = 16.dp)
            )
            LazyRow(
                content = {
                    items(dailyData.keys.sorted()) { dayKey ->
                        val dailyWeatherList = dailyData[dayKey]
                        val dailyWeather = dailyWeatherList?.get(12)
                        if(dailyWeather != null) {
                            DailyWeatherDisplay(
                                weatherData = dailyWeather,
                                modifier = Modifier
                                    .height(120.dp)
                                    .padding(horizontal = 16.dp)
                            )
                        }
                    }
                }
            )
        }
    }
}