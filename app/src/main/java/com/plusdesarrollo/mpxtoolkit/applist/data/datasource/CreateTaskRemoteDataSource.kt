package com.plusdesarrollo.mpxtoolkit.applist.data.datasource

import arrow.core.Either
import com.plusdesarrollo.mpxtoolkit.applist.core.Message
import com.plusdesarrollo.mpxtoolkit.applist.data.model.TaskRemote
import com.plusdesarrollo.mpxtoolkit.applist.utils.Error

interface  CreateTaskRemoteDataSource {
   suspend fun createTask(task: TaskRemote): Either<Error , Message>
}