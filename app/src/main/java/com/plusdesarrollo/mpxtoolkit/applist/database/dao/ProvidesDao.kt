package com.plusdesarrollo.mpxtoolkit.applist.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.plusdesarrollo.mpxtoolkit.applist.database.model.ProvidesEntity

@Dao
interface ProvidesDao {
    @Query("select * from providers ORDER BY name desc")
    fun getAllProviders() : List<ProvidesEntity>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(providers: List<ProvidesEntity>)
}