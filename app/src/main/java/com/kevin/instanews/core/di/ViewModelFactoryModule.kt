package com.kevin.instanews.core.di

import androidx.lifecycle.ViewModelProvider
import com.kevin.instanews.core.di.base.ViewModelFactory
import dagger.Binds
import dagger.Module

@Module
interface ViewModelFactoryModule {

    @Binds
    fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}