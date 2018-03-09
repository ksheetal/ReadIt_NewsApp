package com.crypticducs000webhost.newsapp;

import android.provider.ContactsContract;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

/**
 * Created by Hp on 1/20/2018.
 */

public interface NewsService {
    @GET("v1/sources?language=en")
    Call<WebSite> getSources();


    @GET
    Call<News> getNewestArticles(@Url String url);

}
