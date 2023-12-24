package com.plusdesarrollo.mpxtoolkit.applist.data.local

data class TaskListLocal(
    val tasks:List<TasksLocal>  = listOf()
)


data class TasksLocal(
    val name: String,
    val address: String,
    val status: String,
    val id:String,
    val created_at:String,
)


