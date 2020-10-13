package com.giniapps.service_locator

import com.giniapps.network.respository.MainRepository
import org.koin.dsl.module

val repositoryModule = module {

    single { MainRepository() }
}