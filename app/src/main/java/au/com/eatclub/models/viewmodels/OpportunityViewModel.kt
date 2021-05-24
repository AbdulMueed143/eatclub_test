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

    private val _postNowEvent = MutableLiveData<Event<String>>()
    val postNowEvent: LiveData<Event<String>> = _postNowEvent

    private val _increment = MutableLiveData<Event<String>>()
    val increment: LiveData<Event<String>> = _increment

    private val _decrement = MutableLiveData<Event<String>>()
    val decrement: LiveData<Event<String>> = _decrement

    fun loaOpportunities() {
        _opportunities = opportunityRepository.getOpportunities()
    }

    fun incrementValue(objectId: String) {
        _increment.value = Event(objectId)
    }

    fun decrementValue(objectId: String) {
        _decrement.value = Event(objectId)


    }

}