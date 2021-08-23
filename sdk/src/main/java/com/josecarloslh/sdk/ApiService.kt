package com.josecarloslh.sdk

import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import com.josecarloslh.sdk.serializer.ListTopRatedDeserialized
import com.josecarloslh.sdk.serializer.TopRatedDeserializer
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class ApiService(apiConfig: ApiConfig = ClientConfig()) {

    val apiClient: RetrofitInstanciable

    init {
        //typeToken returns the data type that we get from the ArrayList
        //We have to create the constructor because
        // the one form the class is protected
        val typeToken = object : TypeToken<ArrayList<TopRated>>(){}.type

        val gson = GsonBuilder()
            .registerTypeAdapter(typeToken, ListTopRatedDeserialized())
            .registerTypeAdapter(TopRated::class.java, TopRatedDeserializer())
            .create()

        val apiClientConfig =
            Retrofit.Builder()
                .baseUrl(Paths.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())

        apiConfig.setupConfig(apiClientConfig)

        apiClient = apiClientConfig
            .build()
            .create(RetrofitInstanciable::class.java)
    }

}