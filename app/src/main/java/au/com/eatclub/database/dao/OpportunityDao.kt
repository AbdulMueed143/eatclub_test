package au.com.eatclub.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import au.com.eatclub.models.entitymodels.Opportunity

@Dao
interface OpportunityDao : BaseDao<Opportunity> {

    @Query("SELECT * FROM "+Opportunity.TABLE_NAME)
    fun getOpportunities() : LiveData<List<Opportunity>>

}