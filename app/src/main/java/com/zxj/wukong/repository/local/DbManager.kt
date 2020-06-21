package com.zxj.wukong.repository.local

import androidx.room.Room
import com.zxj.wukong.BaseApplication
import com.zxj.wukong.repository.local.dao.ShoppingCartDao
import com.zxj.wukong.repository.local.db.ShoppingCartDatabase

object DbManager {
    val shoppingCartDao:ShoppingCartDao by lazy {
        Room.databaseBuilder(BaseApplication.instance,
            ShoppingCartDatabase::class.java,
            "ShoppingCartDatabase").build().shoppingCartDao()
    }
}