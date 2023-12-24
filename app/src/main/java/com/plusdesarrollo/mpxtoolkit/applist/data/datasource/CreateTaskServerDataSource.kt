package com.plusdesarrollo.mpxtoolkit.applist.data.datasource

import arrow.core.Either
import com.plusdesarrollo.mpxtoolkit.applist.core.Message
import com.plusdesarrollo.mpxtoolkit.applist.data.api.RemoteService
import com.plusdesarrollo.mpxtoolkit.applist.data.model.TaskRemote
import com.plusdesarrollo.mpxtoolkit.applist.utils.Error
import com.plusdesarrollo.mpxtoolkit.applist.utils.tryCall
import javax.inject.Inject

class CreateTaskServerDataSource @Inject constructor(
    private val remoteService: RemoteService
): CreateTaskRemoteDataSource {
    override suspend fun createTask(task: TaskRemote): Either<Error,Message> = tryCall{
        val response = remoteService.setTask(task)
        response.body()!!
    }
}