package com.zxj.wukong.data

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CaseInfo(
    @Json(name = "name") val name: String,
    @Json(name = "snapshotUrl") val snapshotUrl: String,
    @Json(name = "author") val author: String,
    @Json(name = "desc") val desc: String
)