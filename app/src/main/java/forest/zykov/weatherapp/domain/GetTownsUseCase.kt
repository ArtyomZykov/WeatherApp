package forest.zykov.weatherapp.domain

class GetTownsUseCase(private val repository: CityRepository) {

    operator fun invoke(): List<City> = repository.getCity()
}