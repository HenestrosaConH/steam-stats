package com.josecarloslh.sdk

import retrofit2.Retrofit

interface ApiConfig {
    fun setupConfig(builder: Retrofit.Builder)
}