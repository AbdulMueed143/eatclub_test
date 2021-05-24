package au.com.eatclub.models.entitymodels

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.google.android.play.core.internal.t
import com.google.gson.annotations.SerializedName


/**
 * Opportunity
 * */

@Entity(tableName = Opportunity.TABLE_NAME)
data class Opportunity(
    @PrimaryKey
    @ColumnInfo(name = COL_OBJECT_ID)
    @SerializedName(COL_OBJECT_ID)
    val objectId : String,

    @ColumnInfo(name = COL_CREATED)
    @SerializedName(COL_CREATED)
    val created : String,

    @ColumnInfo(name = COL_START_TIME)
    @SerializedName(COL_START_TIME)
    val startTime : String,


    @ColumnInfo(name = COL_END_TIME)
    @SerializedName(COL_END_TIME)
    val endTime : String,

    @ColumnInfo(name = COL_DISCOUNT)
    @SerializedName(COL_DISCOUNT)
    var discount : String,

    @ColumnInfo(name = COL_PREDICTION)
    @SerializedName(COL_PREDICTION)
    val prediction : String

    ) : Cloneable {


    @Ignore
    var position : Int = 0

    @Ignore
    var positionAsString: String = ""
    get() {
        return "Opportunity $position"
    }

    @Ignore
    var timeAsString : String = ""
        get() {
            val startHour: Int = startTime.toInt() / 60 //since both are ints, you get an int
            val endHour: Int = endTime.toInt() / 60 //since both are ints, you get an int
            val startMinutes: Int = startTime.toInt() % 60
            val endMinutes: Int = endTime.toInt() % 60
            return "$startHour : $startMinutes${hourToAmPM(startHour)} - $endHour : $endMinutes${hourToAmPM(endHour)}"
        }

    private fun hourToAmPM(hour: Int) : String {
        if (hour > 11 )
            return "PM"

        return "AM"
    }

    @Ignore
    var discountValue : Int = 0
        get() {
            return discount.replace("%", "").toInt()
        }

    companion object {
        const val TABLE_NAME = "opportunity"

        const val COL_OBJECT_ID = "objectId"
        const val COL_CREATED = "created"
        const val COL_DISCOUNT = "discount"
        const val COL_START_TIME = "startTime"
        const val COL_END_TIME = "endTime"
        const val COL_PREDICTION = "prediction"
    }
}