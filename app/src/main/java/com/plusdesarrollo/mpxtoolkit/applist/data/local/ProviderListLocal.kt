package com.plusdesarrollo.mpxtoolkit.applist.data.local

import com.google.gson.GsonBuilder

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
){
    companion object {
        fun toJson(provider: ProviderLocal): String {
            return GsonBuilder().create().toJson(provider)
        }

        fun fromJson(json: String): ProviderLocal {
            return GsonBuilder().create().fromJson(json, ProviderLocal::class.java)
        }
    }
}