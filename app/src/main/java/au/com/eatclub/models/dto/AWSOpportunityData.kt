package au.com.eatclub.models.dto

import au.com.eatclub.models.entitymodels.Opportunity
import com.google.gson.annotations.SerializedName
import org.json.JSONObject
import java.util.ArrayList

data class OpportunitiesForTodayDTO(
    @SerializedName("opposForToday")
    val listOfOpportunities: ArrayList<Opportunity> = ArrayList<Opportunity>()
) {

}

data class AWSOpportunityData(
    @SerializedName("data")
    val data : OpportunitiesForTodayDTO
)
