package com.zxj.wukong.repository.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.zxj.wukong.data.CaseInfo
import com.zxj.wukong.repository.local.dao.ShoppingCartDao

@Database(entities = [CaseInfo::class],version = 1)
abstract class ShoppingCartDatabase :RoomDatabase() {
    abstract fun shoppingCartDao():ShoppingCartDao
}