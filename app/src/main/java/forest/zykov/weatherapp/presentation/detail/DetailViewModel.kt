package forest.zykov.weatherapp.presentation.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import forest.zykov.weatherapp.domain.City
import forest.zykov.weatherapp.domain.GetCityUseCase
import forest.zykov.weatherapp.domain.SetCityUseCase
import forest.zykov.weatherapp.presentation.LiveEvent

class DetailViewModel(
        getCityUseCase: GetCityUseCase,
        private val setCityUseCase: SetCityUseCase,
        id: Long
) : ViewModel() {

    val city = MutableLiveData<City>()

    val closeScreenEvent = LiveEvent()

    init {
        val city = getCityUseCase(id)

        if (city != null) {
            this.city.value = city!!
        } else {
            closeScreenEvent(Unit)
        }

    }

    fun saveCity(editedCity: City) {
        setCityUseCase(editedCity)
        closeScreenEvent()
    }
}