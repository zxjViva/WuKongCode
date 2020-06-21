package com.zxj.wukong.repository.local.dao

import androidx.room.*
import com.zxj.wukong.data.CaseInfo

@Dao
interface ShoppingCartDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(caseInfo: CaseInfo)

    @Query("select * from caseInfo")
    fun queryAll():List<CaseInfo>

    @Delete
    fun delete(caseInfo: CaseInfo)
}