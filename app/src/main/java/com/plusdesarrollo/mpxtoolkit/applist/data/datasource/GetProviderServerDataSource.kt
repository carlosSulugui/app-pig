package com.plusdesarrollo.mpxtoolkit.applist.data.datasource

import arrow.core.Either
import com.plusdesarrollo.mpxtoolkit.applist.data.api.RemoteService
import com.plusdesarrollo.mpxtoolkit.applist.data.local.ProviderListLocal
import com.plusdesarrollo.mpxtoolkit.applist.data.local.ProviderLocal
import com.plusdesarrollo.mpxtoolkit.applist.data.model.ProviderListRemote
import com.plusdesarrollo.mpxtoolkit.applist.data.model.ProvidersRemote
import com.plusdesarrollo.mpxtoolkit.applist.utils.Error
import com.plusdesarrollo.mpxtoolkit.applist.utils.tryCall
import javax.inject.Inject

class GetProviderServerDataSource @Inject constructor(
    private val remoteService: RemoteService,
) : GetProviderRemoteDataSource {
    override suspend fun getProvider(): Either<Error, ProviderListLocal>  = tryCall {

        val response = remoteService.getProvides()

        response.let { provider ->
            provider.body()?.toDomainModel()
        }!!

    }
}

//mapper remote to local model

//mapper remote to local model
private fun ProviderListRemote.toDomainModel() =
    ProviderListLocal(
        providers!!.map {
            it.toDomainModel()
        }
    )


fun ProvidersRemote.toDomainModel() =
    ProviderLocal(
        name, phone, task_id, price?.toString(), weight?.toString(), status, photo, address
    )