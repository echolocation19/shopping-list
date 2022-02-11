package com.example.shoppinglist.presentation.adapters

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView


/** set val because we need to use view parameter in onBindViewHolder  */
class ViewHolder(
    val binding: ViewDataBinding
    ) : RecyclerView.ViewHolder(binding.root)
