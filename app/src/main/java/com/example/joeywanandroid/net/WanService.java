package com.example.joeywanandroid.net;

import com.example.joeywanandroid.bean.ArticleBean;
import com.example.joeywanandroid.bean.ArticleWrapper;
import com.example.joeywanandroid.bean.BannerBean;
import com.example.joeywanandroid.bean.HotKeyBean;
import com.example.joeywanandroid.bean.WanRequestRoot;
import com.example.joeywanandroid.bean.WebsiteBean;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface WanService {
    /**
     * 获取首页文章列表
     * @param page
     * @return
     */
    @GET("/article/list/{page}/json")
    Call<WanRequestRoot<ArticleWrapper<ArticleBean>>> getHomeArticle(@Path("page") int page);

    /**
     * 获取首页置顶文章
     * @return
     */
    @GET("/article/top/json")
    Call<WanRequestRoot<List<ArticleBean>>> getHomeTopArticle();

    /**
     * 获取首页轮播图片
     * @return
     */
    @GET("/banner/json")
    Call<WanRequestRoot<List<BannerBean>>> getHomeBanner();

    /**
     * 获取首页搜索热词
     * @return
     */
    @GET("/hotkey/json")
    Call<WanRequestRoot<List<HotKeyBean>>> getHomeHotKey();
//    test to parse json by manual operation
    @GET("/hotkey/json")
    Call<WanRequestRoot<Object>> getHomeHotKey2();


    @GET("/friend/json")
    Call<WanRequestRoot<List<WebsiteBean>>> getFriendWebsite();
}
