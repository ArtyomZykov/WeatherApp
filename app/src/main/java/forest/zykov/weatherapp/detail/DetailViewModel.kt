package forest.zykov.weatherapp.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import forest.zykov.weatherapp.LiveEvent
import forest.zykov.weatherapp.repository.City
import forest.zykov.weatherapp.repository.CityRepository

class DetailViewModel(
        private val repository: CityRepository,
        id: Long
) : ViewModel() {

    val city = MutableLiveData<City>()

    val closeScreenEvent = LiveEvent()

    init {
        val city = repository.getCity(id)

        if (city != null) {
            this.city.value = city!!
        } else {
            closeScreenEvent(Unit)
        }

    }

    fun saveCity(editedCity: City) {
        repository.setCity(editedCity)
        closeScreenEvent()
    }
}