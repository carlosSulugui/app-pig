package com.plusdesarrollo.mpxtoolkit.applist.usecase

import com.plusdesarrollo.mpxtoolkit.applist.data.datasource.GetTaskRemoterDataSource
import com.plusdesarrollo.mpxtoolkit.applist.data.repository.GetTaskRepository
import javax.inject.Inject

class GetTask @Inject constructor(
    private val getTaskRepository: GetTaskRepository
){
    suspend operator fun invoke() = getTaskRepository.getTask()
}