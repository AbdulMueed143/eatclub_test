package au.com.eatclub.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import au.com.eatclub.adapters.OpportunitiesAdapter
import au.com.eatclub.databinding.OpportunityListFragmentBinding
import au.com.eatclub.di.ViewModelProviderFactory
import au.com.eatclub.models.viewmodels.OpportunityViewModel
import au.com.eatclub.util.EventObserver
import au.com.eatclub.util.Resource
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class OpportunityListFragment : DaggerFragment() {

    @Inject lateinit var viewModelProviderFactory : ViewModelProviderFactory
    private lateinit var opportunityListFragmentBinding : OpportunityListFragmentBinding
    private lateinit var viewModel : OpportunityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this, viewModelProviderFactory).get(OpportunityViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        opportunityListFragmentBinding = OpportunityListFragmentBinding.inflate(inflater, container, false).apply {
            opportunityViewModel = viewModel
        }

        return opportunityListFragmentBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupRecyclerView()

        viewModel.loaOpportunities()
        setupObservers()
    }

    fun setupRecyclerView() {
        val vm = opportunityListFragmentBinding.opportunityViewModel
        vm?.let {
            opportunityListFragmentBinding.rcyOpportunities.adapter = OpportunitiesAdapter(it)
        } ?: kotlin.run {

        }
    }

    private fun setupObservers() {

        viewModel._opportunities?.observe(viewLifecycleOwner, Observer {

            when(it.status) {

                Resource.Status.SUCCESS -> {
                    if (!it.data.isNullOrEmpty())
                        it.data.let {
                            viewModel.opportunities = it
                            opportunityListFragmentBinding.rcyOpportunities.adapter?.notifyDataSetChanged()
                        }
                }

                Resource.Status.ERROR -> {
                    //We clear the data
                }

                Resource.Status.LOADING -> {
                    //We make sure there is loading bar
                }
            }
        })


        viewModel.increment.observe(viewLifecycleOwner, EventObserver {
            viewModel._opportunities?.value?.data?.forEach {
                opp -> kotlin.run {
                Log.d("Opportunities", it + " - " + opp.objectId)
                    if (it.equals(opp.objectId, ignoreCase = true)) {
                        if((opp.discountValue + 5) <= 50) {
                            opp.discount = (opp.discountValue + 5).toString()+"%"
                            opportunityListFragmentBinding.rcyOpportunities.adapter?.notifyDataSetChanged()
                        }
                    }
                }
            }
        })

        viewModel.decrement.observe(viewLifecycleOwner, EventObserver {
            viewModel._opportunities?.value?.data?.forEach {
                    opp -> kotlin.run {
                    Log.d("Opportunities", it + " - " + opp.objectId)
                    if (it.equals(opp.objectId, ignoreCase = true)) {
                        if((opp.discountValue - 5) >= 10) {
                            opp.discount = (opp.discountValue - 5).toString()+"%"
                            opportunityListFragmentBinding.rcyOpportunities.adapter?.notifyDataSetChanged()
                        }
                    }
                }
            }
        })
    }


}