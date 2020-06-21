package com.zxj.wukong.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@Entity
@JsonClass(generateAdapter = true)
data class CaseInfo(
    @PrimaryKey @Json(name = "id") val id: String,
    @ColumnInfo @Json(name = "name") val name: String,
    @ColumnInfo @Json(name = "snapshotUrl") val snapshotUrl: String,
    @ColumnInfo @Json(name = "author") val author: String,
    @ColumnInfo @Json(name = "desc") val desc: String
)