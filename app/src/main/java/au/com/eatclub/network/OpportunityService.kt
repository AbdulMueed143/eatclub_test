package au.com.eatclub.network

import au.com.eatclub.models.entitymodels.Opportunity
import retrofit2.Response
import retrofit2.http.*

interface OpportunityService {

    @Headers("Content-Type: application/graphql",
        "x-api-key: da2-mkdmswirfvak3ht5tejeaz73ee",
        "Authorization: zolptjonbrfppf2bydrsxbbsse")
    @POST("/graphql")
    suspend fun getOpportunities(@Body body: String) : Response<String>
}