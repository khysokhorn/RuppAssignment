package com.rupp.fe.ruppassignment.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

typealias FeedItemClass = Class<out Any>
typealias FeedItemBinder = FeedItemViewBinder<Any, RecyclerView.ViewHolder>

class EventListAdapter(
        private val viewBinders: Map<FeedItemClass, FeedItemBinder>)
    : ListAdapter<Any, RecyclerView.ViewHolder>(FeedDiffCallBack(viewBinders)) {

    private val viewTypeBinders = viewBinders.mapKeys { it.value.getFeedItemType() }

    private fun getItemViewBinder(viewType: Int): FeedItemBinder = viewTypeBinders.getValue(viewType)

    override fun getItemViewType(position: Int): Int = viewBinders.getValue(super.getItemViewType(position).javaClass).getFeedItemType()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return getItemViewBinder(viewType).createViewHolder(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        return getItemViewBinder(getItemViewType(position)).bindingViewHolder(getItem(position), holder)
    }

    override fun onViewRecycled(holder: RecyclerView.ViewHolder) {
        getItemViewBinder(holder.itemViewType).onViewRecycled(holder)
        super.onViewRecycled(holder)
    }

    override fun onViewDetachedFromWindow(holder: RecyclerView.ViewHolder) {
        getItemViewBinder(holder.itemViewType).onViewDetachedFromWindow(holder)
        super.onViewDetachedFromWindow(holder)
    }

}