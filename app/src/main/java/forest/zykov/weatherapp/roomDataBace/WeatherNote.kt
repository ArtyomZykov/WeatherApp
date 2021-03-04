package forest.zykov.weatherapp.roomDataBace

import android.os.Parcel
import android.os.Parcelable
import androidx.room.*


@Entity(foreignKeys =
[
    ForeignKey(
            entity = WeatherNote::class,
            parentColumns = arrayOf("uid"),
            childColumns = arrayOf("customer_id"),
            onDelete = ForeignKey.CASCADE
    )
]//, indices = [Index(value = "customer_id")]
)



class WeatherNote constructor(amount: Int, customerId: Int) : Parcelable {

    @PrimaryKey(autoGenerate = true)
    var uid: Int = 0

    @ColumnInfo(name = "amount")
    var amount: Int = amount

    @ColumnInfo(name = "customer_id")
    var customerId: Int = customerId

    constructor(parcel: Parcel) : this(
            TODO("amount"),
            TODO("customerId")) {
        uid = parcel.readInt()
        amount = parcel.readInt()
        customerId = parcel.readInt()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(uid)
        parcel.writeInt(amount)
        parcel.writeInt(customerId)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<WeatherNote> {
        override fun createFromParcel(parcel: Parcel): WeatherNote {
            return WeatherNote(parcel)
        }

        override fun newArray(size: Int): Array<WeatherNote?> {
            return arrayOfNulls(size)
        }
    }
}