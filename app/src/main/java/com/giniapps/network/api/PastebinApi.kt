package com.giniapps.network.api

import com.giniapps.model.api_model.PastebinResponseModel
import retrofit2.Response
import retrofit2.http.GET

interface PastebinApi {

    @GET("/raw/8wJzytQX")
    suspend fun getNumbers() : Response<PastebinResponseModel>

}