package forest.zykov.weatherapp.list

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import forest.zykov.weatherapp.CityApplication
import forest.zykov.weatherapp.R
import forest.zykov.weatherapp.detail.DetailActivity
import forest.zykov.weatherapp.repository.CityRepository

class ListActivity : AppCompatActivity() {

    private lateinit var cityRepository: CityRepository

    private lateinit var cityList: RecyclerView

    private val adapter = CityAdapter {
        DetailActivity.start(this, it.id)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        cityRepository = (application as CityApplication).cityRepository
        setContentView(R.layout.list_activity)

        cityList = findViewById(R.id.peopleList)
        cityList.adapter = adapter
    }

    override fun onResume() {
        super.onResume()
        adapter.city = cityRepository.getCity()
    }
}