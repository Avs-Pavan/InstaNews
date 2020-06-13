package com.kevin.instanews.news.di


import com.kevin.instanews.news.domain.NewsRepositoryModule
import com.kevin.instanews.news.ui.activity.AuthActivity
import com.kevin.instanews.news.ui.activity.NewsActivity
import com.kevin.instanews.news.ui.activity.SplashActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Describes list of activities which require
 * DI.
 *
 * Each [ContributesAndroidInjector] generates a sub-component
 * for each activity under the hood
 */
@Module(includes = [
    NewsViewModelModule::class,
    NewsRepositoryModule::class
])
interface NewsFeatureBindingModule {

    @ContributesAndroidInjector
    fun contributeNewsActivity(): NewsActivity
    @ContributesAndroidInjector
    fun contributeAuthActivity(): AuthActivity
    @ContributesAndroidInjector
    fun contributeSplashActivity(): SplashActivity
}