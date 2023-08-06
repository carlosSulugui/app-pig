package com.plusdesarrollo.mpxtoolkit.applist.data.datasource

import arrow.core.Either
import com.plusdesarrollo.mpxtoolkit.applist.data.api.RemoteService
import com.plusdesarrollo.mpxtoolkit.applist.data.local.ProviderListLocal
import com.plusdesarrollo.mpxtoolkit.applist.utils.Error
import com.plusdesarrollo.mpxtoolkit.applist.utils.tryCall
import javax.inject.Inject

class SearchProviderServerDataSource @Inject constructor(
    private val remoteService: RemoteService,
) : SearchProviderDataSource {
    override suspend fun searchProvider(name: String): Either<Error, ProviderListLocal> = tryCall {
        TODO()
    }

}







