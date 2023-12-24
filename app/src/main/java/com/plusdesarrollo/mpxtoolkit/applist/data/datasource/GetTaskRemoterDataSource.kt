package com.plusdesarrollo.mpxtoolkit.applist.data.datasource

import arrow.core.Either
import com.plusdesarrollo.mpxtoolkit.applist.data.local.TaskListLocal
import com.plusdesarrollo.mpxtoolkit.applist.data.model.TaskListRemote
import com.plusdesarrollo.mpxtoolkit.applist.utils.Error

interface GetTaskRemoterDataSource {
   suspend fun getTask (): Either<Error, TaskListLocal>
}