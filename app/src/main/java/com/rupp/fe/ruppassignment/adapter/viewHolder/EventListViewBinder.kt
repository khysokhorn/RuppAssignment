package com.rupp.fe.ruppassignment.adapter.viewHolder

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rupp.fe.ruppassignment.R
import com.rupp.fe.ruppassignment.adapter.FeedItemViewBinder
import com.rupp.fe.ruppassignment.model.eventModel.GGCEventModel
import org.w3c.dom.Text

class EventListViewBinder(val block: (data: GGCEventModel) -> Unit)
    : FeedItemViewBinder<GGCEventModel, EventListViewBinder.VerticalImagesViewHolder>(GGCEventModel::class.java) {


    override fun createViewHolder(parent: ViewGroup): VerticalImagesViewHolder {
        return VerticalImagesViewHolder(
                LayoutInflater.from(parent.context).inflate(getFeedItemType(),
                        parent, false), block
        )
    }

    override fun bindingViewHolder(model: GGCEventModel, viewHolder: VerticalImagesViewHolder) {
        viewHolder.bind(model)
    }

    override fun getFeedItemType() = R.layout.item_custom_event_list

    override fun areItemsTheSame(oldItem: GGCEventModel, newItem: GGCEventModel) = oldItem == newItem

    override fun areContentsTheSame(oldItem: GGCEventModel, newItem: GGCEventModel): Boolean {
        return oldItem.items == newItem.items
    }

    class VerticalImagesViewHolder(val view: View, val block: (data: GGCEventModel) -> Unit)
        : RecyclerView.ViewHolder(view) {
        fun bind(data: GGCEventModel) {
            itemView.setOnClickListener {
                block(data)
            }
            itemView.apply {

            }
        }
    }

}


