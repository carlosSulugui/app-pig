package com.plusdesarrollo.mpxtoolkit.applist.data.repository

import android.location.Location
import com.plusdesarrollo.mpxtoolkit.applist.data.local.GetLocationImp
import kotlinx.coroutines.flow.flow
import java.util.concurrent.Flow
import javax.inject.Inject

class GetLocationRepo @Inject constructor(
    private val getLocationImp: GetLocationImp
) {
    suspend fun getLocation() = flow {
        emit(getLocationImp.getLocation())
    }
}