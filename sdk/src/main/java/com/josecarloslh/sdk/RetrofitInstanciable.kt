package com.josecarloslh.sdk

import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitInstanciable {

    @GET(Paths.GET_DEALS)
    fun getDeals(): Call<ArrayList<Deals>>
    @GET(Paths.GET_DEALS)
    fun getDealsObservable(): Observable<ArrayList<Deals>>

    @GET(Paths.GET_TOP_100_GAMES)
    fun getTopRated(): Call<ArrayList<TopRated>>
    @GET(Paths.GET_TOP_100_GAMES)
    fun getTopRatedObservable(): Observable<ArrayList<TopRated>>

    @GET(Paths.GET_MOST_OWNED_GAMES)
    fun getMostOwned(): Call<ArrayList<TopRated>>
    @GET(Paths.GET_MOST_OWNED_GAMES)
    fun getMostOwnedObservable(): Observable<ArrayList<TopRated>>

}