package com.rupp.fe.ruppassignment.adapter

import androidx.recyclerview.widget.DiffUtil

class FeedDiffCallBack(
        private val viewBinder: Map<FeedItemClass, FeedItemBinder>
) : DiffUtil.ItemCallback<Any>() {
    override fun areItemsTheSame(oldItem: Any, newItem: Any): Boolean {
        if (oldItem::class.java != newItem::class.java) {
            return false
        }
        return viewBinder[oldItem::class.java]?.areItemsTheSame(oldItem, newItem) ?: false
    }

    override fun areContentsTheSame(oldItem: Any, newItem: Any): Boolean {
        return viewBinder[oldItem::class.java]?.areContentsTheSame(oldItem, newItem) ?: false
    }
}