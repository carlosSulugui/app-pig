package com.plusdesarrollo.mpxtoolkit.applist.usecase

import com.plusdesarrollo.mpxtoolkit.applist.data.repository.SearchProviderRepository
import javax.inject.Inject

class SearchProvider @Inject constructor(
    private val searchProviderRepository: SearchProviderRepository
) {
    suspend operator fun invoke(name: String) = searchProviderRepository.searchProvider(name)
}