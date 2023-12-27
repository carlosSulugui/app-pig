package com.plusdesarrollo.mpxtoolkit.applist.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "providers")
data class ProvidesEntity(

    @PrimaryKey(autoGenerate = true)

   @ColumnInfo("id") val id:Int? = 0,
    @ColumnInfo("name")
    val name:String? = null,
    @ColumnInfo("phone")
    val phone:String? = null ,
    @ColumnInfo("task_id")
    val task_id:String? = null,
    @ColumnInfo("price")
    val price:Double? = null,
    @ColumnInfo("weight")
    val weight:Int? = 0,
    @ColumnInfo("status")
    val status:String? = null,
    @ColumnInfo("photo")
    val photo:String? = null,
    @ColumnInfo("address")
    val address:String? =null
)