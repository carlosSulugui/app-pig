package com.plusdesarrollo.mpxtoolkit.applist.data.repository

import arrow.core.Either
import com.plusdesarrollo.mpxtoolkit.applist.data.datasource.SearchProviderServerDataSource
import com.plusdesarrollo.mpxtoolkit.applist.data.local.ProviderListLocal
import com.plusdesarrollo.mpxtoolkit.applist.utils.Error
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class SearchProviderRepository @Inject constructor(
    private val searchProviderServerDataSource: SearchProviderServerDataSource
) {
    suspend fun searchProvider(name:String):Flow<Either<Error, ProviderListLocal>> =flow{
        emit(searchProviderServerDataSource.searchProvider(name))
    }
}