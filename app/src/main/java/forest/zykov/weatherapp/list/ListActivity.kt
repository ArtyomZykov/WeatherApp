package forest.zykov.weatherapp.list


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.recyclerview.widget.RecyclerView
import forest.zykov.weatherapp.CityApplication
import forest.zykov.weatherapp.R
import forest.zykov.weatherapp.detail.DetailActivity
import forest.zykov.weatherapp.repository.City
import forest.zykov.weatherapp.repository.CityRepository

class ListActivity : AppCompatActivity() {

    private val viewModel: ListViewModel by viewModels {
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T =
                    modelClass
                            .getConstructor(CityRepository::class.java)
                            .newInstance(
                                    (application as CityApplication).cityRepository
                            )
        }
    }

    private lateinit var cityList: RecyclerView

    private val adapter = CityAdapter {
        DetailActivity.start(this, it.id)
    }

    

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.list_activity)
        viewModel.cityList.observe(this, ::bindCityList)

        cityList = findViewById(R.id.peopleList)
        cityList.adapter = adapter
    }

    private fun bindCityList(list: List<City>) {
        adapter.city = list
    }

    override fun onResume() {
        super.onResume()
        viewModel.loadCity()
    }
}