package au.com.eatclub.database.repositories

import au.com.eatclub.database.dao.OpportunityDao
import au.com.eatclub.datasources.remote.OpportunityRemoteDatasource
import au.com.eatclub.util.performGetOperation
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class OpportunityRepository @Inject constructor(
    private val remoteDataSource: OpportunityRemoteDatasource,
    private val localDataSource: OpportunityDao) {

    fun getOpportunities() = performGetOperation(
        databaseQuery = {
            localDataSource.getOpportunities()
        },
        networkCall = {
            remoteDataSource.getOpportunities()
        },
        saveCallResult = {
            localDataSource.insertAll(it.data.listOfOpportunities)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({

                },{

                })
        }
    )
}