package au.com.eatclub.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import au.com.eatclub.databinding.OpportunityItemBinding
import au.com.eatclub.models.entitymodels.Opportunity
import au.com.eatclub.models.viewmodels.OpportunityViewModel

class OpportunitiesAdapter(private val opportunityViewModel: OpportunityViewModel) : RecyclerView.Adapter<OpportunitiesAdapter.ViewHolder>() {

    class ViewHolder(val binding: OpportunityItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(viewModel: OpportunityViewModel, item : Opportunity?) {
            binding.opportunityViewModel = viewModel
            binding.opportunity = item
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup) : ViewHolder {
                val inflater = LayoutInflater.from(parent.context)
                val binding = OpportunityItemBinding.inflate(inflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = opportunityViewModel.opportunities?.get(position)
        return holder.bind(opportunityViewModel, item)
    }

    override fun getItemCount(): Int = opportunityViewModel.opportunities?.size ?: 0

    override fun getItemViewType(position: Int): Int {
        return position
    }
}