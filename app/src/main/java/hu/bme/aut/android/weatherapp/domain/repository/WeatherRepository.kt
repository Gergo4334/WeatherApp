package hu.bme.aut.android.weatherapp.domain.repository

import hu.bme.aut.android.weatherapp.domain.util.Resource
import hu.bme.aut.android.weatherapp.domain.weather.WeatherInfo

interface WeatherRepository {
    suspend fun getWeatherData(lat: Double, long: Double): Resource<WeatherInfo>
}