package com.zxj.wukong.repository.web.response

import com.squareup.moshi.JsonClass
import com.zxj.wukong.data.CaseInfo
@JsonClass(generateAdapter = true)
class CasesInfoResponse {
    var casesInfo:List<CaseInfo> = listOf()
}