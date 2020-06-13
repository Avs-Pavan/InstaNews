package com.kevin.instanews.news.ui.activity

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import com.kevin.instanews.R
import com.kevin.instanews.core.ui.base.BaseActivity
import com.kevin.instanews.core.utils.getViewModel
import com.kevin.instanews.news.ui.viewmodel.AuthViewModel
import kotlinx.android.synthetic.main.activity_auth.*


class AuthActivity : BaseActivity() {

    private val authViewModal by lazy { getViewModel<AuthViewModel>() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)
        login_btn.setOnClickListener {
            Log.e("message", "login clicked")
            if (login_username.text.isNotEmpty()) {
                if (login_password.text.isNotEmpty()) {
                    // login
                    showLoading("")
                } else
                    login_password.error = "Field cannot be empty"

            } else {
                login_username.error = "Field cannot be empty"
                if (login_password.text.isEmpty())
                    login_password.error = "Field cannot be empty"
            }

        }
    }

    var mBuilder: AlertDialog.Builder? = null
    var mAlertDialog: AlertDialog? = null
    fun showLoading(message: String?) {
        val mDialogView = LayoutInflater.from(this).inflate(R.layout.loadig_view, null)
        //AlertDialogBuilder
        mBuilder = AlertDialog.Builder(this)
            .setView(mDialogView)
        //show dialog
        mAlertDialog = this.mBuilder?.show()
        Handler().postDelayed({
            dismissLoading()
            val mainIntent = Intent(this, NewsActivity::class.java)
            startActivity(mainIntent)
            finish()
        }, 3000)
    }

    fun dismissLoading() {
        this.mAlertDialog?.dismiss()
    }

}




