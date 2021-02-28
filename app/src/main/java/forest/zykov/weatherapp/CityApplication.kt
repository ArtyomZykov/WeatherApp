package forest.zykov.weatherapp

import android.app.Application
import forest.zykov.weatherapp.repository.CityRepository

class CityApplication : Application() {

    lateinit var cityRepository: CityRepository

    override fun onCreate() {
        super.onCreate()
        cityRepository = CityRepository()
    }
}