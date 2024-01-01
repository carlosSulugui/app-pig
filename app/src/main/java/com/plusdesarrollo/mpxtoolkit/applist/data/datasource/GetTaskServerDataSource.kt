package com.plusdesarrollo.mpxtoolkit.applist.data.datasource

import arrow.core.Either
import com.plusdesarrollo.mpxtoolkit.applist.data.api.RemoteService
import com.plusdesarrollo.mpxtoolkit.applist.data.local.ProviderListLocal
import com.plusdesarrollo.mpxtoolkit.applist.data.local.ProviderLocal
import com.plusdesarrollo.mpxtoolkit.applist.data.local.TaskListLocal
import com.plusdesarrollo.mpxtoolkit.applist.data.local.TasksLocal
import com.plusdesarrollo.mpxtoolkit.applist.data.model.ProviderListRemote
import com.plusdesarrollo.mpxtoolkit.applist.data.model.ProvidersRemote
import com.plusdesarrollo.mpxtoolkit.applist.data.model.TaskListRemote
import com.plusdesarrollo.mpxtoolkit.applist.data.model.TaskRemote
import com.plusdesarrollo.mpxtoolkit.applist.utils.Error
import com.plusdesarrollo.mpxtoolkit.applist.utils.tryCall
import javax.inject.Inject

class GetTaskServerDataSource @Inject constructor(
    private val remoteService: RemoteService
): GetTaskRemoterDataSource {
    override suspend fun getTask(): Either<Error, TaskListLocal> = tryCall {
        val response = remoteService.getTask()

        response.let { task ->
            task.body()?.toDomainModel()
        }!!
    }
}



private fun TaskListRemote.toDomainModel() =
    TaskListLocal(
        tasks!!.map {
            it.toDomainModel()
        }
    )

private fun TaskRemote.toDomainModel() =
    TasksLocal(
        name = name,
        id = id,
        address = address,
        status = status,
        created_at = created_at,
    )

