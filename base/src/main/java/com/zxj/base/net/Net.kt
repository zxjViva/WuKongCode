package com.zxj.base.net

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Net {
    private val retrofit: Retrofit by lazy {
        Retrofit.Builder().baseUrl("https://www.fastmock.site/mock/20e9f42cdade7baaf240e9f6de1e952e/wukong")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun<T> create(service:Class<T> ): T {
        return retrofit.create(service)
    }
}