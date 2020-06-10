package com.zxj.wukong.repository.web.api

import com.zxj.wukong.repository.web.response.CasesInfoResponse
import retrofit2.Call
import retrofit2.http.GET

interface WuKongServerApi {
    @GET("queryCasesInfo")
    fun getCasesInfo():Call<CasesInfoResponse>
}