package com.zxj.wukong.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.JsonClass

@Entity
@JsonClass(generateAdapter = true)
data class CaseInfo(
    @PrimaryKey var id: String,
    @ColumnInfo var name: String,
    @ColumnInfo var snapshotUrl: String,
    @ColumnInfo var author: String,
    @ColumnInfo var desc: String,
    @ColumnInfo  var index:Int?//moshi对于非json 字段,需要加问号
)