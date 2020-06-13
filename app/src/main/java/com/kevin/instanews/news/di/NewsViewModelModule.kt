package com.kevin.instanews.news.di


import androidx.lifecycle.ViewModel
import com.kevin.instanews.core.di.base.ViewModelKey
import com.kevin.instanews.news.ui.viewmodel.NewsArticleViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface NewsViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(NewsArticleViewModel::class)
    fun bindNewsArticleViewModel(newsArticleViewModel: NewsArticleViewModel): ViewModel
}