package com.josecarloslh.steamstats.data

import com.josecarloslh.sdk.ApiService
import com.josecarloslh.steamstats.deals.DealsMapper
import com.josecarloslh.steamstats.deals.DealsModel
import com.josecarloslh.steamstats.toprated.TopRatedMapper
import com.josecarloslh.steamstats.toprated.TopRatedModel
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import io.reactivex.android.schedulers.AndroidSchedulers
import kotlin.collections.ArrayList

object DataSource {

    private val apiService = ApiService()

    fun getDeals(): Observable<ArrayList<DealsModel>> = apiService.apiClient
        .getDealsObservable()
        .map { listDeals ->
            val dealsMap = listDeals.map { deal -> DealsMapper.fromSdk(deal) }
            val arrayList = arrayListOf<DealsModel>()
            arrayList.addAll(dealsMap)
            arrayList
        }
        .observeOn(AndroidSchedulers.mainThread())
        .subscribeOn(Schedulers.io())//in&out

    fun getTopRated(): Observable<ArrayList<TopRatedModel>> = apiService.apiClient
        .getTopRatedObservable()
        .map { listTopRated ->
            val topRatedMap = listTopRated.mapIndexed { index, topRated ->
                TopRatedMapper.fromSdk(
                    topRated,
                    index + 1
                )
            }
            val arrayList = arrayListOf<TopRatedModel>()
            arrayList.addAll(topRatedMap)
            arrayList
        }
        .observeOn(AndroidSchedulers.mainThread())
        .subscribeOn(Schedulers.io())//in&out

    fun getMostOwned(): Observable<ArrayList<TopRatedModel>> = apiService.apiClient
        .getMostOwnedObservable()
        .map { listMostOwned ->
            val mostOwnedMap = listMostOwned.mapIndexed { index, mostOwned ->
                TopRatedMapper.fromSdk(
                    mostOwned,
                    index + 1
                )
            }
            val arrayList = arrayListOf<TopRatedModel>()
            arrayList.addAll(mostOwnedMap)
            arrayList
        }
        .observeOn(AndroidSchedulers.mainThread())
        .subscribeOn(Schedulers.io())//in&out
}