package forest.zykov.weatherapp.presentation.list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import forest.zykov.weatherapp.domain.City
import forest.zykov.weatherapp.domain.CityRepository
import forest.zykov.weatherapp.domain.GetTownsUseCase

class ListViewModel(private val getTownsUseCase: GetTownsUseCase) : ViewModel() {

    val townsList = MutableLiveData<List<City>>()

    fun loadTowns() {
        val towns = getTownsUseCase()

        townsList.value = towns
    }

}