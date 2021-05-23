package au.com.eatclub.di.modules

import android.app.Application
import au.com.eatclub.database.AppDatabase
import au.com.eatclub.database.dao.OpportunityDao
import au.com.eatclub.database.repositories.OpportunityRepository
import au.com.eatclub.datasources.remote.OpportunityRemoteDatasource
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RoomBuilderModule {

    @Singleton
    @Provides
    fun providesAppDatabase(application: Application) : AppDatabase {
        return AppDatabase.getInstance(application.applicationContext)
    }

    @Singleton
    @Provides
    fun providesOpportunityDao(appDatabase: AppDatabase) : OpportunityDao {
        return appDatabase.opportunityDao()
    }

    @Singleton
    @Provides
    fun providesOpportunityRepository(remoteDatasource: OpportunityRemoteDatasource, opportunityDao: OpportunityDao) : OpportunityRepository {
        return OpportunityRepository(remoteDatasource, opportunityDao)
    }

}