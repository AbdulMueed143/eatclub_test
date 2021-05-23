package au.com.eatclub.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import au.com.eatclub.database.dao.OpportunityDao
import au.com.eatclub.models.entitymodels.Opportunity
import au.com.eatclub.util.Constants

@Database(entities =  [Opportunity::class], version = Constants.DATABASE_VERSION, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun opportunityDao() : OpportunityDao

    companion object {
        private var instance : AppDatabase? = null

        fun getInstance(context: Context) : AppDatabase {
            synchronized(AppDatabase::class) {
                instance = Room.databaseBuilder(context.applicationContext, AppDatabase::class.java, Constants.DATABASE_NAME)
                    .fallbackToDestructiveMigration().build()
            }

            return instance!!
        }
    }
}