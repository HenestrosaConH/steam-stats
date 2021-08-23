package com.josecarloslh.steamstats.deals

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.josecarloslh.commons.BaseFragment
import com.josecarloslh.commons.BaseRecyclerViewFragment
import com.josecarloslh.commons.DataBindingRecyclerAdapter
import com.josecarloslh.steamstats.BR
import com.josecarloslh.steamstats.R
import com.josecarloslh.steamstats.data.DataSource
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import org.reactivestreams.Subscriber
import java.util.concurrent.Flow

class DealsFragment : BaseRecyclerViewFragment() {

    override fun getAdapter(): RecyclerView.Adapter<*> {
        return DataBindingRecyclerAdapter<DealsModel>(BR.deal, R.layout.item_deal)
    }

    override fun onResume() {
        super.onResume()
        showDeals()
    }

    private fun showDeals() {
        DataSource
            .getDeals()
            .subscribe({ dealsList ->
                replaceItems(dealsList)
            }, { error ->
                showError(error)
            })
    }

    private fun replaceItems(dealsList: List<DealsModel>) {
        with(rvAdapter as DataBindingRecyclerAdapter<DealsModel>) {
            items.clear()
            items.addAll(dealsList)
            notifyDataSetChanged()
        }
    }

    private fun showError(error: Throwable) {
        error.printStackTrace()
        view?.let {
            Snackbar.make(view as View, R.string.error_request, Snackbar.LENGTH_LONG)
                .setAction(R.string.snackbar_retry) { showDeals() }
                .show()
        }
    }

}