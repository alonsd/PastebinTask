package com.giniapps.service_locator

import com.giniapps.view.viewmodel.MainViewModel
import org.koin.dsl.module

val viewModelModule = module {

    single { MainViewModel(get()) }
}