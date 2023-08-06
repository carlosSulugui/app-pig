package com.plusdesarrollo.mpxtoolkit.applist.usecase

import com.plusdesarrollo.mpxtoolkit.applist.data.repository.GetProviderRepository
import javax.inject.Inject

class GetProvides @Inject constructor(
    private val getProviderRepository: GetProviderRepository
) {
    suspend operator fun invoke() = getProviderRepository.getProvider()

}