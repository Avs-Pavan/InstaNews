package com.kevin.instanews.news.ui.viewmodel


import LoginResponse
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.kevin.instanews.core.ui.ViewState
import com.kevin.instanews.news.domain.AuthRepository
import com.kevin.instanews.news.domain.NewsRepository
import com.kevin.instanews.news.model.NewsArticles

import javax.inject.Inject

/**
 * A container for [NewsArticles] related data to show on the UI.
 */
class AuthViewModel @Inject constructor(
   authRepository: AuthRepository
) : ViewModel() {

    private val authRes: LiveData<ViewState<LoginResponse>> = authRepository.login().asLiveData()

    fun login(): LiveData<ViewState<LoginResponse>> = authRes
}