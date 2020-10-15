package com.giniapps.service_locator

import com.giniapps.network.api.PastebinApi
import com.giniapps.utils.Constants.Networking.PASTEBIN_BASE_URL
import com.giniapps.utils.network.ResponseHandler
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {
    single { provideRetrofit() }
    single { provideApi(get()) }
    single { ResponseHandler() }
}

private fun provideRetrofit() = Retrofit.Builder().baseUrl(PASTEBIN_BASE_URL).addConverterFactory(
    GsonConverterFactory.create()).build()

private fun provideApi(retrofit: Retrofit): PastebinApi = retrofit.create(PastebinApi::class.java)