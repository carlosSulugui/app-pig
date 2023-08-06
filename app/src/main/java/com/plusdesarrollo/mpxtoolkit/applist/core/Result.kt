package com.plusdesarrollo.mpxtoolkit.applist.core

import com.plusdesarrollo.mpxtoolkit.applist.data.local.ProviderLocal

sealed class Result{
    object Init: Result()
    data class Success(val json: List<ProviderLocal> ): Result()
    data class Failure(val error: String): Result()
}
