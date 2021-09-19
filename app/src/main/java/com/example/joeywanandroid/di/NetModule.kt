package com.example.joeywanandroid.di

import com.example.joeywanandroid.constant.URL
import com.example.joeywanandroid.net.WanService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


@InstallIn(SingletonComponent::class)
@Module
class NetModule {
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(URL.wanBase)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    fun provideWanService(retrofit: Retrofit): WanService {
        return retrofit.create(WanService::class.java)
    }

}