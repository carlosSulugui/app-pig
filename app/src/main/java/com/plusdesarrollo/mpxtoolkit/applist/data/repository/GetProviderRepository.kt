package com.plusdesarrollo.mpxtoolkit.applist.data.repository

import arrow.core.Either
import com.plusdesarrollo.mpxtoolkit.applist.data.datasource.GetProviderServerDataSource
import com.plusdesarrollo.mpxtoolkit.applist.data.local.ProviderListLocal
import com.plusdesarrollo.mpxtoolkit.applist.utils.Error
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetProviderRepository @Inject constructor(
    private val getProviderServerDataSource: GetProviderServerDataSource,
) {
    suspend fun getProvider(): Flow<Either<Error, ProviderListLocal>> = flow {


            emit(getProviderServerDataSource.getProvider())

    }
}