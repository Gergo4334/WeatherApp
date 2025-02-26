package hu.bme.aut.android.weatherapp.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import hu.bme.aut.android.weatherapp.domain.location.LocationTracker
import hu.bme.aut.android.weatherapp.domain.repository.WeatherRepository
import hu.bme.aut.android.weatherapp.domain.util.Resource
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val repository: WeatherRepository,
    private val locationTracker: LocationTracker
): ViewModel() {

    var state by mutableStateOf(WeatherState())
        private set

    fun loadWeatherInfo() = viewModelScope.launch {
        state = state.copy(
            isLoading = true,
            errorMessage = null
        )
        locationTracker.getCurrentLocation()?.let { location ->
            when(val result = repository.getWeatherData(location.latitude, location.longitude)) {
                is Resource.Success -> {
                    state = state.copy(
                        weatherInfo = result.data,
                        isLoading = false,
                        errorMessage = null
                    )
                }
                is Resource.Error -> {
                    state = state.copy(
                        weatherInfo = null,
                        isLoading = false,
                        errorMessage = result.message
                    )
                }
            }
        } ?: kotlin.run {
            state = state.copy(
                isLoading = false,
                errorMessage = "Couldn't retrieve location. Make sure to grant permission and enable GPS."
            )
        }
    }

    fun toggleTheme() {
        state = state.copy(
            isDarkTheme = !state.isDarkTheme
        )
    }
}