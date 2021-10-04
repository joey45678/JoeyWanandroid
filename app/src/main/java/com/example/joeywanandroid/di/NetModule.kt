package com.example.joeywanandroid.di

import com.example.joeywanandroid.constant.URL
import com.example.joeywanandroid.net.WanService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


@InstallIn(SingletonComponent::class)
@Module
class NetModule {

    @Provides
    fun provideOkhttpClient():OkHttpClient{
        val timeOut:Long  = 1
        val client = OkHttpClient.Builder()
            .retryOnConnectionFailure(true)
            .connectTimeout(timeOut, TimeUnit.SECONDS) //连接超时
            .readTimeout(timeOut, TimeUnit.SECONDS) //读取超时
            .writeTimeout(timeOut, TimeUnit.SECONDS) //写超时
            .build()
        return client
    }

    @Provides
    fun provideRetrofit(client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(URL.wanBase)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }

    @Provides
    fun provideWanService(retrofit: Retrofit): WanService {
        return retrofit.create(WanService::class.java)
    }

}