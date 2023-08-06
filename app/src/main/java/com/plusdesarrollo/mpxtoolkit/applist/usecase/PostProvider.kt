package com.plusdesarrollo.mpxtoolkit.applist.usecase

import com.plusdesarrollo.mpxtoolkit.applist.data.model.ProvidersRemote
import com.plusdesarrollo.mpxtoolkit.applist.data.repository.ProviderRepository
import javax.inject.Inject

class PostProvider @Inject constructor(
    private val providerRepository: ProviderRepository
) {
  suspend operator fun invoke(body:ProvidersRemote) = providerRepository.createProvider(body)
}