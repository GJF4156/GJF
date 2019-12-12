package com.item.testproject2.pojo.services;

import com.item.testproject2.pojo.Article;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ArticleService {

    @GET("article/selectAllArticle")
    Call<Article> articles();
}
