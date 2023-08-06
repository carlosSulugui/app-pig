package com.plusdesarrollo.mpxtoolkit.applist.data.datasource

import arrow.core.Either
import com.plusdesarrollo.mpxtoolkit.applist.data.local.ProviderListLocal
import com.plusdesarrollo.mpxtoolkit.applist.data.local.ProviderLocal
import com.plusdesarrollo.mpxtoolkit.applist.utils.Error


interface GetProviderRemoteDataSource {

    suspend fun getProvider():Either<Error, ProviderListLocal>
}