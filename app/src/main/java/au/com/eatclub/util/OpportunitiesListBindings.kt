package au.com.eatclub.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import au.com.eatclub.adapters.OpportunitiesAdapter
import au.com.eatclub.models.entitymodels.Opportunity
import com.squareup.picasso.Picasso


@BindingAdapter("app:items")
fun setItems(listView: RecyclerView, items: List<Opportunity>?) {
    items?.let {
        (listView.adapter as OpportunitiesAdapter).notifyDataSetChanged()
    }
}

@BindingAdapter("bind:imageUrl")
fun setImageUrl(view: ImageView, url: String?) {
    Picasso.get().load(url).into(view)
}