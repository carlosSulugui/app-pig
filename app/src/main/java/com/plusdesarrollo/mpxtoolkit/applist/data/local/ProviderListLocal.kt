package com.plusdesarrollo.mpxtoolkit.applist.data.local

data class ProviderListLocal(
    val providers: List<ProviderLocal> = listOf()
)


data class ProviderLocal(
    val name:String? = null,
    val phone:String? = null ,
    val id:String? = null,
    val price:String? = null,
    val weight:String? = null,
    val status:String? =  null,
    val photo:String? = null,
    val address:String? = null
)