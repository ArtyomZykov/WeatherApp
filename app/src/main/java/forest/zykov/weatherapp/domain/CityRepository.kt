package forest.zykov.weatherapp.domain

interface CityRepository {

    fun getCity(): List<City>

    fun getCity(id: Long): City?

    fun setCity(person: City)
}