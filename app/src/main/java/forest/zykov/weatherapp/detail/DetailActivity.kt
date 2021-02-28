package forest.zykov.weatherapp.detail

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import forest.zykov.weatherapp.CityApplication
import forest.zykov.weatherapp.R
import forest.zykov.weatherapp.list.ListActivity
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

    fun onClickBack(view: View) {
        val i = Intent(this, ListActivity::class.java)
        startActivity(i)
    }

    private lateinit var cityRepository: CityRepository
    private lateinit var countryNameText: TextView
    private lateinit var timezoneText: TextView
    private lateinit var cityNameText: TextView
    private lateinit var brief_weatherInput: EditText
    private lateinit var full_weatherInput: EditText
    private lateinit var tempInput: EditText

    private lateinit var saveButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        cityRepository = (application as CityApplication).cityRepository
        setContentView(R.layout.detail_activity)

        initViews()
    }

    private fun initViews() {
        val id = intent.getLongExtra(EXTRA_ID, 0)
        val town = cityRepository.getCity(id)

        if (town != null) {
            countryNameText = findViewById(R.id.countryNameText)
            timezoneText = findViewById(R.id.timezoneText)
            cityNameText = findViewById(R.id.cityNameText)
            tempInput = findViewById(R.id.tempInput)
            brief_weatherInput = findViewById(R.id.brief_weatherInput)
            full_weatherInput = findViewById(R.id.full_weatherInput)

            saveButton = findViewById(R.id.saveButton)


            countryNameText.text = getString(R.string.country_format, town.country)
            timezoneText.text = getString(R.string.timezone_format, town.timezone)
            cityNameText.text = getString(R.string.city_format, town.timezone)
            tempInput.setText(town.temperatyre.toString())
            brief_weatherInput.setText(town.brief_weather ?: getString(R.string.brief_weather_absent))
            full_weatherInput.setText(town.full_weather ?: getString(R.string.full_weather_absent))


            saveButton.setOnClickListener {
                val editedPerson = town.copy(temperatyre = tempInput.text.toString().toInt(),
                        brief_weather = brief_weatherInput.text.toString(),
                        full_weather = full_weatherInput.text.toString())

                cityRepository.setCity(editedPerson)
                finish()
            }
        } else {
            finish()
        }
    }

}