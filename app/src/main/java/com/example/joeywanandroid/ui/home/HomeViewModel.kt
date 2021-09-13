package com.example.joeywanandroid.ui.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.joeywanandroid.bean.ArticleBean
import com.example.joeywanandroid.bean.ArticleWrapper
import com.example.joeywanandroid.bean.WanRequestRoot
import com.example.joeywanandroid.net.WanService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val wanService: WanService) : ViewModel() {
    private val TAG = "HomeViewModel"
    public fun getArticle() {
        viewModelScope.launch(Dispatchers.IO) {
            val call = wanService.getHomeArticle(0)
            call.enqueue(object : Callback<WanRequestRoot<ArticleWrapper<ArticleBean>>> {
                override fun onResponse(
                    call: Call<WanRequestRoot<ArticleWrapper<ArticleBean>>>,
                    response: Response<WanRequestRoot<ArticleWrapper<ArticleBean>>>
                ) {
                    Log.e(TAG, "onResponse: ${response.body()}")
                }

                override fun onFailure(
                    call: Call<WanRequestRoot<ArticleWrapper<ArticleBean>>>,
                    t: Throwable
                ) {
                    Log.e(TAG, "onFailure: $t" )
                }

            })
        }
    }
}