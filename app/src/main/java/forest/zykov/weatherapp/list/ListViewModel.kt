package forest.zykov.weatherapp.list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import forest.zykov.weatherapp.repository.City
import forest.zykov.weatherapp.repository.CityRepository

class ListViewModel(private val repository: CityRepository) : ViewModel() {

    val cityList = MutableLiveData<List<City>>()

    fun loadCity() {
        val people = repository.getCity()

        cityList.value = people
    }
}