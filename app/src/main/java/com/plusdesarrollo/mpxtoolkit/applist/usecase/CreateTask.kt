package com.plusdesarrollo.mpxtoolkit.applist.usecase

import com.plusdesarrollo.mpxtoolkit.applist.data.model.TaskRemote
import com.plusdesarrollo.mpxtoolkit.applist.data.repository.CreateTaskRepository
import javax.inject.Inject

class CreateTask@Inject constructor(
    private val createTaskRepository: CreateTaskRepository
) {
    suspend operator fun invoke(task:TaskRemote) = createTaskRepository.createTask(task)
}