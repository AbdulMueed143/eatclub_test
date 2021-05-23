package au.com.eatclub.models.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import au.com.eatclub.database.repositories.OpportunityRepository
import au.com.eatclub.models.entitymodels.Opportunity
import au.com.eatclub.util.Event
import au.com.eatclub.util.Resource
import javax.inject.Inject

class OpportunityViewModel  @Inject constructor(private val opportunityRepository: OpportunityRepository) : ViewModel() {

    var _opportunities : LiveData<Resource<List<Opportunity>>>? = null
    var opportunities : List<Opportunity>? = null

    private val _postNowEvent = MutableLiveData<Event<Int>>()
    val postNowEvent: LiveData<Event<Int>> = _postNowEvent

    private val _increment = MutableLiveData<Event<Int>>()
    val increment: LiveData<Event<Int>> = _increment

    private val _decrement = MutableLiveData<Event<Int>>()
    val decrement: LiveData<Event<Int>> = _decrement

    fun loaOpportunities() {
        _opportunities = opportunityRepository.getOpportunities()
    }

}