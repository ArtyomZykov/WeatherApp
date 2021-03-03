package forest.zykov.weatherapp.data

import forest.zykov.weatherapp.domain.City
import forest.zykov.weatherapp.domain.CityRepository

class CityRepositoryImpl(private val cityDataSource: CityDataSource) : CityRepository {

    override fun getCity(): List<City> = cityDataSource.getCity()

    override fun getCity(id: Long): City? = cityDataSource.getCity(id)

    override fun setCity(city: City) {
        cityDataSource.setCity(city)
    }
}