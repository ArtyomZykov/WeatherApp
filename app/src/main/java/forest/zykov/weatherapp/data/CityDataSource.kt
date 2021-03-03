package forest.zykov.weatherapp.data

import forest.zykov.weatherapp.domain.City

interface CityDataSource {

    fun getCity(): List<City>

    fun getCity(id: Long): City?

    fun setCity(city: City)
}