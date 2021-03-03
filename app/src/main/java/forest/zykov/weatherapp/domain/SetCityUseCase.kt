package forest.zykov.weatherapp.domain

import forest.zykov.weatherapp.data.CityRepositoryImpl

class SetCityUseCase(private val cityRepository: CityRepository) {

    operator fun invoke(city: City) {
        cityRepository.setCity(city)
    }
}