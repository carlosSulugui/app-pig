package com.plusdesarrollo.mpxtoolkit.applist.usecase

import com.plusdesarrollo.mpxtoolkit.applist.data.local.GetLocationImp
import com.plusdesarrollo.mpxtoolkit.applist.data.repository.GetLocationRepo
import javax.inject.Inject

class LocationService @Inject constructor(
    private val getLocationRepo: GetLocationRepo
) {
    suspend operator fun invoke() = getLocationRepo.getLocation()
}