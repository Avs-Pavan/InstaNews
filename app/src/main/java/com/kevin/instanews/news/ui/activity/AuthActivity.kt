package com.kevin.instanews.news.ui.activity

import android.os.Bundle
import com.kevin.instanews.R
import com.kevin.instanews.core.ui.base.BaseActivity
import com.kevin.instanews.core.utils.getViewModel
import com.kevin.instanews.news.ui.viewmodel.AuthViewModel

class AuthActivity :  BaseActivity() {

    private val authViewModal by lazy { getViewModel<AuthViewModel>() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)
        authViewModal.login()
    }
}