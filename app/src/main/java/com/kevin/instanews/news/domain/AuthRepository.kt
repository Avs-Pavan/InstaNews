package com.kevin.instanews.news.domain

import LoginResponse
import com.kevin.instanews.core.ui.ViewState
import com.kevin.instanews.news.api.AuthService
import dagger.Binds
import dagger.Module
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Repository abstracts the logic of fetching the data and persisting it for
 * offline. They are the data source as the single source of truth.
 */
interface AuthRepository {
    fun login(): Flow<ViewState<LoginResponse>>
}

@Singleton
class DefaultAuthRepository @Inject constructor(
    private val authService: AuthService
) : AuthRepository {

    override fun login(): Flow<ViewState<LoginResponse>> {
       return flow {
           emit(authService.login("7382129781","12345678"))
       }
    }
}

@Module
interface AuthRepositoryModule {
    /* Exposes the concrete implementation for the interface */
    @Binds fun it(it: DefaultAuthRepository): AuthRepository
}