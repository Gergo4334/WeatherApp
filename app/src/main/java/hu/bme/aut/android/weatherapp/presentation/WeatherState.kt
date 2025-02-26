package hu.bme.aut.android.weatherapp.presentation

import hu.bme.aut.android.weatherapp.domain.weather.WeatherInfo

data class WeatherState(
    val weatherInfo: WeatherInfo? = null,
    val isLoading: Boolean = false,
    val errorMessage: String? = null,
    val isDarkTheme: Boolean = false
)
