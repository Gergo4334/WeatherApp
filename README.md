# WeatherApp
WeatherApp is a simple *Android* application that provides up to date weather forecasts based on the user's location, using the Open-Meteo free weather api. The app displays details about the current weather, the hourly predictions of the current day and a short summary of the weather conditions for the next 7 days.

The app was built using *Jetpack Compose* for creating a modern look. Additionally a theme switching feature has been implemented allowing users to switch between light and dark themes with a push of a button, based on their preferences.

### Architecture
The app follows the three-layered architecture in the form of data, domain and presentation layers.

### Dependency Injection
Dagger-Hilt is used for dependency injection to manage the dependencies throughout the app efficiently.

### Api communication
The API calls are managed with the help of Retrofit library.

### Permissions
The app requires internet and location permissions in order to fetch the weather forecast based on the user's current location.

### Screenshots
![Light theme look](/screenshots/LightTheme.png)

***

![Dark theme look](/screenshots/DarkTheme.png)
