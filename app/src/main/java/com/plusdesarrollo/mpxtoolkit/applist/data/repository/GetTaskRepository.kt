package com.plusdesarrollo.mpxtoolkit.applist.data.repository

import arrow.core.Either
import com.plusdesarrollo.mpxtoolkit.applist.data.datasource.GetTaskRemoterDataSource
import com.plusdesarrollo.mpxtoolkit.applist.data.local.TaskListLocal
import com.plusdesarrollo.mpxtoolkit.applist.utils.Error
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetTaskRepository @Inject constructor(
    private val getTaskRemoterDataSource: GetTaskRemoterDataSource
) {
    suspend fun getTask() : Flow<Either<Error, TaskListLocal>> = flow {
        emit(getTaskRemoterDataSource.getTask())
    }
}