package com.josecarloslh.commons

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_recycler_view.view.*

abstract class BaseRecyclerViewFragment : BaseFragment() {

    lateinit var rvAdapter: RecyclerView.Adapter<*>

    override fun getLayoutResId(): Int = R.layout.fragment_recycler_view

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rvAdapter = getAdapter()

        with(view.rvBase) {
            adapter = rvAdapter
            layoutManager = LinearLayoutManager(context)
        }
    }

    abstract fun getAdapter() : RecyclerView.Adapter<*>
}