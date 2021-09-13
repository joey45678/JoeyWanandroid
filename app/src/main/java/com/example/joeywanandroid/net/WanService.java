package com.example.joeywanandroid.net;

import com.example.joeywanandroid.bean.ArticleBean;
import com.example.joeywanandroid.bean.ArticleWrapper;
import com.example.joeywanandroid.bean.WanRequestRoot;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface WanService {
//    @GET("users/{user}/repos")
//    Call<List<Repo>> listRepos(@Path("user") String user);

    @GET("/article/list/{page}/json")
    Call<WanRequestRoot<ArticleWrapper<ArticleBean>>> getHomeArticle(@Path("page") int page);


}
