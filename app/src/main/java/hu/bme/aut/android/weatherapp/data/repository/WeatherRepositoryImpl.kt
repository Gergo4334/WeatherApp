package hu.bme.aut.android.weatherapp.data.repository

import hu.bme.aut.android.weatherapp.data.mapper.toWeatherInfo
import hu.bme.aut.android.weatherapp.data.remote.WeatherApi
import hu.bme.aut.android.weatherapp.domain.repository.WeatherRepository
import hu.bme.aut.android.weatherapp.domain.util.Resource
import hu.bme.aut.android.weatherapp.domain.weather.WeatherInfo
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val api: WeatherApi
): WeatherRepository {
    override suspend fun getWeatherData(lat: Double, long: Double): Resource<WeatherInfo> {
        return try {
            Resource.Success(
                data = api.getWeatherData(
                    lat = lat,
                    long = long
                ).toWeatherInfo()
            )
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Error(e.message ?: "An unknown error occurred.")
        }
    }
}