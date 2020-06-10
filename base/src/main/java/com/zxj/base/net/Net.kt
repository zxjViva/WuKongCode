package com.zxj.base.net

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object Net {
    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://www.fastmock.site/mock/20e9f42cdade7baaf240e9f6de1e952e/wukong")
            .addConverterFactory(
                MoshiConverterFactory.create(
                    Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
                )
            )
            .build()
    }

    fun <T> create(service: Class<T>): T {
        return retrofit.create(service)
    }
}