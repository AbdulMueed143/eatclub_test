package au.com.eatclub.di.modules

import android.app.Application
import au.com.eatclub.datasources.remote.OpportunityRemoteDatasource
import au.com.eatclub.network.OpportunityService
import au.com.eatclub.util.Constants
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import javax.inject.Singleton

@Module
class ApplicationBuilderModule {

    @Singleton
    @Provides
    fun providesRetrofitInstance(application: Application) : Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(ScalarsConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun providesOpportunityService(retrofit: Retrofit) : OpportunityService = retrofit.create(OpportunityService::class.java)

    @Singleton
    @Provides
    fun providesOpportunityRemoteDatasource(opportunityService: OpportunityService) : OpportunityRemoteDatasource = OpportunityRemoteDatasource(opportunityService)

}