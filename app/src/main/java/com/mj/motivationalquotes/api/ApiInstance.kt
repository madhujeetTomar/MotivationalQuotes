package com.mj.motivationalquotes.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiInstance {
    private const val BASE_URL = "https://quotable.io/"

    fun getQuotesApiInstance(): QuotesApi {
        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(QuotesApi::class.java)
    }
}