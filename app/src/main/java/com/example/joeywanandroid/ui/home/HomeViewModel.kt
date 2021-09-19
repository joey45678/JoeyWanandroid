package com.example.joeywanandroid.ui.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.joeywanandroid.bean.*
import com.example.joeywanandroid.net.WanService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.json.JSONArray
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*
import javax.inject.Inject
import kotlin.collections.ArrayList

@HiltViewModel
class HomeViewModel @Inject constructor(private val wanService: WanService) : ViewModel() {
    private val TAG = "HomeViewModel"
    fun getHomeArticle() {
        viewModelScope.launch(Dispatchers.IO) {
            val call = wanService.getHomeArticle(0)
            call.enqueue(object : Callback<WanRequestRoot<ArticleWrapper<ArticleBean>>> {
                override fun onResponse(
                    call: Call<WanRequestRoot<ArticleWrapper<ArticleBean>>>,
                    response: Response<WanRequestRoot<ArticleWrapper<ArticleBean>>>
                ) {
                    Log.e(TAG, "onResponse getHomeArticle: ${response.body()}")
                }

                override fun onFailure(
                    call: Call<WanRequestRoot<ArticleWrapper<ArticleBean>>>,
                    t: Throwable
                ) {
                    Log.e(TAG, "onFailure getHomeArticle: $t")
                }

            })
        }
    }

    fun getHomeHotKey() {
        viewModelScope.launch(Dispatchers.IO) {
            val homeHotKey = wanService.homeHotKey
            homeHotKey.enqueue(object : Callback<WanRequestRoot<List<HotKeyBean>>> {
                override fun onResponse(
                    call: Call<WanRequestRoot<List<HotKeyBean>>>,
                    response: Response<WanRequestRoot<List<HotKeyBean>>>
                ) {
                    Log.e(TAG, "onResponse getHomeHotKey: ${response.body()}")
                }

                override fun onFailure(call: Call<WanRequestRoot<List<HotKeyBean>>>, t: Throwable) {
                    Log.e(TAG, "onFailure getHomeHotKey: $t")
                }
            })
        }
    }

    fun getHomeTopArticle() {
        viewModelScope.launch(Dispatchers.IO) {
            val homeTopArticle = wanService.homeTopArticle
            homeTopArticle.enqueue(object : Callback<WanRequestRoot<List<ArticleBean>>> {
                override fun onResponse(
                    call: Call<WanRequestRoot<List<ArticleBean>>>,
                    response: Response<WanRequestRoot<List<ArticleBean>>>
                ) {
                    Log.e(TAG, "onResponse getHomeTopArticle: ${response.body()}")
                }

                override fun onFailure(
                    call: Call<WanRequestRoot<List<ArticleBean>>>,
                    t: Throwable
                ) {
                    Log.e(TAG, "onFailure getHomeTopArticle: $t")
                }

            })
        }
    }

    fun getHomeBanner() {
        viewModelScope.launch(Dispatchers.IO) {
            val homeBanner = wanService.homeBanner
            homeBanner.enqueue(object : Callback<WanRequestRoot<List<BannerBean>>> {
                override fun onResponse(
                    call: Call<WanRequestRoot<List<BannerBean>>>,
                    response: Response<WanRequestRoot<List<BannerBean>>>
                ) {
                    Log.e(TAG, "onResponse getHomeBanner: ${response.body()}")
                }

                override fun onFailure(call: Call<WanRequestRoot<List<BannerBean>>>, t: Throwable) {
                    Log.e(TAG, "onFailure getHomeBanner: $t")
                }
            })
        }
    }

    fun getFriendWebsite() {
        viewModelScope.launch(Dispatchers.IO) {
            val friendWebsite = wanService.friendWebsite
            friendWebsite.enqueue(object : Callback<WanRequestRoot<List<WebsiteBean>>> {
                override fun onResponse(
                    call: Call<WanRequestRoot<List<WebsiteBean>>>,
                    response: Response<WanRequestRoot<List<WebsiteBean>>>
                ) {
                    Log.e(TAG, "onResponse getFriendWebsite: ${response.body()}")
                }

                override fun onFailure(
                    call: Call<WanRequestRoot<List<WebsiteBean>>>,
                    t: Throwable
                ) {
                    Log.e(TAG, "onFailure getFriendWebsite: $t")
                }

            })
        }
    }

//    test to parse json by manual operation
    fun getHomeHotKey2() {
        viewModelScope.launch(Dispatchers.IO) {
            val homeHotKey2 = wanService.homeHotKey2
            homeHotKey2.enqueue(object :Callback<WanRequestRoot<Any>>{
                override fun onResponse(
                    call: Call<WanRequestRoot<Any>>,
                    response: Response<WanRequestRoot<Any>>
                ) {

                    val arrayList = response.body()?.data as ArrayList<Any>
                    val jsonObject = JSONObject(arrayList.get(0) as Map<*, *>)


                    Log.e(TAG, "onResponse getHomeHotKey2: ${response.body()}")

                }

                override fun onFailure(call: Call<WanRequestRoot<Any>>, t: Throwable) {
                    Log.e(TAG, "onFailure getHomeHotKey2: $t")
                }

            })
        }
    }
}