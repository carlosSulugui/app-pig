package com.plusdesarrollo.mpxtoolkit.applist.ui.home.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.plusdesarrollo.mpxtoolkit.applist.core.Result
import com.plusdesarrollo.mpxtoolkit.applist.data.model.TaskRemote
import com.plusdesarrollo.mpxtoolkit.applist.usecase.CreateTask
import com.plusdesarrollo.mpxtoolkit.applist.usecase.GetTask
import com.plusdesarrollo.mpxtoolkit.applist.utils.Success
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import retrofit2.http.Body
import javax.inject.Inject

@HiltViewModel
class TaskViewModel @Inject constructor(
    private val createTask: CreateTask,
    private val getTasks: GetTask,
) : ViewModel() {
    private var _status: MutableStateFlow<Success> = MutableStateFlow(Success.Loading(false))
    val success: MutableStateFlow<Success> = _status


    suspend fun getTask() {
        viewModelScope.launch {
            val response = getTasks()


            response.collect { either ->
                either.fold({ error ->
                    _status.value = Success.Failure(error.toString())
                }, { task ->
                    _status.value = Success.Loading(true)
                    _status.value = Success.SuccessFul(task)
                })

            }
        }
    }

    suspend fun createTasks(body: TaskRemote) {
        val response = createTask(body)
        viewModelScope.launch {
            response.collect { either ->
                either.fold({ error ->
                    _status.value = Success.Failure(error.toString())
                }, { task ->
                    _status.value = Success.Loading(true)
                    _status.value = Success.SuccessFul(task)
                })
            }
        }

    }
}