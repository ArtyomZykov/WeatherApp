package forest.zykov.weatherapp.roomDataBace

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

interface WeatherNoteDao {
    @get:Query("SELECT * FROM weatherNote")
    val all: List<WeatherNote>

    @Query("SELECT * FROM weatherNote WHERE uid IN (:billIds)")
    fun loadAllByIds(billIds: Array<Int>): List<WeatherNote>

    @Query("SELECT * FROM weatherNote WHERE customer_id = :uid")
    fun findByCustomerId(uid: Int): List<WeatherNote>

    @Insert
    fun insertAll(weatherNotes: List<WeatherNote>)

    @Insert
    fun insert(weatherNote: WeatherNote)

    @Delete
    fun delete(weatherNote: WeatherNote)
}