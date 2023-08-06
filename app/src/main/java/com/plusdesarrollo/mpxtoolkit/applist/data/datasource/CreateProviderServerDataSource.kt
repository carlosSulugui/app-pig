package com.plusdesarrollo.mpxtoolkit.applist.data.datasource

import arrow.core.Either

import com.plusdesarrollo.mpxtoolkit.applist.data.api.RemoteService
import com.plusdesarrollo.mpxtoolkit.applist.data.local.Message
import com.plusdesarrollo.mpxtoolkit.applist.data.model.ProvidersRemote
import com.plusdesarrollo.mpxtoolkit.applist.data.model.ResponseProvider
import com.plusdesarrollo.mpxtoolkit.applist.utils.Error

import com.plusdesarrollo.mpxtoolkit.applist.utils.tryCall
import javax.inject.Inject

class CreateProviderServerDataSource @Inject constructor(
   private val remoteService: RemoteService,
) : CreateProviderRemoteDataSource {
    override suspend fun createProvider(body: ProvidersRemote): Either<Error, Message> = tryCall {

        remoteService.setProvides(body).body()?.toMessage()!!


    }

}

fun ResponseProvider.toMessage(): Message {
    return Message(
        message
    )
}

