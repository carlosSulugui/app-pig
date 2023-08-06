package com.plusdesarrollo.mpxtoolkit.applist.utils

sealed class Error{
    object Connectivity:Error()
    data class Server(val code: Int):Error()
    data class Unknow(val message:String):Error()

}