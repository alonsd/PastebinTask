package com.giniapps.network.api

import com.giniapps.model.api_model.PastebinResponseModel
import com.giniapps.utils.Constants
import com.giniapps.utils.Constants.Networking.PASTEBIN_BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object PastebinNetwork {

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(PASTEBIN_BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val pastebinApi: PastebinApi = retrofit.create(PastebinApi::class.java)


    suspend fun getNumbers() = pastebinApi.getNumbers()

}