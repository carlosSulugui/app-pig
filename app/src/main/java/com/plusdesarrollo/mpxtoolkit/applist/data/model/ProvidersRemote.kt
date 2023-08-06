package com.plusdesarrollo.mpxtoolkit.applist.data.model


data class ProviderListRemote(
    val providers: List<ProvidersRemote>? = ArrayList()
)



data class ProvidersRemote(
    val _id: String? = null,
    val name: String? = null,
    val isCansel: Boolean = false,
    val price: Int? = null,
    val address:String? = null,
    val telephone:String? = null,
    val photo:String? = null,
    val weight:Int? = null,
    val __v: Int? = null
)
