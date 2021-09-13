package com.example.joeywanandroid.di

import com.example.joeywanandroid.net.WanService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/*
*

Retrofit retrofit = new Retrofit.Builder()
    .baseUrl("https://api.github.com/")
    .build();

GitHubService service = retrofit.create(GitHubService.class);

* */
@InstallIn(SingletonComponent::class)
@Module
class NetModule {
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://www.wanandroid.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    fun provideWanService(retrofit: Retrofit): WanService {
        return retrofit.create(WanService::class.java)
    }

}