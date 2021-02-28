package forest.zykov.weatherapp.list

import android.content.Intent
import android.graphics.Color
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import forest.zykov.weatherapp.CityApplication
import forest.zykov.weatherapp.R
import forest.zykov.weatherapp.repository.City


class CityAdapter(private val onClick: (City) -> Unit) : RecyclerView.Adapter<TownHolder>() {

    var city: List<City> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TownHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_city, parent, false)
        return TownHolder(view, onClick)
    }

    override fun onBindViewHolder(holder: TownHolder, position: Int) {
        val town = city[position]
        holder.bind(town)
    }

    override fun getItemCount(): Int = city.count()
}


class TownHolder(itemView: View, private val onClick: (City) -> Unit) : RecyclerView.ViewHolder(itemView) {

    private val cityText: TextView = itemView.findViewById(R.id.cityText)
    private val briefWeatherText: TextView = itemView.findViewById(R.id.briefWeatherText)
    private val tempText: TextView = itemView.findViewById(R.id.tempText)

    fun bind(town: City) {
        cityText.text = itemView.context.getString(R.string.city_format, town.city)
        briefWeatherText.text = town.brief_weather ?: itemView.context.getString(R.string.brief_weather_absent)
        var temp = town.temperatyre
        tempText.text = itemView.context.getString(R.string.temp, temp.toString())
        if (temp == 0) {
            tempText.setTextColor(Color.parseColor("#636363"))
        }
        else if (temp < 0) {
            tempText.setTextColor(Color.parseColor("#0066ff"))
        }
        else if (temp > 0) {
            tempText.setTextColor(Color.parseColor("#960023"))
        }
        itemView.setOnClickListener { onClick(town) }
    }
}