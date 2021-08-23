package com.josecarloslh.commons

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

/**
 * This class has the logic for setting the values from the model into views
 * We know that DataBindingViewHolder is MODEL type and needs two parameters
 */
class DataBindingViewHolder<MODEL>(val itemVariableId: Int, val binding: ViewDataBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bindItem(item: MODEL) {
        binding.setVariable(itemVariableId, item)
        binding.executePendingBindings()
    }
}