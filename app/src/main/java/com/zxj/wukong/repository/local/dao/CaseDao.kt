package com.zxj.wukong.repository.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.zxj.wukong.data.CaseInfo

@Dao
interface CaseDao {
    @Query("select * from caseInfo where name like '%' || :keyWord || '%' or `desc` like '%' ||:keyWord || '%'")
    suspend fun queryByKeyWord(keyWord: String): List<CaseInfo>

    @Query("select * from caseInfo")
    fun queryAll(): List<CaseInfo>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(list: List<CaseInfo>)
}