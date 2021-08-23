package com.josecarloslh.commons

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

class DataBindingRecyclerAdapter<MODEL>(val itemVariableId: Int, val itemLayoutResId: Int) :
    RecyclerView.Adapter<DataBindingViewHolder<MODEL>>() {

    //This are the items that will populate the RV
    val items = mutableListOf<MODEL>()

    //In order of execution, this is the first that gets executed to know how many items there will be
    override fun getItemCount(): Int {
        return items.size
    }

    /* Creates the view of the list items. Thanks to this, the RV is able to calculate how many items needs to
    populate the RV, because it won't load all the items of the list into the RV. That wouldn't be exactly
    "recycling", right? */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataBindingViewHolder<MODEL> {
        val binding: ViewDataBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            itemLayoutResId,
            parent,
            false
        )
        return DataBindingViewHolder(
            itemVariableId,
            binding
        ) //the item view in which we are going to bind the data
    }

    /* Populates the views of the view holder. We need to get the item that we are going to show and
    bind it in the DataBindingViewHolder */
    override fun onBindViewHolder(holder: DataBindingViewHolder<MODEL>, position: Int) {
        val item = items[position]
        holder.bindItem(item)
    }
}