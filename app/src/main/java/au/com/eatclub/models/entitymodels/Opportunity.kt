package au.com.eatclub.models.entitymodels

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
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

    @ColumnInfo(name = COL_PREDICTION)
    @SerializedName(COL_PREDICTION)
    val prediction : String

    ) : Cloneable {

    companion object {
        const val TABLE_NAME = "opportunity"

        const val COL_OBJECT_ID = "objectId"
        const val COL_CREATED = "created"
        const val COL_START_TIME = "startTime"
        const val COL_END_TIME = "endTime"
        const val COL_PREDICTION = "prediction"
    }
}