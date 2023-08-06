package com.plusdesarrollo.mpxtoolkit.applist.data.datasource

import arrow.core.Either
import com.plusdesarrollo.mpxtoolkit.applist.data.local.ProviderListLocal
import com.plusdesarrollo.mpxtoolkit.applist.utils.Error

interface SearchProviderDataSource {
    suspend fun searchProvider(name: String): Either<Error, ProviderListLocal>
}