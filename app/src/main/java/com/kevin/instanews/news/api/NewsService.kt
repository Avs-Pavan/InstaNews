package com.kevin.instanews.news.api

import com.kevin.instanews.news.model.NewsSourceResponse
import retrofit2.Response
import retrofit2.http.GET

/**
 * Fetch all the latest news article from various news services
 * using the News API.
 */
interface NewsService {

    /**
     * Retrieves all the latest news article from Google news using News API.
     */
    @GET("articles?source=google-news&apiKey=d0796a2285b043acb5d19378d2cfbad9")
    suspend fun getNewsFromGoogle(): Response<NewsSourceResponse>



}
