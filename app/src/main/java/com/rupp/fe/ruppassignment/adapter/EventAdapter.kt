package com.rupp.fe.ruppassignment.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rupp.fe.ruppassignment.R
import com.rupp.fe.ruppassignment.adapter.viewHolder.EventListViewHolder
import com.rupp.fe.ruppassignment.databinding.ItemCustomEventListBinding
import com.rupp.fe.ruppassignment.model.eventModel.ItemModel
import com.rupp.fe.ruppassignment.utils.ItemOnClick

class EventAdapter : RecyclerView.Adapter<EventListViewHolder>() {
    var model: List<ItemModel> = listOf()

    var itemOnClick: ItemOnClick? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventListViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_custom_event_list, parent, false)
        val itemCustomEventListBinding = ItemCustomEventListBinding.bind(view)
        return EventListViewHolder(itemCustomEventListBinding)
    }

    override fun getItemCount(): Int {
        return model.size
    }

    override fun onBindViewHolder(holder: EventListViewHolder, position: Int) {
        val model = model[position]
        holder.itemBinding.tvTitle.text = model.summary
        val startTime = model.start.dateTime
        val endTime = model.end.dateTime
        holder.itemBinding.tvStartTime.text = startTime
        holder.itemBinding.tvEndTime.text = endTime
        holder.itemView.setOnClickListener {
            itemOnClick?.onItemClick(model)
        }

    }
}