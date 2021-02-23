package com.ipsoft.mvvm_cleanarchitecture_everis_digitalinovationone.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 *
 *  Author:     Anthoni Ipiranga
 *  Project:    mvvm-cleanarchitecture-everis-digitalinovationone
 *  Date:       23/02/2021
 */

class MovieRestApiTask {
    companion object {
        const val BASE_URL = "https://raw.githubusercontent.com/"
    }

    private fun movieProvider(): Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun retrofitApi(): MovieApi = movieProvider().create(MovieApi::class.java)
}