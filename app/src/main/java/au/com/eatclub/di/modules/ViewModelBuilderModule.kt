package au.com.eatclub.di.modules

import androidx.lifecycle.ViewModel
import au.com.eatclub.di.annotations.ViewModelKey
import au.com.eatclub.fragments.OpportunityListFragment
import au.com.eatclub.models.viewmodels.OpportunityViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelBuilderModule {

    @Binds
    @IntoMap
    @ViewModelKey(OpportunityViewModel::class)
    abstract fun bindOpportunityListFragment(opportunityViewModel: OpportunityViewModel) : ViewModel
}