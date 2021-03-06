package com.zxj.wukong.repository.local.dao

import androidx.room.*
import com.zxj.wukong.data.CaseInfo

@Dao
interface ShoppingCartDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(caseInfo: CaseInfo)



    @Query("select * from caseInfo order by `index`")
    fun queryAllByIndex(): List<CaseInfo>

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun update(caseInfo: CaseInfo)

    @Query("select count(id) from caseInfo")
    fun count(): Int

    @Delete
    fun delete(caseInfo: CaseInfo)
}