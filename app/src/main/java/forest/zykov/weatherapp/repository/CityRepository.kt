package forest.zykov.weatherapp.repository

class CityRepository {

    private val city = mutableListOf(
            City(id = 0, country = "Australia", timezone = "UTC+8", city = "Canbera",
                    temperatyre = 25, brief_weather = "day_clear", full_weather = "coooooooooo"),
            City(id = 1, country = "Brazil", timezone = "UTC−5", city = "Brazilia",
                    temperatyre = 19, brief_weather = "day_with_clarification", full_weather = "cooooooooooooooooooold"),
            City(id = 2, country = "Democratic Republic", timezone = "UTC+1", city = "Kinshasa",
                    temperatyre = 31, brief_weather = "day_rain", full_weather = "cooooooooooooooooooold"),
            City(id = 3, country = "Indonesia", timezone = "UTC+7", city = "Djakarta",
                    temperatyre = 28, brief_weather = "day_snow", full_weather = "cooooooooooooooooooold"),
            City(id = 4, country = "Kazakhstan", timezone = "UTC+5", city = "Nur-Sultan",
                    temperatyre = 4, brief_weather = "day_no_inform", full_weather = "cooooooooooooooooooold"),
            City(id = 5, country = "Canada", timezone = "UTC−8", city = "Ottava",
                    temperatyre = -6, brief_weather = "night_clear", full_weather = "cooooooooooooooooooold"),
            City(id = 6, country = "Mexico", timezone = "UTC−8", city = "Mehico",
                    temperatyre = 0, brief_weather = "night_with_clarification", full_weather = "cooooooooooooooooooold"),
            City(id = 7, country = "Mongolia", timezone = "UTC+7", city = "Ulan-Bator",
                    temperatyre = -17, brief_weather = "night_rain", full_weather = "cooooooooooooooooooold"),
            City(id = 8, country = "Russia", timezone = "UTC+2", city = "Novosibirsk",
                    temperatyre = -13, brief_weather = "night_thunderstorm", full_weather = "cooooooooooooooooooold"),
            City(id = 9, country = "USA", timezone = "UTC−10", city = "Vashington",
                    temperatyre = 6, brief_weather = "night_no_inform", full_weather = "cooooooooooooooooooold")

    )

    fun getCity(): List<City> = city

    fun getCity(id: Long): City? = city.firstOrNull { it.id == id }

    fun setCity(town: City) {

        val editedPersonIndex = city.indexOfFirst { it.id == town.id }
        if (editedPersonIndex >= 0) {
            city[editedPersonIndex] = town
        }
    }
}