package forest.zykov.weatherapp.presentation.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import forest.zykov.weatherapp.data.CityLocalDataSourceImpl
import forest.zykov.weatherapp.data.CityRepositoryImpl
import forest.zykov.weatherapp.domain.GetCityUseCase
import forest.zykov.weatherapp.domain.GetTownsUseCase

class ListViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        val cityDataSource = CityLocalDataSourceImpl()
        val cityRepository = CityRepositoryImpl(cityDataSource)
        val getCityUseCase = GetTownsUseCase(cityRepository)

        return modelClass
                .getConstructor(GetCityUseCase::class.java)
                .newInstance(getCityUseCase)
    }
}