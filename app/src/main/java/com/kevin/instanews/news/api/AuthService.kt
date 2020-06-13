package com.kevin.instanews.news.api

import LoginResponse
import com.kevin.instanews.core.ui.ViewState
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST


/**
 * Fetch all the latest news article from various news services
 * using the News API.
 */
interface AuthService {
    @FormUrlEncoded
    @POST("/login")
    fun login(
        @Field("number") num: String?,
        @Field("password") pass: String?
    ): ViewState<LoginResponse>

}
