package com.rupp.fe.ruppassignment.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

abstract class FeedItemViewBinder<M, in VH : RecyclerView.ViewHolder>(val classModel: Class<out M>)
    : DiffUtil.ItemCallback<M>() {
    abstract fun createViewHolder(parent: ViewGroup): RecyclerView.ViewHolder
    abstract fun bindingViewHolder(model: M, viewHolder: VH)
    abstract fun getFeedItemType(): Int

    open fun onViewRecycled(viewHolder: VH) = Unit
    open fun onViewDetachedFromWindow(viewHolder: VH) = Unit
}