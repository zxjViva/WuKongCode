package com.zxj.wukong.repository.local

import androidx.room.Room
import com.zxj.wukong.BaseApplication
import com.zxj.wukong.repository.local.dao.CaseDao
import com.zxj.wukong.repository.local.dao.ShoppingCartDao
import com.zxj.wukong.repository.local.db.CasesDatabase

object DbManager {
    val shoppingCartDao:ShoppingCartDao by lazy {
        Room.databaseBuilder(BaseApplication.instance,
            CasesDatabase::class.java,
            "ShoppingCartDatabase").build().shoppingCartDao()
    }
    val casesDao:CaseDao by lazy {
        Room.databaseBuilder(BaseApplication.instance,
            CasesDatabase::class.java,
            "ShoppingCartDatabase").build().caseDao()
    }
}