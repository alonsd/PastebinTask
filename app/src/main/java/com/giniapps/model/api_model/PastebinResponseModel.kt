package com.giniapps.model.api_model

    data class PastebinResponseModel(val numbers: List<Number>) {

        data class Number(
            val number: Int
        )
    }