package com.kevin.instanews.news.ui.adapter

import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter
import coil.api.load
import com.kevin.instanews.R
import com.kevin.instanews.news.model.NewsArticles
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

class VPAdapter(private val list: List<NewsArticles>) : PagerAdapter() {

    override fun isViewFromObject(v: View, `object`: Any): Boolean {
        // Return the current view
        return v === `object` as View
    }


    override fun getCount(): Int {
        // Count the items and return it
        return list.size
    }

    override fun instantiateItem(parent: ViewGroup, position: Int): Any {
        // Get the view from pager page layout
        val newsArticle = list[position]
        val view = LayoutInflater.from(parent?.context)
            .inflate(R.layout.row_news_article, parent, false)
        val newsTitle = view.findViewById<TextView>(R.id.newsTitle)
        val newsAuthor = view.findViewById<TextView>(R.id.newsAuthor)
        val newsPublishedAt = view.findViewById<TextView>(R.id.newsPublishedAt)
        val newsImage = view.findViewById<ImageView>(R.id.newsImage)

        newsTitle.text = newsArticle.title
        newsAuthor.text = newsArticle.author
        newsPublishedAt.text = newsArticle.publishedAt

        newsImage.load(newsArticle.urlToImage) {
            placeholder(R.drawable.tools_placeholder)
            error(R.drawable.tools_placeholder)
        }
        parent.addView(view)
        // Return the view
        return view
    }


    override fun destroyItem(parent: ViewGroup, position: Int, `object`: Any) {
        // Remove the view from view group specified position
        parent.removeView(`object` as View)
    }

}