package com.plusdesarrollo.mpxtoolkit.applist.core

data class Message(
    val success: MessageTask,
)

data class MessageTask (
    val message:String? = null
)