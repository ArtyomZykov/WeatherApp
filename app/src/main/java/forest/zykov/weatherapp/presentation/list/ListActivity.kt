package forest.zykov.weatherapp.presentation.list

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.observe
import androidx.recyclerview.widget.RecyclerView
import forest.zykov.weatherapp.R
import forest.zykov.weatherapp.domain.City
import forest.zykov.weatherapp.list.CityAdapter
import forest.zykov.weatherapp.presentation.detail.DetailActivity

class ListActivity : AppCompatActivity() {

    private val viewModel: ListViewModel by viewModels {
        ListViewModelFactory()
    }

    private lateinit var cityleList: RecyclerView

    private val adapter = CityAdapter {
        DetailActivity.start(this, it.id)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.list_activity)
        viewModel.townsList.observe(this, ::bindPeopleList)

        cityleList = findViewById(R.id.peopleList)
        cityleList.adapter = adapter
    }

    private fun bindPeopleList(list: List<City>) {
        adapter.city = list
    }

    override fun onResume() {
        super.onResume()
        viewModel.loadTowns()
    }
}