package com.plusdesarrollo.mpxtoolkit.applist.data.model


data class ProviderListRemote(
    val providers: List<ProvidersRemote>? = ArrayList()
)



data class ProvidersRemote(

    val name:String? = null,
    val phone:String? = null ,
    val task_id:String? = null,
    val price:Double? = null,
    val weight:Int? = 0,
    val status:String? = null,
    val photo:String? = null,
    val address:String? =null
)






