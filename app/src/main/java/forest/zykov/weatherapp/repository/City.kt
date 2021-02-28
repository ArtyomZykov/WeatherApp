package forest.zykov.weatherapp.repository

data class City (
    var id : Long,
    var country : String,
    var timezone : String,
    var city : String,
    var temperatyre : Int = 0,
    var brief_weather : String? = null,
    var full_weather : String? = null
)