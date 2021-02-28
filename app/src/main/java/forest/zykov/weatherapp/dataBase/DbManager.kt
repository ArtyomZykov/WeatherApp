package forest.zykov.weatherapp.dataBase

import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase
import android.provider.BaseColumns
import forest.zykov.weatherapp.repository.CityRepository

class DbManager(context: CityRepository) {
   //val myDbHelper = DbHelper(context)
    var db: SQLiteDatabase? = null

    fun openDb() {
        //db = myDbHelper.writableDatabase

    }

    fun insertToDb(level: Int, word: String, translation: String) {
        val values = ContentValues().apply {
            put(DbNameClass.COLUMN_NAME_COUNTRY, level)
            put(DbNameClass.COLUMN_NAME_COUNTRY, word)
            put(DbNameClass.COLUMN_NAME_COUNTRY, translation)
        }
        db?.insert(DbNameClass.TABLE_NAME, null, values)
    }

    fun updateItem(level: Int, word: String, translation: String, id: Int) {
        val selection = BaseColumns._ID + "=$id"
        //Log.d("MyLog", "id: " + id)
        val values = ContentValues().apply {
            put(DbNameClass.COLUMN_NAME_COUNTRY, level)
            put(DbNameClass.COLUMN_NAME_COUNTRY, word)
            put(DbNameClass.COLUMN_NAME_COUNTRY, translation)
        }
        //Log.d("MyLog", COLUMN_NAME_COUNTRY)
        db?.update(DbNameClass.TABLE_NAME, values, selection, null)
    }

    fun closeDb() {
        //myDbHelper.close()
    }
}


