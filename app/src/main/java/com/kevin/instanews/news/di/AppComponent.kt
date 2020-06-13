package com.kevin.instanews.news.di

import android.app.Application
import com.kevin.instanews.InstaNewsApp
import com.kevin.instanews.core.di.NewsServiceModule
import com.kevin.instanews.core.di.ViewModelFactoryModule

import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        // Dagger support
        AndroidInjectionModule::class,

        // Global
        NewsDatabaseModule::class,
        NewsServiceModule::class,
        ViewModelFactoryModule::class,

        // News feature
        NewsFeatureBindingModule::class
    ]
)
interface AppComponent : AndroidInjector<InstaNewsApp> {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: Application): AppComponent
    }

    override fun inject(newsApp: InstaNewsApp)
}
