package forest.zykov.weatherapp.presentation.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import forest.zykov.weatherapp.data.CityLocalDataSourceImpl
import forest.zykov.weatherapp.data.CityRepositoryImpl
import forest.zykov.weatherapp.domain.GetCityUseCase
import forest.zykov.weatherapp.domain.SetCityUseCase

class DetailViewModelFactory(private val id: Long) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        val cityDataSource = CityLocalDataSourceImpl()
        val cityRepository = CityRepositoryImpl(cityDataSource)
        val getCityUseCase = GetCityUseCase(cityRepository)
        val setCityUseCase = SetCityUseCase(cityRepository)

        return modelClass
                .getConstructor(
                        GetCityUseCase::class.java,
                        SetCityUseCase::class.java,
                        Long::class.java
                )
                .newInstance(getCityUseCase, setCityUseCase, id)
    }
}