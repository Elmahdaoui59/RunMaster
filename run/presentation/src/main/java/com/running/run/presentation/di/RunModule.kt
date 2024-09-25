package com.running.run.presentation.di

import com.running.run.presentation.run_overview.RunOverviewViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val runModule = module {
    viewModelOf(::RunOverviewViewModel)
}