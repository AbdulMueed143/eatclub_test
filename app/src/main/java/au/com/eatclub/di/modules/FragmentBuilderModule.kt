package au.com.eatclub.di.modules

import au.com.eatclub.fragments.OpportunityListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuilderModule {

    @ContributesAndroidInjector
    abstract fun contributesOpportunityListFragment() : OpportunityListFragment

}