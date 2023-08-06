package com.plusdesarrollo.mpxtoolkit.applist.data.datasource

import arrow.core.Either
import com.plusdesarrollo.mpxtoolkit.applist.data.local.Message


import com.plusdesarrollo.mpxtoolkit.applist.data.model.ProvidersRemote
import com.plusdesarrollo.mpxtoolkit.applist.utils.Error


interface CreateProviderRemoteDataSource {


    suspend fun createProvider(body: ProvidersRemote):Either<Error,  Message >
}