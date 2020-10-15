package com.giniapps.network.respository

import com.giniapps.model.api_model.PastebinResponseModel
import com.giniapps.network.api.PastebinApi
import com.giniapps.utils.network.ResponseHandler


class MainRepository(
    private val responseHandler: ResponseHandler,
    private val pastebinApi: PastebinApi
) {

    suspend fun getAllNumbers(): ResponseHandler.Resource<PastebinResponseModel> {
        return try {
            responseHandler.handleSuccess(pastebinApi.getNumbers())
        } catch (e: Exception) {
            responseHandler.handleException(e)
        }
    }
}