package com.plusdesarrollo.mpxtoolkit.applist.core
data class Wrapper<T>(
    val isLoading:Boolean = false,
    val error:String,
    val data:List<T>? = listOf()
)

data class WrapperResponse<T>(
    val message: String,
    val success: Boolean,
    val data:T,
    val token:String? = ""
)
