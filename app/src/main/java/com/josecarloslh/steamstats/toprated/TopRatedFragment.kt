package com.josecarloslh.steamstats.toprated

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.josecarloslh.commons.BaseRecyclerViewFragment
import com.josecarloslh.commons.DataBindingRecyclerAdapter
import com.josecarloslh.steamstats.BR
import com.josecarloslh.steamstats.R
import com.josecarloslh.steamstats.data.DataSource
import com.josecarloslh.steamstats.deals.DealsModel
import com.josecarloslh.steamstats.mostowned.MostOwnedModel

class TopRatedFragment : BaseRecyclerViewFragment() {

    override fun getAdapter(): RecyclerView.Adapter<*> {
        return DataBindingRecyclerAdapter<DealsModel>(BR.topRated, R.layout.item_top_rated)
    }

    override fun onResume() {
        super.onResume()
        showTopRated()
    }

    private fun showTopRated() {
        DataSource
            .getTopRated()
            .subscribe({ topRatedList ->
                replaceItems(topRatedList)
            }, { error ->
                showError(error)
            })
    }

    private fun replaceItems(topRatedList: List<TopRatedModel>) {
        with(rvAdapter as DataBindingRecyclerAdapter<TopRatedModel>) {
            items.clear()
            items.addAll(topRatedList)
            notifyDataSetChanged()
        }
    }

    private fun showError(error: Throwable) {
        error.printStackTrace()
        view?.let {
            Snackbar.make(view as View, R.string.error_request, Snackbar.LENGTH_LONG)
                .setAction(R.string.snackbar_retry) { showTopRated() }
                .show()
        }
    }

}