package forest.zykov.weatherapp.dataBase

import android.provider.BaseColumns

object DbNameClass {
    const val TABLE_NAME = "my_directory_table"
    const val COLUMN_NAME_COUNTRY = "country_key"
    const val ICOLUMN_NAME_TIMEZONE = "timezone_key"
    const val COLUMN_NAME_CITY = "city_key"
    const val COLUMN_NAME_TEMPERATURE = "temperature_key"
    const val COLUMN_NAME_BRIEF_WEATHER = "brief_weather_key"
    const val COLUMN_NAME_FULL_WEATHER = "full_weather_key"

    const val DATABASE_VERSION = 1
    const val DATABASE_NAME = "Directory.db"

    const val CREAT_TABLE = "CREATE TABLE IF NOT EXISTS $TABLE_NAME (" +
            "${BaseColumns._ID} INTEGER PRIMARY KEY," +
            "$COLUMN_NAME_COUNTRY TEXT,$ICOLUMN_NAME_TIMEZONE TEXT" +
            "$COLUMN_NAME_CITY TEXT" +
            " $COLUMN_NAME_TEMPERATURE INTEGER," +
            "$COLUMN_NAME_BRIEF_WEATHER TEXT,$COLUMN_NAME_FULL_WEATHER TEXT)"
    const val SQL_DELETE_TABLE = "DROP TABLE IF EXISTS $TABLE_NAME}"
}