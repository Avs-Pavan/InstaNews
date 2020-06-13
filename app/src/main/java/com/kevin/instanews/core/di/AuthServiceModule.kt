package com.kevin.instanews.core.di

import com.kevin.instanews.news.api.AuthService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
object AuthServiceModule {


    private const val AUTH_URL = "http://api.nallas.in/"

    @Singleton
    @Provides
    fun provideAuthService(): AuthService {
        return Retrofit.Builder()
            .baseUrl(AUTH_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(AuthService::class.java)
    }
}