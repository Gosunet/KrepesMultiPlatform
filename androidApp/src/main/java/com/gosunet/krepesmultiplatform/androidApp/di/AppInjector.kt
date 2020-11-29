package com.gosunet.krepesmultiplatform.androidApp.di

import com.bumptech.glide.Glide
import com.gosunet.krepesmultiplatform.androidApp.features.crepeslist.CrepesListViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { CrepesListViewModel(get()) }
    single { Glide.with(androidContext()) }
}
