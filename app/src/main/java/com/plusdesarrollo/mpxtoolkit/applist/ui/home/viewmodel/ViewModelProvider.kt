package com.plusdesarrollo.mpxtoolkit.applist.ui.home.viewmodel

import android.location.Location
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.plusdesarrollo.mpxtoolkit.applist.data.model.ProvidersRemote
import com.plusdesarrollo.mpxtoolkit.applist.usecase.GetProvides
import com.plusdesarrollo.mpxtoolkit.applist.usecase.GetTask
import com.plusdesarrollo.mpxtoolkit.applist.usecase.LocationService
import com.plusdesarrollo.mpxtoolkit.applist.usecase.PostProvider
import com.plusdesarrollo.mpxtoolkit.applist.usecase.SearchProvider
import com.plusdesarrollo.mpxtoolkit.applist.utils.Success
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.internal.ChannelFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ViewModelProvider @Inject constructor(
    private val postProvider: PostProvider,
    private val getClients: GetProvides,
    private val searchProvider: SearchProvider,
    private val getTask: GetTask,
    private val locationService: LocationService,
) : ViewModel() {


    private val _success: MutableStateFlow<Success> = MutableStateFlow(Success.Loading(false))
    val success: StateFlow<Success> = _success


    fun createProvider(body: ProvidersRemote) {
        viewModelScope.launch {
            val response = postProvider(body)

            response.collect { res ->
                _success.value = Success.Loading(true)
                res.fold({ error ->
                    _success.value = Success.Loading(false)
                    _success.value = Success.Failure(error.toString())

                }, { result ->
                    _success.value = Success.Loading(false)
                    _success.value = Success.SuccessFul(result)
                })
            }

        }
    }

    fun getProvider() {
        viewModelScope.launch {
            val response = getClients()
            _success.value = Success.Loading(true)
            response.collect { res ->
                res.fold({ error ->
                    _success.value = Success.Loading(false)
                    _success.value = Success.Failure(error.toString())
                }, { result ->
                    _success.value = Success.Loading(false)
                    _success.value = Success.SuccessFul(result)
                })
            }
        }
    }

    fun getTasks() {
        viewModelScope.launch {
            val response = getTask()
            _success.value = Success.Loading(false)
            response.collect { task ->
                task.fold({ error ->
                    _success.value = Success.Failure(error.toString())
                }, { result ->
                    _success.value = Success.SuccessFul(result)
                })

            }

        }
    }


    fun getLocation(success: (Location) ->Unit) {
        viewModelScope.launch {
            val response = locationService.invoke()
            response.collect{ location ->
                success(location!!)
            }
        }
    }
}
