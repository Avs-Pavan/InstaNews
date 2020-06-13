package com.kevin.instanews.news.ui.activity

import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.kevin.instanews.core.ui.ViewState
import com.kevin.instanews.core.ui.base.BaseActivity
import com.kevin.instanews.news.ui.viewmodel.NewsArticleViewModel
import com.kevin.instanews.R
import com.kevin.instanews.core.utils.Transformations.DepthTransformation
import com.kevin.instanews.core.utils.getViewModel
import com.kevin.instanews.core.utils.observeNotNull
import com.kevin.instanews.news.ui.adapter.VPAdapter
import kotlinx.android.synthetic.main.activity_news.*
import kotlinx.android.synthetic.main.empty_layout.*
import kotlinx.android.synthetic.main.progress_layout.*

class NewsActivity : BaseActivity() {

    private val newsArticleViewModel by lazy { getViewModel<NewsArticleViewModel>() }
    /**
     * Starting point of the activity
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)
        Toast.makeText(this,"Please scroll side ways", Toast.LENGTH_LONG).show()
        adapterViewFlipper.setPageTransformer(true,DepthTransformation())
        newsArticleViewModel.getNewsArticles().observeNotNull(this) { state ->
            when (state) {
                is ViewState.Success -> {
                    progress_view.visibility=View.INVISIBLE
                    empty_view.visibility=View.INVISIBLE
                    adapterViewFlipper.adapter=VPAdapter(state.data)
                }
                is ViewState.Loading -> {
                    adapterViewFlipper.visibility=View.VISIBLE
                    progress_view.visibility=View.VISIBLE
                    empty_view.visibility=View.INVISIBLE
                }
                is ViewState.Error -> {
                        adapterViewFlipper.visibility=View.INVISIBLE
                        progress_view.visibility=View.INVISIBLE
                        empty_view.visibility=View.VISIBLE
                }
            }
        }



    }
}
