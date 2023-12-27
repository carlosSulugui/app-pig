package com.plusdesarrollo.mpxtoolkit.applist.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.plusdesarrollo.mpxtoolkit.applist.database.dao.ProvidesDao
import com.plusdesarrollo.mpxtoolkit.applist.database.model.ProvidesEntity

@Database(entities = [ProvidesEntity::class], version = 1)
abstract class ProvidersDataBase:RoomDatabase() {
    abstract fun providesDao(): ProvidesDao
}