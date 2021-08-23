package com.josecarloslh.sdk

import okhttp3.OkHttpClient
import retrofit2.Retrofit

class ClientConfig : ApiConfig {

    override fun setupConfig(builder: Retrofit.Builder) {
        val client: OkHttpClient = OkHttpClient.Builder()
            .addInterceptor(MockResponseInterceptor(getMockResponses(), DEFAULT_RESPONSE))
            .build()

        builder.client(client)
    }

    private fun getMockResponses(): HashMap<String, String> {
        return hashMapOf(
            Pair(Paths.GET_DEALS, MockResponses.DEALS_RESPONSE),
            Pair(Paths.GET_TOP_100_GAMES, MockResponses.TOP_100_GAMES),
            Pair(Paths.GET_MOST_OWNED_GAMES, MockResponses.TOP_100_GAMES)
        )
    }

    companion object {
        const val DEFAULT_RESPONSE = "{\"status\" : \"success\"}"
    }

}