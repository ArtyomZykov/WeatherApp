package forest.zykov.weatherapp.domain

import android.util.Log

class SetCityUseCase(private val cityRepository: CityRepository) {

    operator fun invoke(city: City) {
        Log.d("MySaveCityLog", "Temperatyre: " + city.temperatyre)
        cityRepository.setCity(city)
    }
}