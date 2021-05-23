package au.com.eatclub.datasources.remote

import android.util.Log
import au.com.eatclub.datasources.BaseDataSource
import au.com.eatclub.network.OpportunityService
import org.json.JSONObject
import java.lang.Exception

//This is where we decide what to use for remote cnnection and get data
class OpportunityRemoteDatasource(private val opportunityService: OpportunityService) : BaseDataSource {

    suspend fun getOpportunities() = getResult {
        Log.d("GetResult", "Get Opportunities suspend")
        //set body parameters...
        val jsonObject = JSONObject()

        try {
            jsonObject.put("query", "query MyQuery { opposForToday(restId: \"abdul\") {objectId created discount startTime endTime prediction}}")
            val converted = jsonObject.toString()
            Log.d("Converted", converted)
        }
        catch (ex: Exception) {
            Log.d("", ex.localizedMessage)
        }

        opportunityService.getOpportunities(jsonObject.toString())
    }
}