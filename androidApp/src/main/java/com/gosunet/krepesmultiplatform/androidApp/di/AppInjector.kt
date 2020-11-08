package com.gosunet.krepesmultiplatform.androidApp.di

import com.gosunet.krepesmultiplatform.androidApp.features.crepeslist.CrepesListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { CrepesListViewModel(get()) }
}
