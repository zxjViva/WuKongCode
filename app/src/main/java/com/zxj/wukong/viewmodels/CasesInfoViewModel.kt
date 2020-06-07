package com.zxj.wukong.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.zxj.base.net.Net
import com.zxj.base.net.NetResult
import com.zxj.wukong.data.CaseInfo
import com.zxj.wukong.repository.web.api.WuKongServerApi
import com.zxj.wukong.repository.web.response.CasesInfoResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CasesInfoViewModel:ViewModel() {
    val casesInfo:MutableLiveData<NetResult<List<CaseInfo>>> by lazy {
        requestApi()
        MutableLiveData<NetResult<List<CaseInfo>>>()
    }

    private fun requestApi(){
        val api = Net.create(WuKongServerApi::class.java)
        api.getCasesInfo().enqueue(object : Callback<CasesInfoResponse>{
            override fun onFailure(call: Call<CasesInfoResponse>, t: Throwable) {
                casesInfo.postValue(NetResult(null,t))
            }

            override fun onResponse(
                call: Call<CasesInfoResponse>,
                response: Response<CasesInfoResponse>
            ) {
                casesInfo.postValue(NetResult(response.body()?.casesInfo,null))
            }

        })
    }
}