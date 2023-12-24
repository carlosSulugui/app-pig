package com.plusdesarrollo.mpxtoolkit.applist.data.model



data class TaskListRemote(
    val tasks:List<TaskRemote>?  = listOf()
)

data class TaskRemote(
    val name: String,
    val address: String,
    val status: String,
    val id:String,
    val created_at:String,
)