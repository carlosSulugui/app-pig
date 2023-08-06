package com.plusdesarrollo.mpxtoolkit.applist.utils

sealed class ProviderResponse {
    object Init:ProviderResponse()
    data class Loading(val isLoading:Boolean):ProviderResponse()
    data class Success<T>(val data : T ):ProviderResponse()
    data class Failure(val message:String):ProviderResponse()
    data class GetProvider<T>(val data: T): ProviderResponse()
}





sealed class Success{
    data class Loading(val isLoading: Boolean ): Success()
    data class SuccessFul<T> (val data: T?):Success()
    data class Failure(val error: String): Success()
}