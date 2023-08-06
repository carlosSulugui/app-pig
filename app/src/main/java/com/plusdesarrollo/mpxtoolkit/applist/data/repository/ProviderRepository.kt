package com.plusdesarrollo.mpxtoolkit.applist.data.repository

import arrow.core.Either
import com.plusdesarrollo.mpxtoolkit.applist.data.datasource.CreateProviderServerDataSource
import com.plusdesarrollo.mpxtoolkit.applist.data.local.Message
import com.plusdesarrollo.mpxtoolkit.applist.data.model.ProvidersRemote
import com.plusdesarrollo.mpxtoolkit.applist.utils.Error
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ProviderRepository @Inject constructor(
    private val createProviderServerDataSource: CreateProviderServerDataSource
) {
    suspend fun createProvider(body:ProvidersRemote):Flow<Either<Error, Message>> = flow {
        emit(createProviderServerDataSource.createProvider(body))
    }

}