package com.example.shoppinglist.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.shoppinglist.R
import com.example.shoppinglist.domain.ShopItem

class ShopListAdapter: ListAdapter<ShopItem, ViewHolder>(ShopItemDiffCallback()) {

    var onLongClickListener: ((ShopItem) -> Unit)? = null
    var onClickListener: ((ShopItem) -> Unit)? = null

    companion object {
        const val VIEW_TYPE_DISABLED = 0
        const val VIEW_TYPE_ENABLED = 1

        const val MAX_POOL_SIZE = 15
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layout = when (viewType) {
            VIEW_TYPE_ENABLED -> R.layout.item_shop_enabled
            VIEW_TYPE_DISABLED -> R.layout.item_shop_disabled
            else -> throw RuntimeException("Unknown view type $viewType")
        }
        val view = LayoutInflater.from(parent.context).inflate(layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val shopItem = getItem(position)
        holder.tvName.text = shopItem.name
        holder.tvCount.text = shopItem.count.toString()
        holder.view.setOnLongClickListener {
            onLongClickListener?.invoke(shopItem)
            true
        }
        holder.view.setOnClickListener {
            onClickListener?.invoke(shopItem)
        }

    }

    override fun getItemViewType(position: Int): Int {
        return if (getItem(position).enabled) VIEW_TYPE_ENABLED else VIEW_TYPE_DISABLED
    }
}




