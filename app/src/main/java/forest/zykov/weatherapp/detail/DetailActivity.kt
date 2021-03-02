package forest.zykov.weatherapp.detail

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe

import forest.zykov.weatherapp.CityApplication
import forest.zykov.weatherapp.R
import forest.zykov.weatherapp.list.ListActivity
import forest.zykov.weatherapp.repository.City
import forest.zykov.weatherapp.repository.CityRepository


class DetailActivity : AppCompatActivity() {

    companion object {

        private const val EXTRA_ID = "EXTRA_ID"

        fun start(context: Context, id: Long) {
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra(EXTRA_ID, id)
            context.startActivity(intent)
        }
    }

    private val viewModel: DetailViewModel by viewModels {
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T =
                    modelClass
                            .getConstructor(CityRepository::class.java, Long::class.java)
                            .newInstance(
                                    (application as CityApplication).cityRepository,
                                    intent.getLongExtra(EXTRA_ID, 0)
                            )
        }
    }



    private lateinit var countryNameText: TextView
    private lateinit var timezoneText: TextView
    private lateinit var cityNameText: TextView
    private lateinit var brief_weatherInput: EditText
    private lateinit var full_weatherInput: EditText
    private lateinit var tempInput: EditText

    private lateinit var saveButton: Button
    private lateinit var backButton: Button

    fun onClickBack_NePolycilosYbrat(view: View) {
        val i = Intent(this, ListActivity::class.java)
        startActivity(i)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_activity)
        viewModel.city.observe(this, ::bindCity)
        viewModel.closeScreenEvent.observe(this) { closeScreen() }
        initViews()
    }

    fun bindCity(city: City) {
        countryNameText.text = getString(R.string.country_format, city.country)
        timezoneText.text = getString(R.string.timezone_format, city.timezone)
        cityNameText.text = getString(R.string.city_format, city.timezone)
        tempInput.setText(city.temperatyre.toString())
        brief_weatherInput.setText(city.brief_weather ?: getString(R.string.brief_weather_absent))
        full_weatherInput.setText(city.full_weather ?: getString(R.string.full_weather_absent))


        //backButton.setOnClickListener {
        //    val i = Intent(this, ListActivity::class.java)
        //    startActivity(i)
        //}

        saveButton.setOnClickListener {
            val editedCity = city.copy(temperatyre = tempInput.text.toString().toInt(),
                    brief_weather = brief_weatherInput.text.toString(),
                    full_weather = full_weatherInput.text.toString())
                    viewModel.saveCity(editedCity)
                    closeScreen()
        }
    }

    private fun initViews() {
        countryNameText = findViewById(R.id.countryNameText)
        timezoneText = findViewById(R.id.timezoneText)
        cityNameText = findViewById(R.id.cityNameText)
        tempInput = findViewById(R.id.tempInput)
        brief_weatherInput = findViewById(R.id.brief_weatherInput)
        full_weatherInput = findViewById(R.id.full_weatherInput)
        saveButton = findViewById(R.id.saveButton)
        //backButton = findViewById(R.id.backBatton)


    }

    private fun closeScreen() {
        finish()
    }

}