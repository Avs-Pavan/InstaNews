package com.kevin.instanews.news.ui.activity

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.kevin.instanews.news.ui.adapter.NewsArticlesAdapter
import com.kevin.instanews.core.ui.ViewState
import com.kevin.instanews.core.ui.base.BaseActivity
import com.kevin.instanews.news.ui.viewmodel.NewsArticleViewModel
import com.kevin.instanews.R
import com.kevin.instanews.core.utils.getViewModel
import com.kevin.instanews.core.utils.observeNotNull
import com.kevin.instanews.core.utils.toast
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_news.*
import kotlinx.android.synthetic.main.empty_layout.*
import kotlinx.android.synthetic.main.progress_layout.*

class NewsActivity : BaseActivity() {

    private val newsArticleViewModel by lazy { getViewModel<NewsArticleViewModel>() }

    /**
     * Starting point of the activity
     */
    override fun onCreate(savedInstanceState: Bundle?) {
       // AndroidInjection.inject(this) // injection happens here
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)

        // Setting up RecyclerView and adapter
        newsList.setEmptyView(empty_view)
        newsList.setProgressView(progress_view)

        val adapter = NewsArticlesAdapter { toast("Clicked on item") }
        newsList.adapter = adapter
        newsList.layoutManager = LinearLayoutManager(this)

        // Update the UI on state change
        newsArticleViewModel.getNewsArticles().observeNotNull(this) { state ->
            when (state) {
                is ViewState.Success -> adapter.submitList(state.data)
                is ViewState.Loading -> newsList.showLoading()
                is ViewState.Error -> toast("Something went wrong ¯\\_(ツ)_/¯ => ${state.message}")
            }
        }

    }
}
