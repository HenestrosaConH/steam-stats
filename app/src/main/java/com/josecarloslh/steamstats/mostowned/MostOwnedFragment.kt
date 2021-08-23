package com.josecarloslh.steamstats.mostowned

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.josecarloslh.steamstats.BR
import com.josecarloslh.commons.BaseRecyclerViewFragment
import com.josecarloslh.commons.DataBindingRecyclerAdapter
import com.josecarloslh.steamstats.R
import com.josecarloslh.steamstats.data.DataSource
import com.josecarloslh.steamstats.deals.DealsModel
import com.josecarloslh.steamstats.toprated.TopRatedModel

class MostOwnedFragment : BaseRecyclerViewFragment() {

    override fun getAdapter(): RecyclerView.Adapter<*> {
        return DataBindingRecyclerAdapter<TopRatedModel>(BR.mostOwned, R.layout.item_most_owned)
    }

    override fun onResume() {
        super.onResume()
        showMostOwned()
    }

    private fun showMostOwned() {
        DataSource
            .getMostOwned()
            .subscribe({ mostOwnedList ->
                replaceItems(mostOwnedList)
            }, { error ->
                showError(error)
            })
    }

    private fun replaceItems(mostOwnedList: List<TopRatedModel>) {
        with(rvAdapter as DataBindingRecyclerAdapter<TopRatedModel>) {
            items.clear()
            items.addAll(mostOwnedList)
            notifyDataSetChanged()
        }
    }

    private fun showError(error: Throwable) {
        error.printStackTrace()
        view?.let {
            Snackbar.make(view as View, R.string.error_request, Snackbar.LENGTH_LONG)
                .setAction(R.string.snackbar_retry) { showMostOwned() }
                .show()
        }
    }

}