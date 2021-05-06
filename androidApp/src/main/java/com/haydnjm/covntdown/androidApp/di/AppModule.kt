package com.haydnjm.covntdown.androidApp.di

import com.haydnjm.covntdown.androidApp.ui.CovntdownViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { CovntdownViewModel(get()) }
}