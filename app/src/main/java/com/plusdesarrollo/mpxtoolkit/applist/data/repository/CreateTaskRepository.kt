package com.plusdesarrollo.mpxtoolkit.applist.data.repository

import arrow.core.Either
import com.plusdesarrollo.mpxtoolkit.applist.core.Message
import com.plusdesarrollo.mpxtoolkit.applist.data.datasource.CreateTaskServerDataSource
import com.plusdesarrollo.mpxtoolkit.applist.data.model.TaskRemote
import com.plusdesarrollo.mpxtoolkit.applist.utils.Error
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class CreateTaskRepository @Inject constructor(
    private val createTaskServerDataSource: CreateTaskServerDataSource
) {
    suspend fun createTask(task:TaskRemote) : Flow<Either<Error, Message>> = flow{
        emit(createTaskServerDataSource.createTask(task))
    }
}